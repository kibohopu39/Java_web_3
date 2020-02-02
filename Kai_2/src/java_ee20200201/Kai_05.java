package java_ee20200201;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Kai_05")
public class Kai_05 extends HttpServlet {
	// 繼承抽象類別 HttpServlet，所以一定有抽象方法
	// 如果在override中沒有去寫抽象方法(指的是有寫出來，但內容空白)，雖然可以執行，但沒有意義
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
