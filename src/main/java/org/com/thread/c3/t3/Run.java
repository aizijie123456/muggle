package org.com.thread.c3.t3;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		String lock = new String("");

		P p = new P(lock);
		C c = new C(lock);
		ThreadP[] tp = new ThreadP[2];
		ThreadC[] tc = new ThreadC[2];
		for (int i = 0; i < 2; i++) {
			tp[i] = new ThreadP(p);
			tp[i].setName("生产者" + (i+1));

			tc[i] = new ThreadC(c);
			tc[i].setName("消费者" + (i+1));

			tp[i].start();
			tc[i].start();
		}

		Thread.sleep(5000);
		Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
		Thread.currentThread().getThreadGroup().enumerate(threadArray);
		for (int i = 0; i < threadArray.length; i++) {
			System.out.println(threadArray[i].getName()+" "+threadArray[i].getState());
		}

	}

}
