package board.util.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	private static final String VALID_TEST_ID = "test";
	private static final String VALID_TEST_PW = "test";
	// 테스트용 임시 ID와 PW (properties 이용하도록 리팩토링 예정)

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userId;
		String userPw;

		userId = request.getParameter("user_id");
		userPw = request.getParameter("user_pw");
		
		boolean loginSuccess = false;		
		long currentTime = 0;
		
		if(request.getSession().getAttribute("loginTime")==null) {
			//currentTime = request.getSession().getLastAccessedTime(); // 세션에 loginTime이 없으면(최초로그인이면) 마지막으로 세션에 접근한 시간을 받아옴.
			currentTime = System.currentTimeMillis(); // 현재 시간을 밀리초 단위로 받아서 long 형식으로 변수에 저장
		}
		// 세션에 대한 마지막 접근 = 직전 접근 = 로그인 요청일 것... 이라고 생각했는데 세션을 로그인 떄만 쓰지 않는다. 이걸 이렇게 만들면 POST 요청이 들어올 떄마다 세션 타임이 갱신될 수 있음	
				
		if (userId != null && userPw!=null) {
			loginSuccess = testValidation(userId,userPw);
			System.out.println(userId + userPw);
			if (loginSuccess)
			{
				request.getSession().setAttribute("loginSuccess", "로그인에 성공했습니다.");
				request.getSession().setAttribute("userId", userId);
				request.getSession().setAttribute("loginTime", currentTime);
				System.out.println("로그인성공");
			}else {
				request.getSession().setAttribute("loginError", "ID 혹은 비밀번호가 다릅니다.");
				System.out.println("idpw오류");
			}
		} else {
			//userId가 null이란 소리는 폼에 정보를 싣지 않고 다이렉트로 url 치고 들어왔단 소리. errorMsg를 response에 담아서 보낸다.
			request.getSession().setAttribute("loginError", "잘못된 접근입니다.");
		}		
		//response.sendRedirect(request.getContextPath() + request.getServletPath());
		//결과와 상관없이 리다이렉트 해줘야 한다. 뒤로가기로 post가 다시 반복되면 안되므로 리다이렉트 처리한다. (PRG 패턴)
		//이렇게 하면 get 방식으로 요청이 간다. doGet을 오버라이딩하지 않고 해결보려면 forward 방식으로 구현해야 한다.
		//forward로 구현할 경우 주소창이 안 바뀌지만 iframe 내에서 하는 동작이니까 주소창은 신경쓰지 않아도 된다...
		System.out.println("forward");
		request.getRequestDispatcher("/board/left.jsp").forward(request, response);
		
		//forward 방식일 때는 컨텍스트 패스를 안 붙인다. 브라우저가 보는 영역이 아니라 서버내부동작이기 떄문임	
	}

	boolean testValidation(String userId, String userPw) {
		//테스트용 메소드. 세션 타고 넘어온 ID와 PW가 테스트용 값과 일치하는지 체크
		if (userId.equals(VALID_TEST_ID) && userPw.equals(VALID_TEST_PW))
			return true;
		else
			return false;
	}

}
