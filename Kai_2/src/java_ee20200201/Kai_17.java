package java_ee20200201;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//撰寫MVC中view的部分
@WebServlet("/Kai_17")
public class Kai_17 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 問題在傳給瀏覽器的資料要怎麼寫，Kai_10中曾經用一行一行的方式
		// 這裡先交給一個自訂的函數處理，待會兒再來寫
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String result = request.getParameter("result");
		String op = request.getParameter("op");
		String filename = request.getParameter("filename");
		// 把Kai_15的要求丟過來
		String op1 = op.equals("1") ? "selected" : "";
		String op2 = op.equals("2") ? "selected" : "";
		String op3 = op.equals("3") ? "selected" : "";
		String op4 = op.equals("4") ? "selected" : "";
		String html = loadView(filename);
		out.print(String.format(html, x, op1, op2, op3, op4, y, result));
		response.flushBuffer();

	}

	private String loadView(String fname) {
		ServletContext context = getServletContext();
		String viewPath = context.getInitParameter("viewPath");
		
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader reader = 
				new BufferedReader(new FileReader(
						new File(viewPath, fname)));
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
		}catch(Exception e) {
			
		}
		
		return sb.toString();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
