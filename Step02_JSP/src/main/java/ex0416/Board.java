package ex0416;

public class Board {

	private int number;
	private String subject;
	private String content;

	public Board() {
	}
	
	public Board(int number, String subject, String content) {
		this.number=number;
		this.subject=subject;
		this.content=content;
	}

	public int getNumber() {//jsp에서 ${변수.number}로 호출 가능
		return number;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

}
