package Iterators;

import java.util.Iterator;

import LinkedList.DLinkedListNode;
import LinkedList.DoublyLinkedList;

public class DoublyLinkedListIterator<T> implements Iterator<T>{
	
	DLinkedListNode<T> cursor;
	
	public DoublyLinkedListIterator(DoublyLinkedList<T> list) {
		this.cursor = list.getFirst();
	}

	@Override
	public boolean hasNext() {
		return this.cursor.getVal() != null;
	}

	@Override
	public T next() {
		T val = this.cursor.getVal();
		this.cursor = this.cursor.getNext();
		return val;
	}
}
