package bookstore;

import java.util.Comparator;

public class NameZAComparator implements Comparator<Book>{

	@Override
	public int compare(Book bookObj1, Book bookObj2) {
		// TODO Auto-generated method stub
		return bookObj2.getName().compareToIgnoreCase(bookObj1.getName());
	}

}
