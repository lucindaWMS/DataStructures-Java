package LinkedList;

import Utils.List;

public abstract class LinkedList<T> implements List<T>{
	
	public abstract ListNode<T> getFirst();
	public abstract ListNode<T> getLast();
	public abstract ListNode<T> get(int index);
	public abstract ListNode<T> removeFirst();
	public abstract ListNode<T> removeLast();
	public abstract ListNode<T> removeGivenIndex(int index);
	public abstract ListNode<T> remove(T val);
	public abstract ListNode<T> removeFirstOccurrence(T val);
	public abstract ListNode<T> removeLastOccurrence(T val);
}
