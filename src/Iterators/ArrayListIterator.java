package Iterators;

import java.util.Iterator;

import Arrays.ArrayList;

public class ArrayListIterator<T> implements Iterator<T>{

	private int cursor;
	private int ending;
	private ArrayList<T> list;
	
	public ArrayListIterator(ArrayList<T> myList) {
		this.cursor = 0;
		this.ending = myList.size();
		this.list = myList;
	}
	
	@Override
	public boolean hasNext() {
		return this.cursor != this.ending;
	}

	@Override
	public T next() {
		T val = this.list.get(this.cursor);
		this.cursor += 1;
		return val;
	}
}
