package com.couragehe;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;

import org.junit.Test;

import edu.yangtzeu.lmis.gui.LoginFrame;

public class TestJFrame {
	@Test
	public void TestLogin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame login= new LoginFrame();
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
//		Frame login= new Login();
//	    // 使窗口居中
//	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//	    Dimension frameSize = login.getSize();
//	    if (frameSize.height > screenSize.height){  
//	    	frameSize.height = screenSize.height;  
//	    }
//	    if (frameSize.width > screenSize.width){ 
//	    	frameSize.width = screenSize.width;  
//	    }
//	    //应用置中 
//	    login.setLocation( (screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
//	    login.setVisible(true);
	}
}
