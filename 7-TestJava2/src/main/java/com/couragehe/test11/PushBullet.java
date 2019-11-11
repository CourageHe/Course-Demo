package com.couragehe.test11;
/**
 * 压入子弹线程
 * @author CourageHe
 *
 */
public class PushBullet implements Runnable {
	private Gun gun;
	
	public PushBullet(Gun gun) {
		super();
		this.gun = gun;
	}

	public void run() {
		try {
			while(true){
				synchronized (gun.bullets) {
					Thread.currentThread().sleep(500);
					while(gun.size() == 12) {	
							gun.bullets.wait();
					}
					gun.bullets.notifyAll();
					gun.pushBullet();
					System.out.println("Push Bullet ..."+gun.size());
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
