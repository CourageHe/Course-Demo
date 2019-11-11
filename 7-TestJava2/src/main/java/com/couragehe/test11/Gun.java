package com.couragehe.test11;

import java.util.ArrayList;
import java.util.List;

/**
 * 枪
 * @author CourageHe
 *
 */
public class Gun {
	//临界资源
	protected final List<Bullet> bullets = new ArrayList<Bullet>();
	
	public int size() {
		return bullets.size();
	}
	public  void pushBullet() {
		bullets.add(new Bullet());
		
	}
	public   void pullBullet() {
		bullets.remove(0);
	}
	protected int count;
	public Gun() {
		int count = 0;
	}
	
	//子弹
	class Bullet{
		
	}
}
