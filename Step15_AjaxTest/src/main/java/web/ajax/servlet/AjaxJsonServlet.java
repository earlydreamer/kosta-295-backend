package web.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web.ajax.dto.Member;

/**
 * Servlet implementation class AjaxTestServlet
 */
@WebServlet(urlPatterns = "/ajax", loadOnStartup = 1)
public class AjaxJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 요청된 정보가 어떤 메소드를 실행해야하는지 체크
		String key = request.getParameter("key");

		System.out.println("key = " + key);
		if (key.equals("text")) {
			this.text(request, response);

		} else if (key.equals("json")) {
			this.json(request, response);
		} else if (key.equals("dto")) {
			this.dto(request, response);
		} else if (key.equals("list")) {
			this.list(request, response);
		} else if (key.equals("map")) {
			this.map(request, response);
		}
	}

	/**
	 * text 결과
	 */
	public void text(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// service---
		// 응답
		PrintWriter out = response.getWriter();
		out.println("success");

	}

	/**
	 * json결과
	 */
	public void json(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// service -> dao
		List<String> menus = Arrays.asList("짜짱면", "짬뽕", "짬짜면", "탕수육", "우동", "쫄면");
		// 응답할 데이터를 json 객체로 변환해줘야 함
		Gson gson = new Gson();
		String output = gson.toJson(menus);
		System.out.println(output);
		PrintWriter out = response.getWriter();
		out.println(output);// response로 보낸다

	}

	/**
	 * DTO 결과
	 */
	public void dto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// service -> dao
		Member member = new Member("jang", "장희정", 25, "서울");
		// 응답할 데이터를 json 객체로 변환해줘야 함
		Gson gson = new Gson();
		String output = gson.toJson(member);
		System.out.println(output);
		PrintWriter out = response.getWriter();
		out.println(output);// response로 보낸다

	}

	/**
	 * List결과
	 */
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Member> list = new ArrayList<Member>();
		list.add(new Member("jang", "장희정", 25, "서울"));
		list.add(new Member("kim", "이횰", 30, "서울"));
		list.add(new Member("king", "이나영", 27, "대구"));
		list.add(new Member("aaa", "김희선", 25, "부산"));
		list.add(new Member("test", "장동건", 20, "대전"));
		Gson gson = new Gson();
		String output = gson.toJson(list);
		System.out.println(output);
		PrintWriter out = response.getWriter();
		out.println(output);// response로 보낸다

	}

	/**
	 * Map결과
	 */
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

		Gson gson = new Gson();
		String output = gson.toJson(map);
		System.out.println(output);
		PrintWriter out = response.getWriter();
		out.println(output);// response로 보낸다

		
		
		
	}

}
