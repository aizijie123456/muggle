package org.com.thread.c3.t4;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
	private List list = new ArrayList();
	
	synchronized public void push(){
		while(list.size() == 1){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		list.add("anything="+Math.random());
		this.notifyAll();
		System.out.println("push="+list.size());
	}
	
	synchronized public void pop(){
		String returnValue = "";
		System.out.println("Thread-Name:"+Thread.currentThread().getName()+" get "+list.size());
		while(list.size() == 0){
			System.out.println("pop 操作中:"+Thread.currentThread().getName() + "线程成wait状态");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		returnValue = ""+list.get(0);
		list.remove(0);
		this.notifyAll();
		System.out.println("pop="+list.size());
	}
	
	
}
