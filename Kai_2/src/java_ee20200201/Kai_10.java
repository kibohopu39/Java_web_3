package java_ee20200201;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//順序  ---> "//" : 第一次
//         "---": 第二次

// 承接 Kai_09，其畫面目前為點按後跳出該頁面，並印出數字相加的過程
// 思考下，如何不要跳出該頁面，並直接呈現?
// 方法1: 輸出 html 一行一行，如下

@WebServlet("/Kai_10")
public class Kai_10 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String X = request.getParameter("x");
		String Y = request.getParameter("y");
		// 要處理輸入時，Null (沒輸入) 跟空字串 (輸入數字以外的東西) 的問題
		//--- 增加選擇演算法的選項
		String op = request.getParameter("op");
		int intx, inty;
		double result;
		result = intx = inty = 0;

		try {
			intx = Integer.parseInt(X);
			inty = Integer.parseInt(Y);
			switch(op) {
			case "1":result = intx + inty;break;
			case "2":result = intx - inty;break;
			case "3":result = intx * inty;break;
			//---除法會有小數問題，需要換成 float，或是偷懶用1.0
			case "4":result = (intx*1.0) / inty;break;
			}
		} catch (Exception e) {

		}
//輸出網頁
		PrintWriter writer = response.getWriter();
		writer.append("<h1>Big Company</h1>")
		.append("<hr />")
		.append("<form action='Kai_10' method='get'>")
		.append("<input type='text' name='x' value="+intx+">")
		//select 設定 name的意義在於我們方便控制(設定預設值，讓我們分辨是哪種演算)
		//---遇到運算後，運算符號沒有隨之更改的情況
		//---我們可以透過三元判斷，更改 option 的 selected
		.append("<select name='op'>")
		.append("<option value='1'"+(op==null||op.equals("1")?"selected":"")+">+</option>")
		.append("<option value='2'"+(op==null||op.equals("2")?"selected":"")+">-</option>")
		.append("<option value='3'"+(op==null||op.equals("3")?"selected":"")+">*</option>")
		.append("<option value='4'"+(op==null||op.equals("4")?"selected":"")+">/</option>")
		.append("</select>")
		.append("<input type='text' name='y' value="+inty+">")
		.append("<input type='submit' value='=' />")
		.append(" "+result)
		.append("</form>");
		response.flushBuffer();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
