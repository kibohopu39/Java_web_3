import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

public class contact_database {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Properties info = new Properties();
			info.put("user", "root");
			info.put("password", "root");
			info.put("serverTimezone", "Asia/Taipei");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/opendata", info);
			String sql = "INSERT INTO local_snacks(cname, address, tel, latlng,picurl) VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//--------------
			URL url=new URL("https://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx");
			HttpURLConnection hconn= (HttpURLConnection)url.openConnection();
			hconn.connect();
			BufferedReader reader=new BufferedReader(new InputStreamReader(hconn.getInputStream()));
			String line;StringBuffer sb=new StringBuffer();
			while((line=reader.readLine())!=null) {
				//灌進來的資料為 JSON 格式
				sb.append(line);
			}
			
			//---------------
			// 解析 JSON
			String json=sb.toString();
			JSONArray root=new JSONArray(json);
			System.out.println(root.length());
			for(int i=0;i<root.length();i++) {
				JSONObject row=root.getJSONObject(i);
				pstmt.setString(1, row.getString("Name"));
				pstmt.setString(1, row.getString("Address"));
				pstmt.setString(1, row.getString("Tel"));
				pstmt.setString(1, row.getString("Coordinate"));
				pstmt.setString(1, row.getString("PicURL"));
			}
//			
//			
//			
//			
			reader.close();
			
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
