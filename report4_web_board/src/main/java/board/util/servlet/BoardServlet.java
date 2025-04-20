package board.util.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import board.dto.BoardDTO;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet(urlPatterns = "/Board", loadOnStartup = 1)
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private List<BoardDTO> boardList;

	
	public BoardServlet() {
		super();
	}

	public void init() throws ServletException {
        boardList = (List<BoardDTO>) getServletContext().getAttribute("boardList");
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String subject = request.getParameter("subject_input");
		String content = request.getParameter("content_input");

		if (subject != null && content != null) {
			int no = boardList.size() + 1;
			boardList.add(new BoardDTO(no, subject, content));
		}

		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("<script>top.location.href='" + request.getContextPath() + "/board/index.jsp';</script>");
	}
}
