package servlet_generic;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class GenericServletTest
 */
public class GenericServletTest extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// / generic 요청 받았다치고
		// 바로 응답
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Hello, GenericServletTest!</h1>");
		out.println("</body></html>");
		
		out.close();
	}

}
