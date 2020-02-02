package java_ee20200201;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sun.javafx.geom.IllegalPathStateException;

@WebServlet("/Kai_06")
@MultipartConfig
public class Kai_06 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 準備好上述的路徑，路徑在哪裡都無所謂
		File uploader = new File("C:\\Users\\user\\eclipse-workspace_forweb\\Kai_2\\WebContent\\uploadfiles");

		// enctype ="multipart/form-data"
		// must be => @MultipartConfig
		// 這是一個 runtime exception
		Collection<Part> parts = request.getParts();
		// 先來看看有多少個part
		System.out.println("size:" + parts.size());

		for (Part part : parts) {
			String name = part.getName();//得到該標籤的name，此處是input標籤
			System.out.println(name);
			String sname=part.getSubmittedFileName();//這個是得到上傳檔案的檔名，但各個瀏覽器不同狀況，一般不建議使用，否則要個別處理
			System.out.println(sname);
			//讀取檔案
			InputStream in = part.getInputStream();
			byte[] buf=new byte[(int)(part.getSize())];
			in.read(buf);
			in.close();
			//傳出到指定位置
			FileOutputStream fout = new FileOutputStream(new File(uploader,sname));
			fout.write(buf);
			fout.flush();
			fout.close();
			}}
	
}
