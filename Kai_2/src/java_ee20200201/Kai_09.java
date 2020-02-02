package java_ee20200201;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 練習取得網頁輸入的值並輸出回網頁
// 頁面運作流程
@WebServlet("/Kai_09")
public class Kai_09 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 取得輸入的值
		String X = request.getParameter("x");
		String Y = request.getParameter("y");

		int intx = Integer.parseInt(X);
		int inty = Integer.parseInt(Y);
		int result = intx + inty;
		PrintWriter writer = response.getWriter();
		writer.println(X + "+" + Y + "=" + result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
