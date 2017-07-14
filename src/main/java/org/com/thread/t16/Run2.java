package org.com.thread.t16;

public class Run2 {

	public static void main(String[] args) {
		MyThread[] mythread  = new MyThread[100];
		for(int i=0;i<100;i++){
			mythread[i] = new MyThread();
		}
		for(int i=0;i<100;i++){
			mythread[i].start();
		}
	}

}
