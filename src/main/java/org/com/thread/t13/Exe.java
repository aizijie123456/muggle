package org.com.thread.t13;

import org.com.thread.t13.OuterClass.InnerClass1;
import org.com.thread.t13.OuterClass.InnerClass2;

public class Exe {

	public static void main(String[] args) {
		final InnerClass1 in1 = new InnerClass1();
		final InnerClass2 in2 = new InnerClass2();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				in1.method1(in2);
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				in1.method2();
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				in2.method1();
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
