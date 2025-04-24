package ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import dto.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxTestServlet
 */
@WebServlet(urlPatterns = "/ajax" , loadOnStartup = 1)
public class AjaxJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청된 정보가 어떤 메소드를 실행해야하는지 체크
		String key = request.getParameter("key");
		
		System.out.println("key = " + key);
		if(key.equals("text")) {
			this.text(request, response);
			
		}else if(key.equals("json")) {
			this.json(request, response);
		}else if(key.equals("dto")) {
			this.dto(request, response);
		}else if(key.equals("list")) {
			this.list(request, response);
		}else if(key.equals("map")) {
			this.map(request, response);
		}
	}
	
	/**
	 * text 결과
	 * */
    public void text(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//service---
    	
    	//응답
    	
    	
	}

	/**
	 * json결과
	 * */
   public void json(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//service -> dao 
	     List<String> menus = Arrays.asList("짜짱면","짬뽕","짬짜면","탕수육","우동","쫄면");
	     
	     
	}

	/**
	 * DTO 결과
	 * */
   public void dto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   Member member =
	     new Member("jang", "장희정", 25, "서울");
	   
	   
	  
	}
	
	/**
	 * List결과
	 * */
   public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   List<Member> list = new ArrayList<Member>();
	   list.add(new Member("jang", "장희정", 25, "서울"));
	   list.add(new Member("kim", "이횰", 30, "서울"));
	   list.add(new Member("king", "이나영", 27, "대구"));
	   list.add(new Member("aaa", "김희선", 25, "부산"));
	   list.add(new Member("test", "장동건", 20, "대전"));
	   
	   
	   
	}
	
	/**
	 * Map결과
	 * */
   public void map(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   Map<String, Object> map = new HashMap<>();
	   map.put("message", "Ajax재미있다.");
	   map.put("pageNo", 20);
	   map.put("dto", new Member("jang", "장희정", 25, "서울"));
	   
	   
	   List<Member> list = new ArrayList<Member>();
	   list.add(new Member("jang", "장희정", 25, "서울"));
	   list.add(new Member("kim", "이횰", 30, "서울"));
	   list.add(new Member("king", "이나영", 27, "대구"));
	   map.put("memberList", list);
	   
	   
	   
	}
	

}







