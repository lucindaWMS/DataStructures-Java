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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(T val, int index) {
		// TODO Auto-generated method stub
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
			
		}
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListNode<T> getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListNode<T> get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(T val) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(T val) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListNode<T> removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListNode<T> removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListNode<T> removeGivenIndex(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListNode<T> remove(T val) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListNode<T> removeFirstOccurrence(T val) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListNode<T> removeLastOccurrence(T val) {
		// TODO Auto-generated method stub
		return null;
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
