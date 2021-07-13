package Arrays;

import java.util.Iterator;

import Iterators.ArrayListIterator;
import LinkedList.ListNode;
import Utils.List;

public class ArrayList<T> implements List<T>, Iterable<T>{
	
	private T[] myList;
	private int capacity;
	private int size;
	
	public ArrayList() {
		this.capacity = 1;
		this.size = 0;
		this.myList = (T[]) new Object[this.capacity];
	}
	
	public ArrayList(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.myList = (T[]) new Object[this.capacity];
	}

	@Override
	public List<T> concatenate(List<T> a, List<T> b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean reverse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void rotate(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shuffle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swap(List<T> a, List<T> b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> synchronizedList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addFirst(T val) {
		return this.add(val, 0);
	}

	@Override
	public boolean addLast(T val) {
		return this.add(val, this.size);
	}

	//The new element is added to the tail of the list by default
	@Override
	public boolean add(T val) {
		return this.add(val, this.size);
	}

	@Override
	public boolean add(T val, int index) {
		if (index < 0 || index > this.size()) {
			throw new IndexOutOfBoundsException(index + "");
		}
		if (this.isEmpty()) {
			this.myList[index] = val;
			this.size += 1;
		} else {
			for (int i = this.size(); i > index; i--) {
				this.myList[i] = this.myList[i-1];
			}
			this.myList[index] = val;
			this.size += 1;
		}
		if (this.size() >= this.capacity) {
			T[] copied = this.expandCapacity();
			this.myList = copied;
			this.capacity *= 2;
		}
		return true;
	}

	@Override
	public void clear() {
		this.myList = (T[]) new Object[this.capacity];
		this.size = 0;
	}

	@Override
	public boolean contains(T val) {
		this.checkNotNull(val);
		if (this.isEmpty()) {
			return false;
		}
		for (int i = 0; i < this.size(); i++) {
			if (this.myList[i].equals(val)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public int indexOf(T val) {
		this.checkNotNull(val);
		if (!this.contains(val)) {
			return -1;
		}
		for (int i = 0; i < this.size(); i++) {
			if (this.myList[i].equals(val)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(T val) {
		this.checkNotNull(val);
		if (!this.contains(val)) {
			return -1;
		}
		for (int i = this.size() - 1; i >= 0; i--) {
			if (this.myList[i].equals(val)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void setFirst(T val) {
		this.set(val,  0);
	}

	@Override
	public void setLast(T val) {
		this.set(val, this.size() - 1);
	}

	@Override
	public void set(T val, int index) {
		this.checkNotNull(val);
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException(index + "");
		}
		this.myList[index] = val;
	}

	@Override
	public int size() {
		return this.size;
	}
	
	public int getCapacity() {
		return this.capacity;
	}

	public T getFirst() {
		return this.get(0);
	}
	
	public T getLast() {
		return this.get(this.size()-1);
	}
	
	public T get(int index) {
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException(index + "");
		}
		return this.myList[index];
	}
	
	public T removeFirst() {
		return this.removeGivenIndex(0);
	}
	
	public T removeLast() {
		return this.removeGivenIndex(this.size() - 1);
	}
	
	public T removeGivenIndex(int index) {
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException(index + "");
		}
		T removed = null;
		if (index == this.size()-1) {
			removed = this.myList[this.size() - 1];
			this.myList[this.size() - 1] = null;
		} else {
			removed = this.myList[index];
			for (int i = index; i < this.size() - 1; i++) {
				this.myList[i] = this.myList[i+1];
			}
			this.myList[this.size() - 1] = null;
		}
		this.size -= 1;
		return removed;
	}
	
	public T remove(T val) {
		int index = this.indexOf(val);
		if (index == -1) {
			return null;
		}
		return this.removeGivenIndex(index);
	}
	
	public T removeFirstOccurrence(T val) {
		return this.remove(val);
	}
	
	public T removeLastOccurrence(T val) {
		int lastIndex = this.lastIndexOf(val);
		if (lastIndex == -1) {
			return null;
		}
		return this.removeGivenIndex(lastIndex);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (this.isEmpty()) {
			return builder.toString();
		}
		for (int i = 0; i < this.size()-1; i++) {
			builder.append(this.myList[i].toString());
			builder.append(", ");
		}
		builder.append(this.myList[this.size()-1]);
		return builder.toString();
	}
	
	private T[] expandCapacity() {
		T[] copied = (T[]) new Object[this.capacity * 2];
		for (int i = 0; i < this.myList.length; i++) {
			copied[i] = this.myList[i];
		}
		return copied;
	}
	
	private void checkNotNull(T val) {
		if (val == null) {
			throw new NullPointerException(val.toString());
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayListIterator<T>(this);
	}
}
