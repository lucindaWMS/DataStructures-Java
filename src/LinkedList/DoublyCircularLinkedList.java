package LinkedList;

import java.util.Iterator;

import Utils.List;

public class DoublyCircularLinkedList<T> extends LinkedList<T> implements Iterable<T>{
	
	private DLinkedListNode<T> head, tail;
	private int size;
	
	public DoublyCircularLinkedList() {
		this.head = new DLinkedListNode<>(null);
		this.tail = new DLinkedListNode<>(null);
		this.size = 0;
		this.head.setNext(this.tail);
		this.head.setPrev(this.tail);
		this.tail.setNext(this.head);
		this.tail.setPrev(this.head);
	}
	
	public DoublyCircularLinkedList(T val) {
		this();
		this.checkNotNull(val);
		DLinkedListNode<T> node = new DLinkedListNode<>(val);
		node.setNext(this.tail);
		node.setPrev(this.head);
		this.head.setNext(node);
		this.tail.setPrev(node);
		this.size = 1;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addFirst(T val) {
		return this.add(val, 0);
	}

	@Override
	public boolean addLast(T val) {
		return this.add(val, this.size());
	}

	// the default add(T val) method adds the new element to the head of the list
	@Override
	public boolean add(T val) {
		this.checkNotNull(val);
		return this.addFirst(val);
	}

	@Override
	public boolean add(T val, int index) {
		this.checkNotNull(val);
		this.checkBoundary(index);
		DLinkedListNode<T> node = new DLinkedListNode<>(val);
		if (index == 0) {
			node.setNext(this.head.getNext());
			this.head.getNext().setPrev(node);
			node.setPrev(this.head);
			this.head.setNext(node);
		} else if (index == this.size()) {
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
		this.head.setPrev(this.tail);
		this.tail.setNext(this.head);
		this.tail.setPrev(this.head);
		this.size = 0;
	}

	@Override
	public boolean contains(T val) {
		this.checkNotNull(val);
		DLinkedListNode<T> cursor = this.head.getNext();
		while (cursor != this.tail) {
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
		if (this.isEmpty()) {
			return null;
		}
		this.checkBoundary(index);
		if (index == 0) {
			return this.head.getNext();
		}
		if (index == this.size()-1) {
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
		DLinkedListNode<T> cursor = this.head;
		int index = 0;
		while (cursor != this.tail) {
			cursor = cursor.getNext();
			if (cursor.getVal().equals(val)) {
				return index;
			}
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
		DLinkedListNode<T> cursor = this.tail;
		int index = this.size();
		while (cursor != this.head) {
			index -= 1;
			cursor = cursor.getPrev();
			if (cursor.getVal().equals(val)) {
				return index;
			}
		}
		return -1;
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
		if (this.isEmpty()) {
			return null;
		}
		this.checkBoundary(index);
		DLinkedListNode<T> removed = null;
		if (index == 0) {
			removed = this.head.getNext();
			removed.getNext().setPrev(this.head);
			this.head.setNext(removed.getNext());
		} else if (index == this.size()-1) {
			removed = this.tail.getPrev();
			removed.getPrev().setNext(this.tail);
			this.tail.setPrev(removed.getPrev());
		} else {
			DLinkedListNode<T> cursor = this.head;
			for (int i = 0; i < index; i++) {
				cursor = cursor.getNext();
			}
			removed = cursor.getNext();
			cursor.setNext(removed.getNext());
			removed.getNext().setPrev(cursor);
		}
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLast(T val) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(T val, int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	private void checkNotNull(T val) {
		if (val == null) {
			throw new NullPointerException(val.toString());
		}
	}
	
	private void checkBoundary(int index) {
		if (index < 0 || index > this.size()) {
			throw new IndexOutOfBoundsException(index + "");
		}
	}
}
