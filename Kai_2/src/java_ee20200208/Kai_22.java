package java_ee20200208;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Kai_22")
public class Kai_22 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("Image/jpeg");

		BufferedImage bimg = ImageIO.read(
				new File("C:\\Users\\user\\eclipse\\java_web_doget\\Kai_2\\WebContent\\uploadfiles\\NYKD-054.jpg"));
		Graphics2D g2d = bimg.createGraphics();
		//可以做圖形驗證器
		Font myfont = new Font(null, Font.BOLD + Font.ITALIC, 100);
		AffineTransform tran = new AffineTransform();
		tran.rotate(Math.toRadians(-38), 0, 0);
		Font font2=myfont.deriveFont(tran);
		
		g2d.setFont(font2);
		g2d.setColor(Color.RED);
		g2d.drawString("不快轉有多難?", 90, 500);

		// 目前是在網頁輸出
		OutputStream oout = response.getOutputStream();
		ImageIO.write(bimg, "jpeg", oout);
		oout.flush();
		oout.close();
		// 可以寫到自用檔案中，與以上不可同時存在
//		response.setContentType("text/html;charset=UTF-8");
//		FileOutputStream fout=new FileOutputStream(new File("C:\\Users\\user\\eclipse\\java_web_doget\\Kai_2\\WebContent\\uploadfiles"));
//		ImageIO.write(bimg, "jpeg", fout);
//		fout.flush();
//		fout.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
