package Model;

public interface CommandInterface {
	public boolean add(Object obj);
	public boolean remove(String nameToRemove);
	public Object getItem(String id);
}

