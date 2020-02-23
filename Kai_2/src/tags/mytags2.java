package tags;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class mytags2 extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		
		JspContext context = getJspContext();
		JspWriter out = context.getOut();
		JspFragment body = getJspBody();
		
		StringWriter switer = new StringWriter();
		body.invoke(switer);
		System.out.println(switer.toString());
		
		out.println("Hello, " + switer.toString().toUpperCase());
	}

}