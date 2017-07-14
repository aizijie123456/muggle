package org.com.thread.c3.t5;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class WriteData {
	public void wtire(PipedOutputStream pos) {
		System.out.println("write:");
		try {
			for (int i = 0; i < 300; i++) {
				String outData = "" + (i + 1);
				pos.write(outData.getBytes());
			}
			pos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
