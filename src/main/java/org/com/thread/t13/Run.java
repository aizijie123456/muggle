package org.com.thread.t13;

import org.com.thread.t13.PublicClass.PrivateClass;

public class Run {

	public static void main(String[] args) {
		PublicClass publicClass = new PublicClass();
		publicClass.setUsername("userName-1");
		publicClass.setPassword("password-1");
		System.out.println(publicClass.getUsername()+" "+publicClass.getPassword());
		
		PrivateClass privateCls = publicClass.new PrivateClass();
		privateCls.setAddress("address-1");
		privateCls.setAge("4");
		System.out.println(privateCls.getAddress()+" "+ privateCls.getAge());

	}
}
