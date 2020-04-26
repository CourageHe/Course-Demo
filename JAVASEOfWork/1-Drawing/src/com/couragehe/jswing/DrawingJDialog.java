package com.couragehe.jswing;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.LineBorder;

public class DrawingJDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private DrawingJDialog dialog;
	private final JPanel contentPanel = new JPanel();
	private Point point;
	private JTextField pointX;
	private JTextField pointY;
	private JTextField width;
	private JTextField height;
	private JTextField BorderWidth;
	private JButton okButton = new JButton("确认");
	private JButton cancelButton = new JButton("取消");
	private JButton BorderColorBtn = new JButton("线条颜色");
	private JButton FillColorBtn = new JButton("选取颜色");
	private JComboBox shapeTypes = new JComboBox();
	private JList FillTypes = new JList();
	private JList BorderTypes = new JList();
	
	protected int ShapeType;
	protected int pointX0;
	protected int pointY0;
	protected int width0;
	protected int height0;
	protected Color BorderColor;
	protected int BorderType;
	protected int BorderWidth0;
	protected Color FillColor;
	protected int FillType;

	
	public DrawingJDialog getDialog() {
		return dialog;
	}
	public void setDialog(DrawingJDialog dialog) {
		this.dialog = dialog;
	}
	/**
	 * Create the dialog.
	 */
	public DrawingJDialog(Point p) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("图元属性对话框");
		setBounds(100, 100, 775, 574);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.point = p;
		init();//页面初始化
		Listener();//监听器
	}
	public void init(){
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.ORANGE));
		panel.setBounds(94, 136, 258, 290);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.ORANGE));
		panel_1.setBounds(409, 100, 329, 164);
		contentPanel.setLayout(null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u539F\u70B9X");
		lblNewLabel.setBounds(14, 27, 72, 18);
		panel.add(lblNewLabel);
		
		JLabel lbly = new JLabel("\u539F\u70B9Y");
		lbly.setBounds(14, 87, 72, 18);
		panel.add(lbly);
		
		JLabel label_1 = new JLabel("\u5BBD\u5EA6");
		label_1.setBounds(14, 154, 72, 18);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u9AD8\u5EA6");
		label_2.setBounds(14, 231, 72, 18);
		panel.add(label_2);
		
		pointX = new JTextField();
		pointX.setText(point.getX()+"");
		pointX.setBounds(80, 22, 147, 24);
		panel.add(pointX);
		pointX.setColumns(10);
		
		pointY = new JTextField();
		pointY.setText(point.getY()+"");
		pointY.setColumns(10);
		pointY.setBounds(80, 84, 147, 24);
		panel.add(pointY);
		
		width = new JTextField();
		width.setText("0");
		width.setColumns(10);
		width.setBounds(80, 151, 147, 24);
		panel.add(width);
		
		height = new JTextField();
		height.setText("0");
		height.setColumns(10);
		height.setBounds(80, 228, 147, 24);
		panel.add(height);
		
		JLabel label = new JLabel("\u5F62\u72B6\u53C2\u6570");
		label.setBounds(0, 0, 72, 18);
		panel.add(label);
		contentPanel.add(panel);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_3 = new JLabel("\u5F62\u72B6\u53C2\u6570");
		label_3.setBounds(0, 0, 60, 18);
		panel_1.add(label_3);
		
		BorderWidth = new JTextField();
		BorderWidth.setText("0");
		BorderWidth.setColumns(10);
		BorderWidth.setBounds(76, 25, 60, 24);
		panel_1.add(BorderWidth);
		
		JLabel label_4 = new JLabel("线宽"); 
		label_4.setBounds(10, 30, 50, 18);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("\u7EBF\u578B");
		label_5.setBounds(10, 86, 50, 18);
		panel_1.add(label_5);
		
		JLabel label_9 = new JLabel("\u7EBF\u8272");
		label_9.setBounds(178, 28, 50, 18);
		panel_1.add(label_9);
		
		
		BorderColorBtn.setBounds(219, 24, 96, 27);
		panel_1.add(BorderColorBtn);
		
		
		BorderTypes.setForeground(Color.BLACK);
		BorderTypes.setBorder(new LineBorder(Color.BLACK));
		BorderTypes.setModel(new AbstractListModel() {
			String[] values = new String[] {"DASH", "DASHDOT", "SOLID"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		BorderTypes.setBackground(Color.WHITE);
		BorderTypes.setBounds(76, 62, 104, 89);
		panel_1.add(BorderTypes);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.ORANGE));
		panel_2.setLayout(null);
		panel_2.setBounds(409, 289, 329, 164);
		contentPanel.add(panel_2);
		
		JLabel label_6 = new JLabel("\u586B\u5145\u98CE\u683C");
		label_6.setBounds(0, 0, 60, 18);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("\u586B\u5145\u98CE\u683C");
		label_7.setBounds(10, 30, 67, 18);
		panel_2.add(label_7);
		

		
		FillColorBtn.setBounds(219, 26, 96, 27);
		panel_2.add(FillColorBtn);
		
		JLabel label_8 = new JLabel("填充色");
		label_8.setBounds(167, 30, 50, 18);
		panel_2.add(label_8);
		

		FillTypes.setModel(new AbstractListModel() {
			String[] values = new String[] {"BDIALOGAL", "CROSS", "SOLID"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		FillTypes.setForeground(Color.BLACK);
		FillTypes.setBorder(new LineBorder(Color.BLACK));
		FillTypes.setBackground(Color.WHITE);
		FillTypes.setBounds(70, 29, 96, 89);
		panel_2.add(FillTypes);
		
		JLabel lblTua = new JLabel("图元类型");
		lblTua.setBounds(31, 33, 67, 18);
		contentPanel.add(lblTua);
		

		shapeTypes.setModel(new DefaultComboBoxModel(new String[] {"Square", "Rectangel", "Circle", "Ellipse", "Triangle", "Text"}));
		shapeTypes.setMaximumRowCount(6);
		shapeTypes.setBounds(112, 30, 110, 24);
		contentPanel.add(shapeTypes);
		
		JPanel buttonPane = new JPanel();
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		buttonPane.add(okButton);
		buttonPane.add(cancelButton);
	}
	public void Listener(){
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("确认");
				pointX0 = Double.valueOf(pointX.getText()).intValue();
				pointY0 = Double.valueOf(pointY.getText()).intValue();
				height0 = Integer.parseInt(height.getText());
				width0 = Integer.parseInt(width.getText());
				BorderWidth0 = Integer.parseInt(BorderWidth.getText());
				ShapeType = shapeTypes.getSelectedIndex();
				BorderType = BorderTypes.getSelectedIndex();
//				BorderColor;
//				FillColor;
				System.out.println("确认类型："+ ShapeType);
//				dialog.setVisible(false);
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("取消");
				System.exit(0);
			}
		});
		BorderColorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 // 显示颜色选取器对话框, 返回选取的颜色（线程将被阻塞, 直到对话框被关闭）
                Color BorderColor = JColorChooser.showDialog(contentPanel , "填充颜色", null);

                // 如果用户取消或关闭窗口, 则返回的 color 为 null
                if (BorderColor == null) {
                    return;
                }
			}
		});
		FillColorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 // 显示颜色选取器对话框, 返回选取的颜色（线程将被阻塞, 直到对话框被关闭）
                Color FillColor = JColorChooser.showDialog(contentPanel , "填充颜色", null);
                System.out.println(FillColor);
                // 如果用户取消或关闭窗口, 则返回的 color 为 null
                if (FillColor == null) {
                    return;
                }
			}
		});
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DrawingJDialog dialog = new DrawingJDialog(new Point(23,24));
			dialog.setDialog(dialog);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
