package test16;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import Test14.Frame1;

public class Application {
	public Application( ){
		QuetySystem system = new QuetySystem();
	    // 使窗口居中
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    Dimension frameSize = system .getSize();
	    if (frameSize.height > screenSize.height){  
	    	frameSize.height = screenSize.height;  
	    }
	    if (frameSize.width > screenSize.width){ 
	    	frameSize.width = screenSize.width;  
	    }
	    //应用置中 
	    system.setLocation( (screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	    system.setVisible(true);
	}
	public static void main(String[] args) {
		new Application();
		
	}
}
