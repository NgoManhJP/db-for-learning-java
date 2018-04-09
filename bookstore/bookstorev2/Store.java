package bookstore;

import java.util.Scanner;

public class Store {
	private static int totalItems		= 0;		// Số quyển sách hiện tại trong kho sách
	private final int MAX_ITEMS			= 10;		// Số quyển sách lớn nhất mà kho sách chứa được
	private Book[] listItems			= null;
	
	public Store(){
		listItems	= new Book[MAX_ITEMS];
	}
	
	public int getItemPosition(String bookID){
		for(int i = 0; i < totalItems; i++){
			if(bookID.equals(listItems[i].getID())==true) return i;
		}
		return -1;
	}
	
	// checkFull
	public boolean checkFull(){
		if(totalItems == MAX_ITEMS) return true;
		return false;
	}
	
	// checkEmpty
	public boolean checkEmpty(){
		if(totalItems == 0) return true;
		return false;
	}
	
	// Add book
	public void add(Book bookObj){
		if(this.checkFull() == false){
			this.listItems[totalItems]	= bookObj;
			this.totalItems++;
			System.out.println("Add successfull!");
		}else{
			System.out.println("Store is full!");
		}
	}
	
	// Edit book
	public void edit(String bookID, String bookName, double bookPrice){
		int bookPosition	= this.getItemPosition(bookID);
		if(bookPosition == -1){
			System.out.println("This book is not exist!");
		}else{
			listItems[bookPosition].setName(bookName);
			listItems[bookPosition].setPrice(bookPrice);
			System.out.println("Edit successfull!");
		}
	}
	
	// Delete book
	public void delete(String bookID){
		int bookPosition	= this.getItemPosition(bookID);
		if(bookPosition == -1){
			System.out.println("This book is not exist!");
		}else{
			for(int i = bookPosition; i < totalItems - 1; i++){
				listItems[i] = listItems[i+1];
			}
			this.totalItems--;
			System.out.println("Delete successfull!");
		}
	}
	
	// Find book
	public void find(String bookID){
		// listItems[bookPosition]	= [1 Java 		20]
		// listItems[bookPosition]	= [2 Android	30]
		// listItems[bookPosition]	= [3 PHP		10]
		int bookPosition	= this.getItemPosition(bookID);
		if(bookPosition == -1){
			System.out.println("This book is not exist!");
		}else{
			listItems[bookPosition].showInfo();
		}
	}
	
	// list book
	public void list(){
		if(this.checkEmpty() == false){
			for(int i = 0; i < totalItems; i++){
				this.listItems[i].showInfo();
			}
		}else{
			System.out.println("Store is empty!");
		}
	}
}
