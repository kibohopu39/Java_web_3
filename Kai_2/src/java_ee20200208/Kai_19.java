package java_ee20200208;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Kai_mysql.BCrypt;
// 將資料輸入到MYSQL
@WebServlet("/Kai_19")
public class Kai_19 extends HttpServlet {
	public Kai_19() {
		try {
			// 載入驅動程式是在系統開啟的時候，只有載入一次，因此放在建構式中
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");

		String acc = request.getParameter("account");
		String pass = request.getParameter("passwd");
		
		if (acc == null)//	沒有輸入就什麼都不傳回
			return;
		// 密碼需要編碼加密，很多種編碼方式，編碼後為不可逆
		// base64
		// 因為在後端編碼常跟網頁衝突，因此常會轉換成base64
		String hashpw = BCrypt.hashpw(pass, BCrypt.gensalt());
		int result = add2MySQL(acc, hashpw);
		out.println("add:" + result);
		response.flushBuffer();
	}

	private int add2MySQL(String account, String passwd) {
		int ret = 0;// 執行後會傳回int，這裡我們想檢查是否有成功執行(見executeUpdate())
		try {
			// 連資料庫
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			prop.put("serverTimezone", "Asia/Taipei");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/brad", prop);
			String sql = "INSERT into cust(account,passwd)values(?,?)";// 防止隱碼攻擊
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);//第一個問號
			pstmt.setString(2, passwd);//第二個問號
			ret = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return ret;
	};
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
