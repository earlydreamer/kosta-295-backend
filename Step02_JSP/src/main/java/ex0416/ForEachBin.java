package ex0416;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachBin {
	private String names[] = {"이름1","이름2","이름3","이름4","이름5","이름6","이름7"};
	private List<String> menus = Arrays.asList("짜장","짬뽕","군만두","탕수육","냉면"); //중국요리 먹고 싶다 ......
	private List<Board> boardList = new ArrayList<Board>();
	private Map<String, String> map = new HashMap<String, String>();
	
	public ForEachBin() {
		boardList.add(new Board(1,"제목1","내용1"));
		boardList.add(new Board(2,"제목2","내용2"));
		boardList.add(new Board(3,"제목3","내용3"));
		boardList.add(new Board(4,"제목4","내용4"));
		boardList.add(new Board(5,"제목5","내용5"));
		
		map.put("kr", "한국");
		map.put("us", "미국");
		map.put("jp", "일본");
		map.put("cn", "중국");
		map.put("eu-uk", "영국");
	}

	public String[] getNames() {
		return names;
	}

	
	public List<String> getMenus() {
		return menus;
	}

	
	public List<Board> getBoardList() {
		return boardList;
	}

	
	public Map<String, String> getMap() {
		return map;
	}

	
	
	
}

