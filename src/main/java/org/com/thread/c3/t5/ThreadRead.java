package org.com.thread.c3.t5;

import java.io.PipedInputStream;

public class ThreadRead extends Thread {
	private ReadData read;
	private PipedInputStream in;
	
	public ThreadRead(ReadData read, PipedInputStream in) {
		super();
		this.read = read;
		this.in = in;
	}

	@Override
	public void run() {
		read.read(in);
	}
	
}
