package com.couragehe.jswing;

public class PanelTest {
	public static void main(String[] args)
	{
		DrawingJframe frame =new DrawingJframe();
		frame.setVisible(true);
		while(true)
		{

			
			try
			
			{
				Thread.sleep(300);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}


}
