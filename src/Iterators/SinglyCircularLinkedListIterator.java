package Iterators;

import java.util.Iterator;

import LinkedList.ListNode;
import LinkedList.SinglyCircularLinkedList;

public class SinglyCircularLinkedListIterator<T> implements Iterator<T> {
	ListNode<T> cursor;
	ListNode<T> head;
	
	public SinglyCircularLinkedListIterator(SinglyCircularLinkedList<T> list) {
		this.cursor = list.getFirst();
		this.head = list.getHead();
	}

	@Override
	public boolean hasNext() {
		return this.cursor != this.head;
	}

	@Override
	public T next() {
		T val = this.cursor.getVal();
		this.cursor = this.cursor.getNext();
		return val;
	}
}
