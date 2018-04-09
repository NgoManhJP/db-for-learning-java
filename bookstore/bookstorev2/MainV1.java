package bookstore;

import java.util.Scanner;

public class MainV1 {
	private static Book bookObj	= null;
	
	public static void main(String[] args) {
		Scanner sc 		= new Scanner(System.in);
		int functionID	= 0;
		boolean flag	= true;
		
		do{
			showMenu();
			functionID		= sc.nextInt();
			sc.nextLine();
			
			switch (functionID) {
				case 1: addBook(); break;
				case 2: editBook(); break;
				case 3: infoBook(); break;
				case 4:
				default:
					flag = false;
					break;
			}
		} while(flag == true);
		
		sc.close();
	}
	
	public static void showMenu(){
		myPrint("===================== BOOK MANAGER =====================");
		myPrint("1. Add book");
		myPrint("2. Edit book");
		myPrint("3. Info book");
		myPrint("4. Exit");
		myPrint("Your choise [1-4]: ");
	}
	
	public static void myPrint(String content){
		System.out.println(content);
	}
	
	public static void addBook(){
		Scanner sc			= new Scanner(System.in);
		String bookName		= "";
		String bookID		= "";
		double bookPrice	= 0;
		
		myPrint("ID: ");
		bookID	= sc.nextLine();
		
		myPrint("Name: ");
		bookName	= sc.nextLine();
		
		myPrint("Price: ");
		bookPrice	= sc.nextDouble();
		
		bookObj	= new Book(bookID, bookName, bookPrice);
		
	}
	
	public static void editBook(){
		if(bookObj != null) {
			Scanner sc			= new Scanner(System.in);
			String bookName		= "";
			double bookPrice	= 0;
			
			myPrint("Name: ");
			bookName	= sc.nextLine();
			
			myPrint("Price: ");
			bookPrice	= sc.nextDouble();
			
			bookObj.setName(bookName);
			bookObj.setPrice(bookPrice);
		}else{
			myPrint("Book is not exist!");
		}
	}
	
	public static void infoBook(){
		if(bookObj != null) {
			bookObj.showInfo();
		}else{
			myPrint("Book is not exist!");
		}
	}
	

}

