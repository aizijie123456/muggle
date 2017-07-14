package org.com.thread.c3.t5;

import java.io.PipedInputStream;

public class ReadData {
	public void read(PipedInputStream pis) {
		try {

			System.out.println("Read:");
			byte[] byteArray = new byte[20];
			int length = pis.read(byteArray);
			while (length != -1) {
				String readData = new String(byteArray, 0, length);
				System.out.println(readData);
				length = pis.read(byteArray);
			}
			pis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
