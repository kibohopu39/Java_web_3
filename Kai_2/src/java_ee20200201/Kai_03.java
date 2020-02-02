package java_ee20200201;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Kai_03")
public class Kai_03 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
//		String favorite = request.getParameter("favorite");
		String[] likes = request.getParameterValues("like");
		String area= request.getParameter("area");
		String memo = request.getParameter("memo");
		if (likes != null) {
			for (String like : likes) {
				System.out.println(like);
			}
			System.out.println(account + "+" + password + "+" + gender);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
