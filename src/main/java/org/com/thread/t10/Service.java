package org.com.thread.t10;

public class Service {
	private String userName;
	private String password;
	
	public void setUserNamePassword(String username,String password){
		try{
			String anyThing = new String();
			synchronized (anyThing) {
				System.out.println("线程名称:"+Thread.currentThread().getName()+"在"+System.currentTimeMillis()+"进入同步块");
				this.userName = username;
				Thread.sleep(3000);
				this.password = password;
				System.out.println("线程名称:"+Thread.currentThread().getName()+"在"+System.currentTimeMillis()+"离开同步块");
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
