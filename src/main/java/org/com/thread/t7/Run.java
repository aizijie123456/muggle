package org.com.thread.t7;

public class Run {

	public static void main(String[] args) {
		SynchronizedObject object = new SynchronizedObject();
		Thread ta = new Thread(new Runnable() {
			@Override
			public void run() {
				object.methodA();
			}
		});
		
		Thread tb = new Thread(new Runnable() {
			@Override
			public void run() {
				object.methodA();
			}
		});
		
		Thread tc = new Thread(new Runnable() {
			@Override
			public void run() {
				object.methodA();
			}
		});
		
		Thread td = new Thread(new Runnable() {
			@Override
			public void run() {
				object.methodA();
			}
		});
		
		
		Thread te = new Thread(new Runnable() {
			@Override
			public void run() {
				object.methodA();
			}
		});
		ta.setName("A");
		ta.start();
		
		tb.setName("B");
		tb.start();
		
		tc.setName("C");
		tc.start();
		
		td.setName("D");
		td.start();
		
		te.setName("E");
		te.start();
	}

}
