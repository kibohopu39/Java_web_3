package java_ee20200208;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//承Kai_19，輸入資料，並驗證是否存在資料庫
/**
 * Servlet implementation class Kai_20
 */
@WebServlet("/Kai_20")
public class Kai_20 extends HttpServlet {
	private static final String sql = "SELECT * FROM cust WHERE account = ?";// 找帳號
	private static PreparedStatement pstmt;
	private boolean isMysqlOK;

	public Kai_20() {
		super();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			prop.put("serverTimezone", "Asia/Taipei");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/brad", prop);//跟本機器連線
			pstmt = conn.prepareStatement(sql);
			isMysqlOK = true;
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");

		String acc = request.getParameter("account");
		String pass = request.getParameter("passwd");

		if (acc == null || !isMysqlOK) {// 接下來要來玩驗證密碼
//			out.println("error");
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Server Busy!");
			return;
		}
		boolean isAccountOK = checkAccount(acc, pass);
		if (isAccountOK) {
//			out.println("debug1");
			response.sendRedirect("main.html");
			
		} else {
//			out.println("debug2");
			response.sendRedirect("form2.html");//比較一下跟RequestDispatcher有何不同
		}
	}

	private boolean checkAccount(String acc, String pass) {
		boolean isPWOK = false;
		try {
			pstmt.setString(1, acc);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {// 如果指標沒辦法往下移動，即不能往下一筆，判斷帳號是否對
				System.out.println("debug3");
				String hashpw = rs.getString("passwd");
				System.out.println(hashpw);
				isPWOK = Kai_api_20200208.chPasswd(pass, hashpw);//判斷密碼是否對，這裡寫到外面的類別，用意是要分類、給其他類別使用
	
			}else {
				System.out.println("debug4");
			}
		} catch (Exception e) {
			System.out.println("debug5");
		}
		return isPWOK;

	}

}
