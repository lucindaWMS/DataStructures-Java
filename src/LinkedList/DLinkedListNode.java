package LinkedList;

public class DLinkedListNode<T> extends ListNode<T> {
	private T val;
	private DLinkedListNode<T> prev;
	private DLinkedListNode<T> next;
	
	public DLinkedListNode(T val) {
		this.val = val;
		this.prev = null;
		this.next = null;
	}
	
	public DLinkedListNode(T val, DLinkedListNode<T> prev, DLinkedListNode<T> next) {
		this.val = val;
		this.prev = prev;
		this.next = next;
	}
	
	public void setPrev(DLinkedListNode<T> prev) {
		this.prev = prev;
	}
	
	public DLinkedListNode<T> getPrev() {
		return this.prev;
	}
	
	public boolean hasPrev() {
		return this.prev != null;
	}
	
	public void setNext(DLinkedListNode<T> next) {
		this.next = next;
	}
	
	public DLinkedListNode<T> getNext() {
		return this.next;
	}
	
	public void setVal(T val) {
		this.val = val;
	}
	
	public T getVal() {
		return this.val;
	}
	
	@Override
	public String toString() {
		return this.val.toString();
	}
}
