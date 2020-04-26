package com.couragehe.test5;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/***
 * 该题目与实验室雷同，作此说明暂时不咯
 * @author CourageHe
 *
 */
public class BCOption
{	
	Vector vec=new Vector();       //对象声明与实例化
   	static int count=0;            //类中静态变量的定义
    public void kaihu(BankCount bc) //方法体，实现开户功能                      //实例方法
    {
    	vec.add(bc);
    	count++;
      


}
      public void moneyOut(int id, float outmoney) //方法体，实现取钱功能
      {
    	  //枚举遍历集合
    	  Enumeration<BankCount> enume = vec.elements();
    	  BankCount bc = null ;
    	  while(enume.hasMoreElements()) {
    		  bc = enume.nextElement();
    		  if(bc.getId() == id) {
    			  break;
    		  }
    	  }
    	  //余额
    	  float balance = bc.getMoney();
    	  bc.setMoney(balance-outmoney);
       



}
      public void moneyIn(int id, float inmoney)
     {//方法体，实现存钱功能
    	  //枚举遍历集合
    	  Enumeration<BankCount> enume = vec.elements();
    	  BankCount bc = null ;
    	  while(enume.hasMoreElements()) {
    		  bc = enume.nextElement();
    		  if(bc.getId() == id) {
    			  break;
    		  }
    	  }
    	  //余额
    	  float balance = bc.getMoney();
    	  bc.setMoney(balance+inmoney);

        


}
   public void query(int id)
   {//方法体，查询并输出账户信息
   
	   //迭代器方法遍历
	   Iterator<BankCount>it = vec.iterator();
	   BankCount bc = null ;
	   while(it.hasNext()) {
		   bc = it.next();
		   if(bc.getId()== id) {
			   break;
		   }
	   }
	   System.out.println("账户信息："+bc);



}
    public static void main(String args[])
    {//实现账户的相关操作
           BCOption bco = new BCOption();
           bco.kaihu(new BankCount(1,"CourageHe","19/11/5",12));
           bco.query(0);
        }

}
