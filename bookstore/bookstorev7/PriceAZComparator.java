package bookstore;

import java.util.Comparator;

public class PriceAZComparator implements Comparator<Book>{

	@Override
	public int compare(Book bookObj1, Book bookObj2) {
		// TODO Auto-generated method stub
		if(bookObj1.getPrice() > bookObj2.getPrice()) return 1;
		else if(bookObj1.getPrice() < bookObj2.getPrice()) return -1;
		
		return 0;
	}

}
