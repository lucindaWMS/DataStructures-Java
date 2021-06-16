package LinkedList;

import java.util.Iterator;

import Iterators.SinglyCircularLinkedListIterator;
import Utils.List;

public class SinglyCircularLinkedList<T> extends LinkedList<T> implements Iterable<T>{
	
	private ListNode<T> head;
	private int size;
	
	public SinglyCircularLinkedList() {
		this.head = new ListNode<T>();
		this.size = 0;
	}

	public SinglyCircularLinkedList(T val) {
		this();
		ListNode<T> node = new ListNode<>(val);
		this.head.setNext(node);
		node.setNext(this.head);
		this.size += 1;
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
	public Iterator<T> iterator() {
		return new SinglyCircularLinkedListIterator<T>(this);
	}

	@Override
	public boolean addFirst(T val) {
		return this.add(val, 0);
	}

	@Override
	public boolean addLast(T val) {
		return this.add(val, this.size());
	}

	// the default add(T val) method adds new elements to the tail of the list
	@Override
	public boolean add(T val) {
		return this.addLast(val);
	}

	@Override
	public boolean add(T val, int index) {
		this.checkNotNull(val);
		this.checkBoundary(index);
		ListNode<T> node = new ListNode<>(val);
		if (index == 0) {
			node.setNext(this.head.getNext());
			this.head.setNext(node);
		} else {
			ListNode<T> cursor = this.head.getNext();
			for (int i = 0; i < index-1; i++) {
				cursor = cursor.getNext();
			}
			node.setNext(this.head);
			cursor.setNext(node);
		}
		this.size += 1;
		return true;
	}

	@Override
	public void clear() {
		this.head.setNext(null);
		this.size = 0;
	}

	@Override
	public boolean contains(T val) {
		this.checkNotNull(val);
		if (this.size() == 0) {
			return false;
		}
		ListNode<T> cursor = this.head.getNext();
		while (cursor != this.head) {
			if (cursor.getVal().equals(val)) {
				return true;
			}
			cursor = cursor.getNext();
		}
		return false;
	}

	@Override
	public ListNode<T> getFirst() {
		return this.get(0);
	}

	@Override
	public ListNode<T> getLast() {
		return this.get(this.size()-1);
	}

	@Override
	public ListNode<T> get(int index) {
		this.checkBoundary(index);
		if (index == 0) {
			return this.head.getNext();
		}
		ListNode<T> cursor = this.head.getNext();
		for (int i = 0; i < index; i++) {
			cursor = cursor.getNext();
		}
		return cursor;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public int indexOf(T val) {
		this.checkNotNull(val);
		if (! this.contains(val)) {
			return -1;
		}
		int index = 0;
		ListNode<T> cursor = this.head.getNext();
		while (cursor != this.head) {
			if (cursor.getVal().equals(val)) {
				return index;
			}
			cursor = cursor.getNext();
			index += 1;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(T val) {
		this.checkNotNull(val);
		if (! this.contains(val)) {
			return -1;
		}
		int index = 0;
		int res = 0;
		ListNode<T> cursor = this.head.getNext();
		while (cursor != this.head) {
			if (cursor.getVal().equals(val)) {
				res = index;
			}
			cursor = cursor.getNext();
			index += 1;
		}
		return res;
	}

	@Override
	public ListNode<T> removeFirst() {
		return this.removeGivenIndex(0);
	}

	@Override
	public ListNode<T> removeLast() {
		return this.removeGivenIndex(this.size()-1);
	}

	@Override
	public ListNode<T> removeGivenIndex(int index) {
		this.checkBoundary(index);
		ListNode<T> removed = null;
		if (index == 0) {
			removed = this.head.getNext();
			if (this.size() == 1) {
				this.head.setNext(null);
			} else {
				this.head.setNext(removed.getNext());
			}
		} else {
			ListNode<T> cursor = this.head.getNext();
			for (int i = 0; i < index-1; i++) {
				cursor = cursor.getNext();
			}
			removed = cursor.getNext();
			cursor.setNext(removed.getNext());
		}
		this.size -= 1;
		return removed;
	}

	@Override
	public ListNode<T> remove(T val) {
		return this.removeFirstOccurrence(val);
	}

	@Override
	public ListNode<T> removeFirstOccurrence(T val) {
		this.checkNotNull(val);
		int index = this.indexOf(val);
		if (index == -1) {
			return null;
		}
		return this.removeGivenIndex(index);
	}

	@Override
	public ListNode<T> removeLastOccurrence(T val) {
		this.checkNotNull(val);
		int index = this.lastIndexOf(val);
		if (index == -1) {
			return null;
		}
		return this.removeGivenIndex(index);
	}

	@Override
	public void setFirst(T val) {
		this.checkNotNull(val);
		if (this.isEmpty()) {
			this.addFirst(val);
		} else {
			this.set(val, 0);
		}
	}

	@Override
	public void setLast(T val) {
		this.checkNotNull(val);
		if (this.isEmpty()) {
			this.addLast(val);
		} else {
			this.set(val, this.size-1);
		}
	}

	@Override
	public void set(T val, int index) {
		this.checkNotNull(val);
		this.checkBoundary(index);
		ListNode<T> cursor = this.head.getNext();
		for (int i = 0; i < index; i++) {
			cursor = cursor.getNext();
		}
		cursor.setVal(val);
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (this.isEmpty()) {
			return builder.toString();
		}
		ListNode<T> cursor = this.head.getNext();
		while (cursor.getNext() != this.head) {
			builder.append(cursor.toString());
			builder.append('-');
			cursor = cursor.getNext();
		}
		builder.append(cursor.toString());
		return builder.toString();
	}
	
	public ListNode<T> getHead() {
		return this.head;
	}
	
	private void checkBoundary(int index) {
		if (index < 0 || index > this.size()) {
			throw new IndexOutOfBoundsException(index + "");
		}
	}
	
	private void checkNotNull(T val) {
		if (val == null) {
			throw new NullPointerException(val.toString());
		}
	}
}
