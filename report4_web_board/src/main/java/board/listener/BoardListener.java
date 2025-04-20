package board.listener;

import java.util.ArrayList;
import java.util.List;

import board.dto.BoardDTO;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class BoardListener implements ServletContextListener {

    public BoardListener() {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce)  { 
        List<BoardDTO> boardList = new ArrayList<>();
        boardList.add(new BoardDTO(1, "첫 글", "내용 1"));
        boardList.add(new BoardDTO(2, "둘째 글", "내용 2"));
        boardList.add(new BoardDTO(3, "셋째 글", "내용 3"));
        sce.getServletContext().setAttribute("boardList", boardList);
        
//        System.out.println("초기값세팅");
    	

    }

    public void contextDestroyed(ServletContextEvent sce)  { 

    }
	
}
