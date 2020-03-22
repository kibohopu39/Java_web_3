package java_ee20200208;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

//撈資料庫的原始碼
@WebServlet("/Kai_24")
public class Kai_24 extends HttpServlet {

    public Kai_24() {//第一位使用者進來的時候，需要Kai_24這個物件，這時會立刻做出一個，之後會一直存在，等其他使用者需要時，就不需要再做
    	try {
			// 載入驅動程式是在系統開啟的時候，只有載入一次，因此放在建構式中
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
    }
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		try {
			JSONArray root=new JSONArray();
			// 連資料庫
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			prop.put("serverTimezone", "Asia/Taipei");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/brad", prop);
			String sql = "SELECT * FROM cust";// 防止隱碼攻擊
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rSet=pstmt.executeQuery(sql);
			while(rSet.next()) {//尋訪rSet
				HashMap<String, String> row=new HashMap<String, String>();
				row.put("id", rSet.getString("id"));
				row.put("password", rSet.getString("passwd"));
				row.put("account", rSet.getString("account"));
				root.put(row);
			}
			out.print(root.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}


}
