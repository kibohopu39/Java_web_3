package tags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class mytags1 extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		
		System.out.println("debug1");
		JspContext context = getJspContext();
		JspWriter out = context.getOut();
		out.println("Hello, Brad");
		
		
	}

}