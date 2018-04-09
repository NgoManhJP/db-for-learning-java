package bookstore;

import java.util.*;

// listItems[i]		listItems.get(i)
public class BookStore implements StoreInterface{
	private final int MAX_ITEMS	= 10;		// Số quyển sách lớn nhất mà kho sách chứa được
	private List listItems		= null;
	
	public BookStore(){
		listItems	= new LinkedList();
	}
	
	public int getItemPosition(String bookID){
		Iterator itr	= listItems.iterator();
		int i			= 0;
		while(itr.hasNext()){
			Book bookObj = (Book) itr.next();
			if(bookID.equals(bookObj.getID())) return i;
			i++;
		}
		return -1;
	}
	
	// checkFull
	public boolean checkFull(){
		if(getTotalItems() == MAX_ITEMS) return true;
		return false;
	}
	
	// checkEmpty
	public boolean checkEmpty(){
		return listItems.isEmpty();
	}
	
	@Override
	public void add(Object obj) {
		Book bookObj	= (Book) obj;
		if(!this.checkFull()){
			listItems.add(bookObj);
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
			Book bookObj	= (Book) listItems.get(bookPosition);
			bookObj.setName(bookName);
			bookObj.setPrice(bookPrice);
			System.out.println("Edit successfull!");
		}
	}
	
	// Delete book
	public void delete(String bookID){
		int bookPosition	= this.getItemPosition(bookID);
		if(bookPosition == -1){
			System.out.println("This book is not exist!");
		}else{
			listItems.remove(bookPosition);
			System.out.println("Delete successfull!");
		}
	}
	
	// Find book
	public void find(String bookID){
		int bookPosition	= this.getItemPosition(bookID);
		if(bookPosition == -1){
			System.out.println("This book is not exist!");
		}else{
			System.out.println(listItems.get(bookPosition));
		}
	}
	
	// list book
	public void list(){
		if(this.checkEmpty() == false){
			Iterator itr	= listItems.iterator();
			while(itr.hasNext()){
				Book bookObj = (Book) itr.next();
				System.out.println(bookObj);
			}
		}else{
			System.out.println("Store is empty!");
		}
	}

	public int getTotalItems() {
		return listItems.size();
	}

	public void sortNameAZ(){
		Collections.sort(listItems, new NameAZComparator());
	}
	
	public void sortNameZA(){
		Collections.sort(listItems, new NameZAComparator());
	}
	
	public void sortPriceAZ(){
		Collections.sort(listItems, new PriceAZComparator());
	}
	
	public void sortPriceZA(){
		Collections.sort(listItems, new PriceAZComparator());
		Collections.reverse(listItems);
	}
}
