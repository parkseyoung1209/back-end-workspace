package cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie")
public class CookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie c1 = new Cookie("id", "test1234");
		Cookie c2 = new Cookie("name", "테스트1234");
		c1.setMaxAge(20);	// 20초 ->숫자는 초단위
		c2.setMaxAge(60*60*24); // 하루
		response.addCookie(c1);
		response.addCookie(c2);
	}

}
