package org.com.thread.t17;

public class Run {

	public static void main(String[] args) {
		AddCountThread act = new AddCountThread();
		 Thread t1 = new Thread(act);
		 Thread t2 = new Thread(act);
		 Thread t3 = new Thread(act);
		 Thread t4 = new Thread(act);
		 Thread t5 = new Thread(act);
		 t1.start();
		 t2.start();
		 t3.start();
		 t4.start();
		 t5.start();

	}

}
