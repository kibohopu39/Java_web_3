package java_ee20200201;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/Kai_07")
@MultipartConfig
public class Kai_07 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		File uploadDir = 
				new File("C:\\Users\\user\\git\\repository\\Kai_02\\WebContent\\uploadfiles");

		// enctype="multipart/form-data"
		// MUST BE => @MultipartConfig 
		Collection<Part> parts = request.getParts();
		System.out.println("size = " +parts.size());
		int i=1;
		for (Part part : parts) {
			
			String name = part.getName();
			String sname = part.getSubmittedFileName();
			//System.out.println(name + ":" + sname);
			
			if (sname.length() == 0) continue;
			
			part.write(createFileName(i++));
			
		}
	
	}

	private String createFileName(int i) {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.DAY_OF_MONTH)+1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		return "F" + year+"_"+month+"_"+day+"_"+i+".jpg";
	}
	
	
}
