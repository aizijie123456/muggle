package org.com.thread.c3.t5;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Run {

	public static void main(String[] args) throws IOException, InterruptedException {
		WriteData write = new WriteData();
		ReadData read = new ReadData();

		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();
	
		out.connect(in);
		
		
		ThreadRead tr = new ThreadRead(read, in);
		tr.start();
		
		Thread.sleep(2000);
		
		ThreadWrite tw = new ThreadWrite(write, out);
		tw.start();
	}
}
