package com.couragehe.test11;

import java.util.List;

import com.couragehe.test11.Gun.Bullet;

/**
 * 射出子弹线程
 * @author CourageHe
 *
 */
public class PullBullet implements Runnable {

	private Gun gun;
	
	public PullBullet(Gun gun) {
		super();
		this.gun = gun;
	}

	public void run() {
		try {
			while(true){
				synchronized (gun.bullets) {
					Thread.currentThread().sleep(500);
					while(gun.size() == 0) {
							//弹夹(缓冲区)为空时，该线程等待，进入休眠状态	
							gun.bullets.wait();
					}
					//射出子弹就会唤醒线程
					gun.bullets.notifyAll();
					gun.pullBullet();
					System.out.println("Pull Bullet ..."+gun.size());
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
