package com.couragehe.test6;
/**
 * 现在多数学校的成绩管理都由计算机进行管理，这就需要有相应的应用程序。编写成绩管理应用程序，
 * 其中有成绩录入模块， 成绩录入过程中，难免出现录入数据的类型出现错误，或录入的成绩不在合理的范围。
 * 在成绩录入过程中，若出现上述错误，程序应该如何处理。
 * @author CourageHe
 *
 */
import javax.swing.JOptionPane;

/**
 * 负分异常
 */
class NegativeException  extends Exception   //当录入了负分时。此处应用了自定义异常
{
	NegativeException(int i){
		System.out.println("分数为负数");
	}



}
class HighException extends Exception  //当录入分超过100时。应用了自定义异常
{
	HighException (int i ){
		System.out.println("分数过高");
	}
	
}
public class ExceptionDemo
{
	static final int number=2;
	int scores[]=new int[number];
	public void checkScore(int score) throws NegativeException,HighException     //下面方法中判断如果录入的成绩不合理，则抛出异常，但本方法并不处理异常，仅声明了异常
	{	if(score >100) throw new HighException (score);   //通过throw，人工抛出异常       
		if(score<0) throw new NegativeException(score);
	}
	public void enterScores()
{       int i;
		for(i=0;i<number;i++){  
			try{
				scores[i]=Integer.parseInt(JOptionPane.showInputDialog("请输入第"+(i+1)+"个同学的成绩"));
		   }catch(NumberFormatException e){    //在try{…….}catch间的语句中若产生异常，则捕获异常，直接进行异常处理    
				System.out.println(e);
		   }
		  try{ 
			  checkScore(scores[i]);       //在检查分数模块中，可能产生高分异常对象，也可能产生低分异常对象，根据不同情况，进行不同处理
		  }catch(HighException e) {
			System.out.println(e);
		  }catch(NegativeException e){
			System.out.println(e);
		}
       }
	}
	public void printScore()
	{

		System.out.println(scores[0]);
		System.out.println(scores[1]);




	}
	public static void main(String arg[])
	{	
		ExceptionDemo demo = new ExceptionDemo();	
		demo.enterScores();
		demo.printScore();
	}
}
