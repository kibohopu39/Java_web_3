package java_ee20200201;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//承接 Kai_10，如何用另一種方式寫?之後會再寫
//先寫response的練習


@WebServlet("/Kai_11")
public class Kai_11 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//利用requestDispatcher，來把其他的網頁夾進來
//		RequestDispatcher dispatcher=request.getRequestDispatcher("get_4.html");
		String name=request.getParameter("name");
		if(name==null) {
			name="world";
		}
		
		
		//能不能夾帶參數呢?
		RequestDispatcher dispatcher=request.getRequestDispatcher("Kai_12?name="+name);
		//---事實證明可以
		//---但你不能用set的方式設置
		
		
		//輸出到網頁這個文件
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("hello~");
		
		dispatcher.include(request, response);
		dispatcher=request.getRequestDispatcher("get_4.html");
		writer.println("great");
		
		
		
		writer.println("nice to meet you!<hr/>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
