package Iterators;

import java.util.Iterator;

import LinkedList.ListNode;
import LinkedList.SinglyLinkedList;

public class SinglyLinkedListIterator<T> implements Iterator<T> {
	
	ListNode<T> cursor;
	
	public SinglyLinkedListIterator(SinglyLinkedList<T> list) {
		this.cursor = list.getFirst();
	}

	@Override
	public boolean hasNext() {
		return this.cursor != null;
	}

	@Override
	public T next() {
		T val = this.cursor.getVal();
		this.cursor = this.cursor.getNext();
		return val;
	}

}
