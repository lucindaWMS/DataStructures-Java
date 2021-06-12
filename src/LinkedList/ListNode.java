package LinkedList;

import Utils.Node;

public class ListNode<T> extends Node<T>{
	private T val;
	private ListNode<T> next;
	
	public ListNode() {
		this.val = null;
		this.next = null;
	}
	
	public ListNode(T val) {
		this.val = val;
		this.next = null;
	}
	
	public ListNode(T val, ListNode<T> node) {
		this.val = val;
		this.next = node;
	}
	
	public void setVal(T val) {
		this.val = val;
	}
	
	public void setNext(ListNode<T> node) {
		this.next = node;
	}
	
	public T getVal() {
		return this.val;
	}
	
	public ListNode<T> getNext() {
		return this.next;
	}
	
	public boolean hasNext() {
		return this.next != null;
	}
	
	@Override
	public String toString() {
		return this.val.toString();
	}
}
