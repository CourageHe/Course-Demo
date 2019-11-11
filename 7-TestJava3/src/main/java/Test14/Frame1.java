package Test14;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class  Frame1 extends JFrame  implements ActionListener{
	  JPanel contentPane;
	  JScrollPane jScrollPane1 = new JScrollPane();
	  BorderLayout borderLayout1 = new BorderLayout();
	  JPanel jPanel1 = new JPanel();
	  JTextArea jTextArea1 = new JTextArea();
	  JButton jButton1 = new JButton("保存");
	  JButton jButton2 = new JButton("打开");
	//窗口的构造方法
	  public Frame1() 
	{	
		  //默认为ContentPanel
		  setLayout(borderLayout1);
		  
		  jButton1.addActionListener(this);
		  jButton2.addActionListener(this);
		  
		  add(jTextArea1,borderLayout1.CENTER);
		  add(jPanel1,borderLayout1.SOUTH);
		  //panel 流式布局
		  jPanel1.setLayout(new FlowLayout());
		  jPanel1.add(jButton1);
		  jPanel1.add(jButton2);
		  setBounds(200,200,600,600)
		  ;
		  //监测关机 应用自动关闭
		  addWindowListener(new WindowAdapter(){
			  public void windowClosing(WindowEvent e){
				  setVisible(false);
				  System.exit(0);
			  }
		  });





	      }
	  
	  //jbInit()方法完成界面的初始化设置
	  private void jbInit() throws Exception 
	{
	    













	  }
	//保存、打开两个按钮的事件处理方法
	  public void actionPerformed(ActionEvent e)
	{ //如果用户点击保存按钮
		  if(e.getSource()==jButton1){
		//swing封装的文件选择器
		  JFileChooser fc1=new JFileChooser();
		  int option = fc1.showSaveDialog(null);  // 显示文件对话框
		  
		  if(option == JFileChooser.APPROVE_OPTION) // 如果确认选取文件
		   {
		      File file = fc1.getSelectedFile();  // 取得选择的文件
		      setTitle(file.toString());  // 在标题栏上设定文件名称
		      try 
		      {
		        file.createNewFile(); // 建立文件
		       
		      }
		      catch(IOException e1) 
		      {
		       JOptionPane.showMessageDialog(null, e1.toString(),
		                   "无法建立新文件", JOptionPane.ERROR_MESSAGE);
		      }
		   }   
		  }
	//如果用户点击打开按钮
	    if(e.getSource()==jButton2)
	{
	     	jTextArea1.setText("");
	    	JFileChooser fc=new JFileChooser();
	    	int option1 =  fc.showDialog(null, null);
	        
	    	  // 使用者按下确认键
	    	  if(option1 == JFileChooser.APPROVE_OPTION) 
	    	  {
	    	     try 
	    	     {
	    	      // 开启选取的文件
	    	      BufferedReader buf = 
	    	       new BufferedReader(
	    	           new FileReader(
	    	           fc.getSelectedFile()));

	    	      setTitle(fc.getSelectedFile().toString());// 设定文件标题
	    	      jTextArea1.setText(""); // 清除前一次文件
	    	    
	    	               
	    	      String lineSeparator = System.getProperty("line.separator");
	    	      // 取得系统相依的换行字符        
	    	      String text;// 读取文件并附加至文字编辑区
	    	      while((text = buf.readLine()) != null) 
	    	     {
	    	    	  jTextArea1.append(text);
	    	    	  jTextArea1.append(lineSeparator);//添加换行符
	    	     }

	    	          buf.close();
	    	     }   
	    	     catch(IOException ee) 
	    	     {
	    	        JOptionPane.showMessageDialog(null, ee.toString(),
	    	         "开启文件失败", JOptionPane.ERROR_MESSAGE);
	    	     }



	   		 
	    	catch(Exception ex){
	      		System.out.print(ex.toString());
	    	}
	    }
	}
	}
}