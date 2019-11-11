package test16;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class QuetySystem extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField sid;
	JButton btn_fail = new JButton("未通过名单");
	JButton btn_all = new JButton("成绩名次");
	JButton btn_id = new JButton("按考号查询");
	JTextArea showPane = new JTextArea();
	
	

	public  QuetySystem () {
		Init();
	}
	public void Init() {
		setTitle("成绩查询系统");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 588, 204);
		contentPane.add(panel);
		panel.setLayout(null);
		
		sid = new JTextField();
		sid.setBounds(148, 20, 224, 30);
		panel.add(sid);
		sid.setColumns(10);
		
	
		btn_fail.addActionListener(this);
		btn_fail.setBounds(148, 131, 148, 36);
		panel.add(btn_fail);
		
		JLabel lblNewLabel = new JLabel("考号：");
		lblNewLabel.setBounds(62, 26, 72, 18);
		panel.add(lblNewLabel);
		
		
		btn_all.addActionListener(this);
		
		btn_all.setBounds(148, 71, 148, 36);
		panel.add(btn_all);
		

		btn_id.addActionListener(this);
		btn_id.setBounds(410, 15, 148, 36);
		panel.add(btn_id);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 204, 584, 350);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(showPane);
		showPane.setEditable(false);
	}

	//按钮监听事件
	public void actionPerformed(ActionEvent e) {
		//查询不及格的
		if(e.getSource() == btn_fail) {
			showPane.setText("");
			List<Score> list = QueryDao.queryFailByScore();
			showPane.append("    学   号\t    姓   名\n");
			for(Score s:list) {
				showPane.append("  "+s.getSid()+"\t");
				showPane.append(s.getSname()+"\n");
				
			}
		}
		//查询所有成绩
		if(e.getSource() == btn_all) {
			showPane.setText("");
			List<Score> list = QueryDao.queryScoreByScore();
			showPane.append("    学   号\t    姓   名\t成 绩\t名次\n");
			int i = 0;
			for(Score s:list) {
				showPane.append("  "+s.getSid()+"\t");
				showPane.append(s.getSname()+"\t");
				showPane.append(" "+s.getScore()+"\t");
				showPane.append("  "+i++ +"\n");
				
			}
		}
		//根据学号查询信息
		if(e.getSource() == btn_id) {
			showPane.setText("");
			Score s = QueryDao.queryScoreBySid(sid.getText());
			showPane.append("    学   号\t    姓   名\t成 绩\n");
			if(s.getSid()!=null) {
				showPane.append("  "+s.getSid()+"\t");
				showPane.append(s.getSname()+"\t");
				showPane.append(" "+s.getScore()+"\t");
			}else {
				showPane.append("学号输入有误！！！");
			}

		}
	}
}
