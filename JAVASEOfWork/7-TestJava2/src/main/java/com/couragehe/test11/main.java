package com.couragehe.test11;
/**
 * 采用Java 多线程技术，设计实现一个符合生产者和消费者问题的程序。
 * 对一个对象（枪膛）进行操作，其最大容量是12颗子弹。生产者线程是一个压入线程，
 * 它不断向枪膛中压入子弹；消费者线程是一个射出线程，它不断从枪膛中射出子弹。
 * 
 * @author CourageHe
 *
 */
public class main {
	public static void main(String[]args) {
		Gun gun = new Gun();
		Thread push = new Thread(new PushBullet(gun));
		push.setName("push");
		push.start();
		
		Thread pull = new Thread(new PullBullet(gun));
		pull.setName("pull");
		pull.start();
		
	}
}
