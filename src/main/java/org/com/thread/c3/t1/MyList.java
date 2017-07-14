package org.com.thread.c3.t1;

import java.util.ArrayList;
import java.util.List;

public class MyList {
	private List<Object> list = new ArrayList();

	public void add() {
		list.add("aizijie");
	}

	public int getSize() {
		return list.size();
	}

}
