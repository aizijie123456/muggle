package org.com.thread.c3.t7;

public class Run {
	
	public static ThreadLocal t1 = new ThreadLocal();
	public static void main(String[] args) {
		if(t1.get() == null){
			System.out.println("从未放过值");
			t1.set("值");
		}
		System.out.println(t1.get());
		System.out.println(t1.get());
	}

}
