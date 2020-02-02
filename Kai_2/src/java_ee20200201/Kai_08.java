package java_ee20200201;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//測試  respond

@WebServlet("/Kai_08")
public class Kai_08 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 取得 response
		// writer 是針對字元
		// printStream 是針對串流
		// 注意輸出內容是文字檔
		PrintWriter writer = response.getWriter();
		writer.println("Hi");//其實跟 System.out.println() 效果一樣，即 System 原本就存在的物件，但有實作印出的方法
		writer.println("you");
		// 若要更改輸出檔案類型(比如說 html)可以這樣改
		response.setContentType("text/html;charset=UTF-8");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
