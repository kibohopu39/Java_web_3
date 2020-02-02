package java_ee20200201;


import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Kai_04")
public class Kai_04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//轉換中文字顯示亂碼問題
//		InputStream in = request.getInputStream();
//		byte[] buf = new byte[4096]; int len;
//		while((len=in.read(buf))!=-1) {
//			System.out.println(new String(buf,0,len));
//		}
//		in.close();
		System.out.println("----------------------");
		String normal = request.getParameter("normal");
		System.out.println(normal);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
