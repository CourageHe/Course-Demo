package com.couragehe;

public abstract class Support {
	private String name;
	private Support next;
	public Support(String name) {
		super();
		this.name = name;
	}
	public Support setNext(Support next) {
		this.next = next;
		return next;
	}
	public final void support(Trouble trouble) {
		if(resolve(trouble)) {
			done(trouble);
		}else if(next!= null) {
			next.support(trouble);
		}else {
			fail(trouble);
		}
	}
	protected abstract boolean resolve(Trouble trouble);
	
	protected void done(Trouble trouble) {
		System.out.println(trouble+"is resolved by"+this +".");
	}
	protected void fail(Trouble trouble) {
		System.out.println(trouble+"cannot be resolved");
	}
	@Override
	public String toString() {
		return "Support [name=" + name + "]";
	}
	
}
