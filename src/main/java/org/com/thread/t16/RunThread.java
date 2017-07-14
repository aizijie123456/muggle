package org.com.thread.t16;

public class RunThread extends Thread {

	volatile private boolean isRunning = true;

	public boolean isRunning() {
		return isRunning;
	}


	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}


	@Override
	public void run() {
		System.out.println("进入 run 了");
		while(isRunning==true){
			System.out.println(isRunning);
		}
		System.out.println("线程被停止了");
	}

}
