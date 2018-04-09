package bookstore;

import java.util.Comparator;

public class PriceAZComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Book bookObj1	= (Book) o1;
		Book bookObj2	= (Book) o2;
		
		if(bookObj1.getPrice() > bookObj2.getPrice()) return 1;
		else if(bookObj1.getPrice() < bookObj2.getPrice()) return -1;
		
		return 0;
	}

}
