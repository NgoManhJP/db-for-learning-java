package bookstore;

import java.util.Comparator;

public class NameAZComparator implements Comparator<Book>{
	@Override
	public int compare(Book bookObj1, Book bookObj2) {
		return bookObj1.getName().compareToIgnoreCase(bookObj2.getName());
	}

}
