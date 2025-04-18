package ex0415;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

//	@Override
//	public void init() throws ServletException {
//	    System.out.println("서블릿 초기화 성공");
//	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String ID_FOR_VALIDATION = "admin"; // 테스트용 예제니까 아무래도 좋아
		final String PW_FOR_VALIDATION = "1q2w3e"; // 아무 패스워드

		// 이번 request에서 날아온 값을 받아옴
		String userId = request.getParameter("userId").toString();
		String userPw = request.getParameter("userPwd").toString();
		String userName = request.getParameter("userName").toString();

		// 받아온 시간정보를 날짜시간형식으로 변환
		long lastAccessTime = request.getSession().getLastAccessedTime();
		String formattedTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new java.util.Date(lastAccessTime));

		// System.out.println("👉 userId = " + userId);
		// System.out.println("👉 userPw = " + userPw);
		// System.out.println("👉 userName = " + userName);

		// 넘어온 데이터를 받아서 변수에 저장 후 비교
		// 패스워드가 지정된 계정과 맞으면 LoginOk 페이지로 이동
		// (redirect 방식으로 이동, 이동할때 form에서 전달받은 변수 값 전달함)

		//쿠키에 정보 추가
		Cookie cookie = new Cookie("savedId",userId);
		cookie.setMaxAge(60*60*24);
		cookie.setPath("/");
		response.addCookie(cookie);

		if (userId.equals(ID_FOR_VALIDATION) && userPw.equals(PW_FOR_VALIDATION)) {
			request.getSession().setAttribute("userId", userId);
			request.getSession().setAttribute("userName", userName);
			request.getSession().setAttribute("loginTime", formattedTime); // 날짜시간형식으로 포맷팅된 시간을 쏴줌
			
			response.sendRedirect(getServletContext().getContextPath() + "/login/LoginOk.jsp");

		} else {
			// ID PW 다릅니다 alert
			request.getSession().setAttribute("loginError", "아이디 또는 비밀번호가 올바르지 않습니다.");
			response.sendRedirect(getServletContext().getContextPath() + "/login/LoginForm.jsp");
			// Context Path 받아와서 loginServlet으로 보내기
		}

	}
}
