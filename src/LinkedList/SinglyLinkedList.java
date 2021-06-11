package LinkedList;

import java.util.Iterator;

import Iterators.SinglyLinkedListIterator;
import Utils.List;

public class SinglyLinkedList<T> extends LinkedList<T> implements Iterable<T> {
	private ListNode<T> head;
	private int size;
	
	public SinglyLinkedList() {
		this.head = null;
		this.size = 0;
	}
	
	public SinglyLinkedList(T val) {
		this.head = new ListNode<>(val);
		this.size = 1;
	}

	@Override
	public boolean addFirst(T val) {
		return this.add(val, 0);
	}

	@Override
	public boolean addLast(T val) {
		return this.add(val, this.size);
	}
	
	// the default add(T val) method adds new elements to the tail of the list
	@Override
	public boolean add(T val) {
		return this.addLast(val);
	}

	@Override
	public boolean add(T val, int index) {
		this.checkBounds(index);
		ListNode<T> newNode = new ListNode<>(val);
		if (index == 0) {
			newNode.setNext(this.head);
			this.head = newNode;
		} else {
			int count = 0;
			ListNode<T> cursor = this.head;
			while (count < index-1) {
				count += 1;
				cursor = cursor.getNext();
			}
			newNode.setNext(cursor.getNext());
			cursor.setNext(newNode);
		}
		this.size += 1;
		return true;
	}

	@Override
	public void clear() {
		this.head = null;
		this.size = 0;
	}

	@Override
	public boolean contains(T val) {
		if (this.size == 0) {
			return false;
		}
		ListNode<T> cursor = this.head;
		while (cursor != null) {
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
		return this.get(this.size-1);
	}

	@Override
	public ListNode<T> get(int index) {
		this.checkBounds(index);
		if (this.size == 0) {
			throw new NullPointerException();
		}
		ListNode<T> cursor = this.head;
		for (int i = 0; i < index; i++) {
			cursor = cursor.getNext();
		}
		return cursor;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int indexOf(T val) {
		if (!this.contains(val)) {
			return -1;
		}
		int index = 0;
		ListNode<T> cursor = this.head;
		while (cursor != null) {
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
		if (!this.contains(val)) {
			return -1;
		}
		int index = 0;
		ListNode<T> cursor = this.head;
		int res = 0;
		while (cursor != null) {
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
		return this.removeGivenIndex(this.size-1);
	}

	@Override
	public ListNode<T> removeGivenIndex(int index) {
		this.checkBounds(index);
		ListNode<T> removed = null;
		if (index == 0) {
			removed = this.head;
			this.head = this.head.getNext();
			this.size -= 1;
		} else {
			int count = 0;
			ListNode<T> cursor = this.head;
			while (count < index -1) {
				count += 1;
				cursor = cursor.getNext();
			}
			removed = cursor.getNext();
			cursor.setNext(cursor.getNext().getNext());
			this.size -= 1;
		}
		return removed;
	}
	
	@Override
	public ListNode<T> remove(T val) {
		return this.removeFirstOccurrence(val);
	}

	@Override
	public ListNode<T> removeFirstOccurrence(T val) {
		if (!this.contains(val)) {
			return null;
		}
		ListNode<T> removed = null;
		int index = this.indexOf(val);
		if (index == 0) {
			return this.removeFirst();
		}
		if (index == this.size -1) {
			return this.removeLast();
		}
		ListNode<T> cursor = this.head;
		for (int i = 0; i < index - 1; i++) {
			cursor = cursor.getNext();
		}
		removed = cursor.getNext();
		cursor.setNext(cursor.getNext().getNext());
		this.size -= 1;
		return removed;
	}

	@Override
	public ListNode<T> removeLastOccurrence(T val) {
		int lastOccurrence = this.lastIndexOf(val);
		if (lastOccurrence == -1) {
			return null;
		}
		if (lastOccurrence == 0) {
			return this.removeFirst();
		}
		if (lastOccurrence == this.size -1) {
			return this.removeLast();
		}
		ListNode<T> removed = null;
		ListNode<T> cursor = this.head;
		for (int i = 0; i < lastOccurrence - 1; i++) {
			cursor = cursor.getNext();
		}
		removed = cursor.getNext();
		cursor.setNext(cursor.getNext().getNext());
		this.size -= 1;
		return removed;
	}

	@Override
	public void setFirst(T val) {
		if (this.isEmpty()) {
			this.addFirst(val);
		} else {
			this.set(val, 0);
		}
	}
	
	@Override
	public void setLast(T val) {
		if (this.isEmpty()) {
			this.addLast(val);
		} else {
			this.set(val, this.size-1);
		}
	}
	
	@Override
	public void set(T val, int index) {
		this.checkBounds(index);
		if (index == 0) {
			this.head.setVal(val);
		}
		ListNode<T> cursor = this.head;
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
		ListNode<T> cursor = this.head;
		while (cursor.hasNext()) {
			builder.append(cursor.toString());
			builder.append('-');
			cursor = cursor.getNext();
		}
		builder.append(cursor.toString());
		return builder.toString();
	}

	@Override
	public List<T> concatenate(List<T> a, List<T> b) {
		// TODO Auto-generated method stub
		return null;
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
	public void swap(List<T> a, List<T> b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> synchronizedList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean reverse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new SinglyLinkedListIterator<>(this);
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}
	
	private void checkBounds(int index) {
		if (index > this.size || index < 0) {
			throw new IndexOutOfBoundsException(index + "");
		}
	}
}
