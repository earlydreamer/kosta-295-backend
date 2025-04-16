package ex0416;

public class Product {
	private String code = "A01";
	private String name = "새우깡";
	private int qty = 5;
	private int price = 3500;
	
	public Product(){
		System.out.println("생성자호출");
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		System.out.println("call getName");
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		System.out.println("call getQty");
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		System.out.println("call getPrice");
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
