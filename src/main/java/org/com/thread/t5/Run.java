package org.com.thread.t5;

public class Run {

	public static void main(String[] args) {
		CountOperation co = new CountOperation();
		Thread t1 = new Thread(co);
		t1.setName("A");
		t1.start();
	}

}
