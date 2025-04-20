package board.util.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutServlet() {
        super();
    }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate(); // 세션 전체 제거
		request.getSession().setAttribute("loginError", "로그아웃하였습니다."); 
		//기존 세션을 끊은 후 생성된 새 세션에 실어 보낸다. 어차피 로그인정보 안 담겨있기 때문에 써도 무방 (깨끗한 구조는 아닌데 로그인 폼의 alert 로직을 재사용하고싶음)
		System.out.println("logout");
		//request.getRequestDispatcher("/board/left.jsp").forward(request, response);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("<script>top.location.href='board/index.jsp';</script>");
		

	}

}
