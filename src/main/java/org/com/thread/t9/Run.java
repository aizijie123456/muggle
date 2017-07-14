package org.com.thread.t9;

public class Run {

	public static void main(String[] args) {
		Task task = new Task();
		MyThread1 thread1 = new MyThread1(task);
		MyThread2 thread2 = new MyThread2(task);
		thread1.start();
		thread2.start();
		try{
			Thread.sleep(10000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		long beginTime = CommonUtils.beginTime1;
		if(CommonUtils.beginTime2 < CommonUtils.beginTime1){
			beginTime = CommonUtils.beginTime2;
		}
		
		long endTime = CommonUtils.endTime1;
		if(CommonUtils.endTime1>CommonUtils.endTime2){
			endTime = CommonUtils.endTime2;
		}
		
		System.out.println("耗时:"+(endTime - beginTime) / 1000+"s");
	}

}
