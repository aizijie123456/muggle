package org.com.thread.t6;

public class SynchronizedObject {
	private String username="a";
	private String password="aa";
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	synchronized public void printString(String username,String password){
		this.username = username;
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.password= password;
	}
	
}
