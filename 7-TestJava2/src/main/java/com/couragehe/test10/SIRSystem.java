package com.couragehe.test10;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
/**
 * 学生信息注册界面信息
 * @author CourageHe
 *
 */
public class SIRSystem extends JFrame {

	private JPanel contentPane;
	private JTextArea console ;
	private JTextArea name;
	private JComboBox city ;
	private JCheckBox sport;
	private JCheckBox music;
	private JCheckBox art;
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup group;
	private static int count = 0;
	
	
	private String[] cities = {"武汉", "荆州", "鄂州"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SIRSystem frame = new SIRSystem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SIRSystem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		console = new JTextArea();
		console.setBounds(0, 259, 563, 270);
		contentPane.add(console);
		
		JLabel label = new JLabel("姓名：");
		label.setBounds(28, 32, 72, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("性别：");
		label_1.setBounds(28, 97, 72, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("爱好：");
		label_2.setBounds(28, 142, 72, 18);
		contentPane.add(label_2);
		
		name = new JTextArea();
		name.setBounds(91, 23, 114, 27);
		contentPane.add(name);
		
		JLabel label_3 = new JLabel("籍贯：");
		label_3.setBounds(28, 193, 72, 18);
		contentPane.add(label_3);
		
		city = new JComboBox();
		
		city.setModel(new DefaultComboBoxModel(cities));
		city.setBounds(119, 190, 125, 24);
		contentPane.add(city);
		
		sport = new JCheckBox("体育");
		sport.setBounds(89, 138, 89, 27);
		contentPane.add(sport);
		
		music = new JCheckBox("音乐");
		music.setBounds(175, 138, 89, 27);
		contentPane.add(music);
		
		art = new JCheckBox("美术");
		art.setBounds(270, 138, 89, 27);
		contentPane.add(art);
		
		male = new JRadioButton("男");
		male.setBounds(89, 93, 89, 27);
		contentPane.add(male);
		
		female = new JRadioButton("女");
		female.setBounds(184, 93, 89, 27);
		contentPane.add(female);
		group = new ButtonGroup();
		group.add(male);
		group.add(female);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				count++;
				String sname =  name.getText();
				String  scity = cities[city.getSelectedIndex()]; 
				String sSport = sport.isSelected()? sport.getText():"";
				String sMusic = music.isSelected()? music.getText():"";
				System.out.println(sMusic);
				String sArt = art.isSelected()?art.getText():"";
				String sSex= "";
				Enumeration elements = group.getElements();
				
				while(elements.hasMoreElements()) {
					JRadioButton button = (JRadioButton)elements.nextElement();
					if(button.isSelected()) {
						sSex = button.getText();
						break;
					}
				}
				String studentInfo = String.format("\n第%d名同学的输入信息为：\n姓名：%s 性别：%s 爱好：%s,%s,%s 籍贯：%s \n", count,sname,sSex,sSport,sMusic,sArt,scity);
				console.append(studentInfo);
			}
			
		});
		btnNewButton.setBounds(384, 219, 113, 27);
		contentPane.add(btnNewButton);
	}
}
