package bookstore;

public interface StoreInterface {
	public boolean checkFull();
	public boolean checkEmpty();
	public void add(Object obj);
	public void edit(String ID, String name, double price);
	public void delete(String ID);
	public void find(String ID);
	public void list();
}
