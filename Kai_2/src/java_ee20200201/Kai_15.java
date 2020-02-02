package java_ee20200201;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//初步做MVC的觀念
@WebServlet("/Kai_15")
public class Kai_15 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		// 0:prepare
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String op = request.getParameter("op");
		if (x == null)
			x = "0";
		if (y == null)
			x = "0";
		if (op == null)
			op = "1";
		// 1:model
		Kai_16 model = new Kai_16(x, y,op);//做一個class
		double result=model.operation();//class裡面的operation運算
		
		// 2.view
		RequestDispatcher dispatcher = request.getRequestDispatcher(String.format("Kai_17?x=%s&y=%s&result=%s&op=%s&filename=%s",x,y,result,"view2.html"));
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
