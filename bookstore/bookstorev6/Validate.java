package bookstore;

public class Validate {
	
	private StringBuilder error	= new StringBuilder();
	
	
	
	public void getError() {
		System.out.println(this.error);
	}

	public void setError(String error) {
		this.error.append(error).append("\n");
	}
	
	public boolean checkPrice(double value){
		boolean flag = (value > 0) && (value < 100);
		if(flag == false){
			this.setError("Price: Price phải nằm trong khoảng [0-100]");
		}
		return flag;
	}
	
	public boolean checkName(String value){
		boolean flag	= value.matches("[A-z\\.\\s!]{2,100}");
		if(flag == false){
			this.setError("Name: Name phải có dạng [A-z\\.\\s!]{2,100}");
		}
		return flag;
	}

	public boolean checkID(String value){
		boolean flag	= value.matches("[A-z]{3}-[2-8]{3}");
		if(flag == false){
			this.setError("ID: ID phải có dạng [A-z]{3}-[0-9]{3}");
		}
		return flag;
	}

}
