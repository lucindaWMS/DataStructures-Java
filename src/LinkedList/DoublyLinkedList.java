package LinkedList;

import java.util.Iterator;

import Iterators.DoublyLinkedListIterator;
import Utils.List;

public class DoublyLinkedList<T> extends LinkedList<T> implements Iterable<T> {
	
	private DLinkedListNode<T> head, tail;
	private int size;

	public DoublyLinkedList() {
		this.head = new DLinkedListNode<>(null);
		this.tail = new DLinkedListNode<>(null);
		this.head.setNext(this.tail);
		this.tail.setPrev(this.head);
		this.size = 0;
	}
	
	public DoublyLinkedList(T val) {
		this();
		this.checkNotNull(val);
		DLinkedListNode<T> node = new DLinkedListNode<>(val);
		this.head.setNext(node);
		node.setPrev(this.head);
		this.tail.setPrev(node);
		node.setNext(this.tail);
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
		return new DoublyLinkedListIterator<T>(this);
	}

	@Override
	public boolean addFirst(T val) {
		return this.add(val, 0);
	}

	@Override
	public boolean addLast(T val) {
		return this.add(val, this.size);
	}

	// the default add(T val) method adds the new element to the head of the list
	@Override
	public boolean add(T val) {
		return this.addFirst(val);
	}

	@Override
	public boolean add(T val, int index) {
		this.checkBoundary(index);
		this.checkNotNull(val);
		DLinkedListNode<T> node = new DLinkedListNode<>(val);
		if (index == 0) {
			node.setNext(this.head.getNext());
			this.head.getNext().setPrev(node);
			this.head.setNext(node);
			node.setPrev(this.head);
		} else if (index == this.size) {
			node.setPrev(this.tail.getPrev());
			this.tail.getPrev().setNext(node);
			node.setNext(this.tail);
			this.tail.setPrev(node);
		} else {
			DLinkedListNode<T> cursor = this.head;
			for (int i = 0; i < index; i++) {
				cursor = cursor.getNext();
			}
			node.setNext(cursor.getNext());
			cursor.getNext().setPrev(node);
			cursor.setNext(node);
			node.setPrev(cursor);
		}
		this.size += 1;
		return true;
	}

	@Override
	public void clear() {
		this.head.setNext(this.tail);
		this.tail.setPrev(this.head);
		this.size = 0;
	}

	@Override
	public boolean contains(T val) {
		this.checkNotNull(val);
		if (this.size() == 0) {
			return false;
		}
		DLinkedListNode<T> curr = this.head.getNext();
		while (curr != null) {
			if (curr.getVal() == null) {
				break;
			}
			if (curr.getVal().equals(val)) {
				return true;
			}
			curr = curr.getNext();
		}
		return false;
	}

	@Override
	public DLinkedListNode<T> getFirst() {
		return this.get(0);
	}

	@Override
	public DLinkedListNode<T> getLast() {
		return this.get(this.size-1);
	}

	@Override
	public DLinkedListNode<T> get(int index) {
		this.checkBoundary(index);
		if (index == 0) {
			return this.head.getNext();
		}
		if (index == this.size-1) {
			return this.tail.getPrev();
		}
		DLinkedListNode<T> cursor = this.head;
		for (int i = 0; i <= index; i++) {
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
		if (!this.contains(val)) {
			return -1;
		}
		DLinkedListNode<T> cursor = this.head.getNext();
		int index = 0;
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
		this.checkNotNull(val);
		if (!this.contains(val)) {
			return -1;
		}
		DLinkedListNode<T> cursor = this.tail.getPrev();
		int index = this.size() - 1;
		while (cursor != null) {
			if (cursor.getVal().equals(val)) {
				return index;
			}
			cursor = cursor.getPrev();
			index -= 1;
		}
		return -1;
	}

	@Override
	public ListNode<T> removeFirst() {
		return this.removeGivenIndex(0);
	}

	@Override
	public ListNode<T> removeLast() {
		return this.removeGivenIndex(this.size() - 1);
	}

	@Override
	public ListNode<T> removeGivenIndex(int index) {
		this.checkBoundary(index);
		DLinkedListNode<T> removed = null;
		if (index == 0) {
			removed = this.head.getNext();
			this.head.setNext(removed.getNext());
			removed.getNext().setPrev(this.head);
		} else if (index == this.size() - 1) {
			removed = this.tail.getPrev();
			this.tail.setPrev(removed.getPrev());
			removed.getPrev().setNext(this.tail);
		} else {
			DLinkedListNode<T> cursor = this.head.getNext();
			for (int i = 0; i < index-1; i++) {
				cursor = cursor.getNext();
			}
			removed = cursor.getNext();
			cursor.setNext(removed.getNext());
			removed.getNext().setPrev(cursor);
		}
		removed.setNext(null);
		removed.setPrev(null);
		this.size -= 1;
		return removed;
	}

	@Override
	public ListNode<T> remove(T val) {
		this.checkNotNull(val);
		int index = this.indexOf(val);
		if (index == -1) {
			return null;
		}
		return this.removeGivenIndex(index);
	}

	@Override
	public ListNode<T> removeFirstOccurrence(T val) {
		return this.remove(val);
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
			this.set(val, this.size() - 1);
		}
	}

	@Override
	public void set(T val, int index) {
		this.checkNotNull(val);
		this.checkBoundary(index);
		if (index == 0) {
			this.head.getNext().setVal(val);
		} else if (index == this.size() - 1) {
			this.tail.getPrev().setVal(val);
		} else {
			DLinkedListNode<T> cursor = this.head.getNext();
			for (int i = 0; i < index; i++) {
				cursor = cursor.getNext();
			}
			cursor.setVal(val);
		}
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
		DLinkedListNode<T> cursor = this.head.getNext();
		while (cursor != null) {
			builder.append(cursor.toString());
			if (cursor.getNext() == this.tail) {
				break;
			}
			builder.append('-');
			cursor = cursor.getNext();
		}
		return builder.toString();
	}
	
	public DLinkedListNode<T> getTail() {
		return this.tail;
	}
	
	private void checkBoundary(int index) {
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException(index + "");
		}
	}

	private void checkNotNull(T val) {
		if (val == null) {
			throw new NullPointerException(val.toString());
		}
	}
}
