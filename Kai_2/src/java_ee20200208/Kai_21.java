package java_ee20200208;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//做一個網路簽名
@WebServlet("/Kai_21")
public class Kai_21 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Kai_21() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");//我的輸出是影像

		String scate=request.getParameter("rate");
		if(scate==null) {
			return;
		}
		float rate=0;
		try {
		 rate = Float.parseFloat(scate);
		}catch(Exception e) {}
		
		BufferedImage bimg = new BufferedImage(400, 20, BufferedImage.TYPE_INT_BGR);
		Graphics2D g2d = bimg.createGraphics();
		g2d.setColor(Color.yellow);
		g2d.fillRect(0, 0, bimg.getWidth(), bimg.getHeight());
		g2d.setColor(Color.red);
		g2d.fillRect(0, 0, (int)(bimg.getWidth()*rate/100) , 20);

		
		OutputStream oout = response.getOutputStream();
		ImageIO.write(bimg, "jpeg", oout);
		oout.flush();
		oout.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
