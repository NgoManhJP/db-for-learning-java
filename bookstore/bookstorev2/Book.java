package bookstore;

public class Book {
	
	private String ID;
	private String name;
	private double price;
	private String[] errors	= new String[3];
	
	public Book(String ID, String name, double price){
		boolean flagID		= this.checkID(ID);
		boolean flagName	= this.checkName(name);
		boolean flagPrice	= this.checkPrice(price);
		
		if( flagID == true && flagName == true && flagPrice == true){
			this.setID(ID);
			this.setName(name);
			this.setPrice(price);
		}else{
			this.showError();
		}
	}
	
	public boolean checkID(String value){
		boolean flag = value.matches("[A-z]{3}-[0-9]{3}");
		if(flag == false){
			this.setErrors("ID: ID phải có dạng [A-z]{3}-[0-9]{3}", 0);
		}
		return flag;
	}
	
	public boolean checkName(String value){
		boolean flag = value.matches("[\\w\\-!@\\.]{5,50}");
		if(flag == false){
			this.setErrors("Name: Name phải có dạng [\\w\\-!@\\.]{5,50}", 1);
		}
		return flag;
	}
	
	public boolean checkPrice(double value){
		boolean flag = (value >= 1 && value <= 100);
		if(flag == false){
			this.setErrors("Price: Price phải nằm trong khoảng từ [1-100]", 2);
		}
		return flag;
	}
	
	public void setErrors(String value, int position) {
		this.errors[position]	= value;
	}
	
	public void showError() {
		String result = "";
		for(String elm : this.errors){
			if(elm != null) 
			result += elm + "\n";
		}
		System.out.println("-------------- ERROR -------------- \n" + result + "\n");
	}
	
	public String getID() {
		return ID;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void showInfo() {
		System.out.println("Book Info: ");
		System.out.println("- ID \t\t:" + this.getID());
		System.out.println("- Name \t\t:" + this.getName());
		System.out.println("- Price  \t:" + this.getPrice());
	}
}
