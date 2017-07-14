package org.com.lanucher;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CustomizeClassLoader extends ClassLoader {
	private String classpath;
	
	public CustomizeClassLoader(String classpath){
		this.classpath = classpath;
	}
	//override findClass
	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			byte[] binaryClassData = this.getBinaryClassData(name);
			return this.defineClass(name, binaryClassData, 0, binaryClassData.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.loadClass(name);
	}
	
	
	// get byte class data
	
	private byte[] getBinaryClassData(String classname) throws IOException{
		String path = classpath+classname.replace('.', File.pathSeparatorChar)+".class";
		FileInputStream fis = new FileInputStream(path);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[]  buffer = new byte[2048];
		int num =0;
		while((num=fis.read(buffer)) != -1){
			baos.write(buffer,0,num);
		}
		return baos.toByteArray();
	}
	
}
