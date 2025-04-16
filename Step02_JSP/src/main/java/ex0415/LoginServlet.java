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

	private final String ID_FOR_VALIDATION = "admin"; // 테스트용 예제니까 아무래도 좋아
	private final String PW_FOR_VALIDATION = "1q2w3e"; // 아무 패스워드
	private final String FIRST_LOGIN_IDENTIFIER = "FIRSTLOGIN";// 쿠키에 담을 첫 로그인 식별자 텍스트
	private final String JSP_PATH = "/cookie/";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		// 이번 request에서 날아온 값을 받아옴
		String userId = request.getParameter("userId").toString();
		String userPw = request.getParameter("userPwd").toString();
		String userName = request.getParameter("userName").toString();

		Cookie[] cookies = request.getCookies();
		Cookie lastLoginCookie = null;

		for (Cookie cookie : cookies) {
			// 마지막 로그인시간 쿠키가 있는지 찾음
			if (cookie.getName().equals("lastLoginTime")) {
				lastLoginCookie = cookie;
				//System.out.println(lastLoginCookie.getValue());
			}
		} // lastLoginCookie 내역이 있으면 집어넣음 없으면 null
		
		//for문을 빠져나왔는데도 null이면 마지막 로그인시간 쿠키가 없는 최초 로그인임
		if (lastLoginCookie == null) {
			lastLoginCookie = new Cookie("lastLoginTime",FIRST_LOGIN_IDENTIFIER); // 쿠키가 null이 되지 않도록 쿠키 데이터 생성
			response.addCookie(lastLoginCookie);
			//lastLoginCookie = new Cookie("lastLoginTime", "첫 로그인입니다."); // 한글 등 Ascii 문자가 아닌 텍스트가 날아가면 터진다.
			}
		
		long lastAccessTime = request.getSession().getLastAccessedTime(); // 마지막 세션타임을 받아옴
		String timeString = null;
		String oldTimeString = null;

		//timeString = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(lastAccessTime)); // 포맷팅된 텍스트를 쿠키에 실으면 터진다...
		
		timeString = Long.toString(lastAccessTime); //long형식의 타임스탬프를 그대로 형변환해서 보내고 받는 측에서 변환해야 한다.
		oldTimeString = lastLoginCookie.getValue().toString();//쿠키에서 받아온 값을 그대로 담는다.		

		// 실습 쿠키 코드
		Cookie cookie = new Cookie("savedId", userId);
		cookie.setMaxAge(60 * 60 * 24);
		cookie.setPath("/");
		response.addCookie(cookie);

		if (userId.equals(ID_FOR_VALIDATION) && userPw.equals(PW_FOR_VALIDATION)) {
			request.getSession().setAttribute("userId", userId);
			request.getSession().setAttribute("userName", userName);
			request.getSession().setAttribute("loginTime", timeString); // 날짜시간형식으로 포맷팅된 시간을 쏴줌 -> 이것이 지금 로그인 시각
			request.getSession().setAttribute("lastLoginTime", oldTimeString);// 쿠키에 있던 마지막 로그인 시간을 쏴줌  																							
			
			oldTimeString = timeString; //최종 로그인 시각을 덮어쓰고
			lastLoginCookie = new Cookie("lastLoginTime", oldTimeString); // 갱신된 최종 로그인 시각을 갱신된 쿠키에 담음
			response.addCookie(lastLoginCookie);
			response.sendRedirect(getServletContext().getContextPath() + JSP_PATH + "LoginOk.jsp"); // 리다이렉트 요청을 쏘고
			
		} else {
			// ID PW 다릅니다 alert
			request.getSession().setAttribute("loginError", "아이디 또는 비밀번호가 올바르지 않습니다.");
			response.sendRedirect(getServletContext().getContextPath() + JSP_PATH + "LoginForm.jsp");
			// Context Path 받아와서 loginServlet으로 보내기
		}

	}
}
