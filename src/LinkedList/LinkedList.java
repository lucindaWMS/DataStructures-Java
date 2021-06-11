package LinkedList;

import Utils.List;

public abstract class LinkedList<T> implements List<T>{
	public abstract boolean addFirst(T val);
	public abstract boolean addLast(T val);
	public abstract boolean add(T val);
	public abstract boolean add(T val, int index);
	public abstract void clear();
	public abstract boolean contains(T val);
	public abstract ListNode<T> getFirst();
	public abstract ListNode<T> getLast();
	public abstract ListNode<T> get(int index);
	public abstract boolean isEmpty();
	public abstract int indexOf(T val);
	public abstract int lastIndexOf(T val);
	public abstract ListNode<T> removeFirst();
	public abstract ListNode<T> removeLast();
	public abstract ListNode<T> removeGivenIndex(int index);
	public abstract ListNode<T> remove(T val);
	public abstract ListNode<T> removeFirstOccurrence(T val);
	public abstract ListNode<T> removeLastOccurrence(T val);
	public abstract void setFirst(T val);
	public abstract void setLast(T val);
	public abstract void set(T val, int index);
	public abstract int size();
	public abstract String toString();
}
