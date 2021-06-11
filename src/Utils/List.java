package Utils;

public interface List<T> {
	public List<T> concatenate(List<T> a, List<T> b);
	public boolean reverse();
	public void rotate(int index);
	public void shuffle();
	public void sort();
	public void swap(List<T> a, List<T> b);
	public List<T> synchronizedList();
}
