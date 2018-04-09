package bookstore;

import java.util.Scanner;

public class Main {
	private static BookStore storeObj	= new BookStore();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int functionID	= 0;
		boolean flag	= true;
		
		do {
			showMenu();
			
			try {
				functionID		= sc.nextInt();
				sc.nextLine();
				
				switch (functionID) {
					case 1: addBook(); 		break;
					case 2: editBook(); 	break;
					case 3: deleteBook(); 	break;
					case 4: findBook("id"); 	break;
					case 5: listBook("price", 0); 	break;	
					case 6: listBook("price", 1); 	break;	
					case 7: listBook("name", 1); 	break;	
					case 8: listBook("name", 0); 	break;  
					case 9: findBook("max"); 	break;  
					case 10: findBook("min"); 	break;  
					case 11: 
					default:
						flag = false;
						break;
				}
			} catch (Exception e) {
				myPrint("Error! Please try again!");
				flag	= true;
				sc.nextLine();
			}
			
		} while (flag == true);
		
		sc.close();
	}

	public static void showMenu(){
		myPrint("----------- BOOK MANAGER ----------- ");
		myPrint("1. Add book");		// x
		myPrint("2. Edit book");	// x
		myPrint("3. Delete book");	//
		myPrint("4. Find book");	// x
		myPrint("5. List book (Price: Hight > Low)");	
		myPrint("6. List book (Price: Low > Hight)");	
		myPrint("7. List book (Name: A > Z)");	
		myPrint("8. List book (Name: Z > A)");	
		myPrint("9. Best expensive (max): ");	
		myPrint("10. Best cheap (min): ");	
		myPrint("11. Exit");			// x
		myPrint("Your choise [1-11]: ");
	}
	
	public static void addBook(){
		if(storeObj.checkFull() == false){
			Scanner sc = new Scanner(System.in);
			
			String bookName	= "";
			String bookID	= "";
			double bookPrice= 0;
			
			myPrint("ID: ");
			bookID		= sc.nextLine();
			
			myPrint("Name: ");
			bookName	= sc.nextLine();
			
			myPrint("Price: ");
			bookPrice	= sc.nextDouble();
			
			Validate validateObj	= new Validate();
			boolean flagID			= validateObj.checkID(bookID);
			boolean flagName		= validateObj.checkName(bookName);
			boolean flagPrice		= validateObj.checkPrice(bookPrice);
			
			if(flagID && flagName && flagPrice){
				Book bookObj	= new Book(bookID, bookName, bookPrice);
				storeObj.add(bookObj);
			}else{
				validateObj.getError();
			}
			
			
		}else{
			System.out.println("Store is full!");
		}
	}
	
	public static void myPrint(String content){
		System.out.println(content);
	}
	
	public static void deleteBook(){
		Scanner sc = new Scanner(System.in);
		
		String bookID	= "";
		
		myPrint("ID: ");
		bookID		= sc.nextLine();
		
		storeObj.delete(bookID);
	}
	
	public static void findBook(String type){
		switch (type) {
			case "id":
				Scanner sc = new Scanner(System.in);
				String bookID	= "";
				myPrint("ID: ");
				bookID		= sc.nextLine();
				storeObj.find(bookID);
				break;
			case "max":
				storeObj.findMax();
				break;
			case "min":
			default:
				storeObj.findMin();
				break;
		}
		
	}
	
	public static void editBook(){
		Scanner sc = new Scanner(System.in);
		
		String bookName	= "";
		String bookID	= "";
		double bookPrice= 0;
		
		myPrint("ID: ");
		bookID		= sc.nextLine();
		
		myPrint("Name: ");
		bookName	= sc.nextLine();
		
		myPrint("Price: ");
		bookPrice	= sc.nextDouble();
		
		storeObj.edit(bookID, bookName, bookPrice);
	}
	
	public static void listBook(String property, int type){
		if(property.equals("name") && type == 1) storeObj.sortNameAZ();
		if(property.equals("name") && type == 0) storeObj.sortNameZA();
		if(property.equals("price") && type == 1) storeObj.sortPriceAZ();
		if(property.equals("price") && type == 0) storeObj.sortPriceZA();
		storeObj.list();
	}
}
