package org.com.muggle.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.com.lanucher.CustomizeClassLoader;
import org.com.muggle.util.TestClassLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletConfigAware;

@Controller
@RequestMapping("/home")
public class HomeController implements ServletConfigAware{
	
	
	private ServletConfig servletConfig;
	
	
	@RequestMapping("/main")
	public String home(HttpServletRequest request, HttpServletResponse response, Model model) {
		// 调用自定义的classloader加载其他文件
//		String path = this.getClass().getClassLoader().getResource("/").getPath();
//		CustomizeClassLoader classloader = new CustomizeClassLoader(path+"org/com/muggle/util/");
//		try {
//			Class<?> testClas = classloader.findClass("TestClassLoader");
//			try {
//				TestClassLoader tst;
//				tst = (TestClassLoader)testClas.newInstance();
//				String mark = tst.getMark();
//				
//			} catch (InstantiationException | IllegalAccessException e) {
//				e.printStackTrace();
//			}
//			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		
		return "home";
	}

	@RequestMapping("/testCookie")
	public String testCookie(HttpServletRequest request, HttpServletResponse response, Model model) {
		Cookie[] cookies = request.getCookies();
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		ServletContext context1 = this.servletConfig.getServletContext();
		return "cookie";
	}

	public void compressCookie(Cookie cookie, HttpServletResponse res) {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			DeflaterOutputStream dos = new DeflaterOutputStream(bos);
			dos.write(cookie.getValue().getBytes());
			dos.close();
			System.out.println("before compress length:"+cookie.getValue().getBytes().length);
			String compress = new sun.misc.BASE64Encoder().encode(bos.toByteArray());
			res.addCookie(new Cookie("compress",compress));
			System.out.println("after compress length"+compress.getBytes().length);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setServletConfig(ServletConfig servletConfig) {
		this.servletConfig = servletConfig;
	}
}
