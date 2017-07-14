package org.com.thread.c3.t3;

public class C {
	private String lock;

	public C(String lock) {
		super();
		this.lock = lock;
	}

	public void getValue() {
		try {
			synchronized (lock) {
				if(ValueObject.value.equals("")){
					System.out.println("消费者:"+Thread.currentThread().getName()+"waiting .*.*.*");

					lock.wait();
				}
				System.out.println("消费者:"+Thread.currentThread().getName()+"runnable ...");
				ValueObject.value="";
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
