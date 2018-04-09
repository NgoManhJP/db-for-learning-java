package bookstore;

import java.util.Comparator;

public class NameAZComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Book bookObj1	= (Book) o1;
		Book bookObj2	= (Book) o2;
		
		return bookObj1.getName().compareToIgnoreCase(bookObj2.getName());
	}

}
