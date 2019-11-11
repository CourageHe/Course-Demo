package Test14;
import java.awt.*;
import javax.swing.*;
public class Application1{
	public Application1( ){
	    Frame1 frame = new Frame1();
	    // 使窗口居中
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    Dimension frameSize = frame.getSize();
	    if (frameSize.height > screenSize.height){  
	    	frameSize.height = screenSize.height;  
	    }
	    if (frameSize.width > screenSize.width){ 
	    	frameSize.width = screenSize.width;  
	    }
	    //应用置中 
	    frame.setLocation( (screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	    frame.setVisible(true);
	}
	//主程序的main()方法
	public static void main(String[] args){ 
		new Application1( );      
	}     
}
