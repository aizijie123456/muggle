package org.com.thread.c3.t5;

import java.io.PipedOutputStream;

public class ThreadWrite extends Thread {
	private WriteData write;
	private PipedOutputStream out;
	public ThreadWrite(WriteData writeData, PipedOutputStream out) {
		super();
		this.write = writeData;
		this.out = out;
	}
	@Override
	public void run() {
		write.wtire(out);
	}
	
}
