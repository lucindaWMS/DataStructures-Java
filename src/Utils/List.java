package Utils;

public interface List<T> {
	
	public List<T> concatenate(List<T> a, List<T> b);
	public boolean reverse();
	public void rotate(int index);
	public void shuffle();
	public void sort();
	public void swap(List<T> a, List<T> b);
	public List<T> synchronizedList();
	public boolean addFirst(T val);
	public boolean addLast(T val);
	public boolean add(T val);
	public boolean add(T val, int index);
	public void clear();
	public boolean contains(T val);
	public boolean isEmpty();
	public int indexOf(T val);
	public int lastIndexOf(T val);
	public void setFirst(T val);
	public void setLast(T val);
	public void set(T val, int index);
	public int size();
	public String toString();
}
