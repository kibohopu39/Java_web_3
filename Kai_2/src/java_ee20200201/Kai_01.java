package java_ee20200201;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Kai_01")
public class Kai_01 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
//		傳遞來的資料一般分成檔頭、檔案內容...這裡先用檔頭head部分，以下方法可以看出傳遞進來的名稱
		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String key = headers.nextElement();//拿到key名稱
			String value = request.getHeader(key);//拿到其值
			System.out.println(key+":"+value);
			}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
