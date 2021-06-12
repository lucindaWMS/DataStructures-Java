package LinkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Iterators.DoublyLinkedListIterator;

class DoublyLinkedListTest {
	
	private DoublyLinkedList<Integer> creationWithoutValueList;
	private DoublyLinkedList<Integer> creationWithValueList;
	
	@BeforeEach
	public void setUp() {
		this.creationWithoutValueList = new DoublyLinkedList<>();
		this.creationWithValueList = new DoublyLinkedList<>(Integer.MAX_VALUE);
	}

	@Test
	public void testConstructors() {
		assertEquals(0, this.creationWithoutValueList.size());
		assertEquals(1, this.creationWithValueList.size());
	}
	
	@Test
	public void testAddFirst() {
		assertEquals(1, this.creationWithValueList.size());
		assertEquals(Integer.MAX_VALUE, this.creationWithValueList.getFirst().getVal());
		this.creationWithValueList.addFirst(0);
		assertEquals(2, this.creationWithValueList.size());
		assertEquals(0, this.creationWithValueList.getFirst().getVal());
		assertEquals(Integer.MAX_VALUE, this.creationWithValueList.getLast().getVal());
	}
	
	@Test
	public void testAddLast() {
		assertEquals(1, this.creationWithValueList.size());
		assertEquals(Integer.MAX_VALUE, this.creationWithValueList.getLast().getVal());
		this.creationWithValueList.addLast(0);
		assertEquals(2, this.creationWithValueList.size());
		assertEquals(0, this.creationWithValueList.getLast().getVal());
	}
	
	@Test
	public void testAddGivenIndex() {
		assertEquals(1, this.creationWithValueList.size());
		this.creationWithValueList.add(0);
		this.creationWithValueList.add(1);
		assertEquals(3, this.creationWithValueList.size());
		this.creationWithValueList.add(-1, 1);
		assertEquals(4, this.creationWithValueList.size());
		assertEquals(-1, this.creationWithValueList.get(1).getVal());
	}
	
	@Test
	public void testEmptyTheList() {
		assertEquals(1, this.creationWithValueList.size());
		assertEquals(false, this.creationWithValueList.isEmpty());
		this.creationWithValueList.clear();
		assertEquals(0, this.creationWithValueList.size());
		assertEquals(true, this.creationWithValueList.isEmpty());
	}
	
	@Test
	public void testIndexOf() {
		assertEquals(true, this.creationWithValueList.contains(Integer.MAX_VALUE));
		assertEquals(0, this.creationWithValueList.indexOf(Integer.MAX_VALUE));
		this.creationWithValueList.add(0);
		assertEquals(0, this.creationWithValueList.indexOf(0));
		assertEquals(1, this.creationWithValueList.indexOf(Integer.MAX_VALUE));
		this.creationWithValueList.add(Integer.MAX_VALUE);
		assertEquals(2, this.creationWithValueList.lastIndexOf(Integer.MAX_VALUE));
		assertEquals(0, this.creationWithValueList.indexOf(Integer.MAX_VALUE));
	}
	
	@Test
	public void testRemoveFirst() {
		assertEquals(true, this.creationWithValueList.contains(Integer.MAX_VALUE));
		assertEquals(0, this.creationWithValueList.indexOf(Integer.MAX_VALUE));
		DLinkedListNode<Integer> removed = (DLinkedListNode<Integer>) this.creationWithValueList.removeFirst();
		assertEquals(false, this.creationWithValueList.contains(Integer.MAX_VALUE));
		assertEquals(true, this.creationWithValueList.isEmpty());
		assertEquals(Integer.MAX_VALUE, removed.getVal());
	}
	
	@Test
	public void testRemoveLast() {
		this.creationWithValueList.addLast(0);
		assertEquals(true, this.creationWithValueList.contains(0));
		assertEquals(1, this.creationWithValueList.indexOf(0));
		DLinkedListNode<Integer> removed = (DLinkedListNode<Integer>) this.creationWithValueList.removeLast();
		assertEquals(false, this.creationWithValueList.contains(0));
		assertEquals(0, removed.getVal());
	}
	
	@Test
	public void testRemoveGivenIndex() {
		this.creationWithValueList.add(0);
		this.creationWithValueList.add(1);
		assertEquals(true, this.creationWithValueList.contains(0));
		assertEquals(true, this.creationWithValueList.contains(1));
		assertEquals(1, this.creationWithValueList.indexOf(0));
		DLinkedListNode<Integer> removed = (DLinkedListNode<Integer>) this.creationWithValueList.removeGivenIndex(1);
		assertEquals(false, this.creationWithValueList.contains(0));
		assertEquals(0, removed.getVal());
	}
	
	@Test
	public void testRemoveGivenValue() {
		assertEquals(true, this.creationWithValueList.contains(Integer.MAX_VALUE));
		assertEquals(1, this.creationWithValueList.size());
		DLinkedListNode<Integer> removed = (DLinkedListNode<Integer>) this.creationWithValueList.remove(1);
		assertEquals(null, removed);
		removed = (DLinkedListNode<Integer>) this.creationWithValueList.remove(Integer.MAX_VALUE);
		assertEquals(false, this.creationWithValueList.contains(Integer.MAX_VALUE));
		assertEquals(0, this.creationWithValueList.size());
		assertEquals(Integer.MAX_VALUE, removed.getVal());
	}
	
	@Test
	public void testRemoveLastOccurrence() {
		this.creationWithValueList.add(0);
		this.creationWithValueList.add(Integer.MAX_VALUE);
		assertEquals(0, this.creationWithValueList.indexOf(Integer.MAX_VALUE));
		assertEquals(2, this.creationWithValueList.lastIndexOf(Integer.MAX_VALUE));
		DLinkedListNode<Integer> removed = (DLinkedListNode<Integer>) this.creationWithValueList.removeFirstOccurrence((Integer.MAX_VALUE));
		assertEquals(Integer.MAX_VALUE, removed.getVal());
		assertEquals(1, this.creationWithValueList.indexOf(Integer.MAX_VALUE));
		assertEquals(1, this.creationWithValueList.lastIndexOf(Integer.MAX_VALUE));
		removed = null;
		removed = (DLinkedListNode<Integer>) this.creationWithValueList.removeLastOccurrence(Integer.MAX_VALUE);
		assertEquals(Integer.MAX_VALUE, removed.getVal());
		assertEquals(false, this.creationWithValueList.contains(Integer.MAX_VALUE));
	}
	
	@Test
	public void testSetFirst() {
		assertEquals(true,  this.creationWithoutValueList.isEmpty());
		this.creationWithoutValueList.setFirst(0);
		assertEquals(1, this.creationWithoutValueList.size());
		assertEquals(true, this.creationWithoutValueList.contains(0));
		assertEquals(Integer.MAX_VALUE, this.creationWithValueList.getFirst().getVal());
		this.creationWithValueList.setFirst(0);
		assertEquals(0, this.creationWithValueList.getFirst().getVal());
	}
	
	@Test
	public void testSetLast() {
		assertEquals(true, this.creationWithoutValueList.isEmpty());
		this.creationWithoutValueList.setLast(0);
		assertEquals(1, this.creationWithoutValueList.size());
		assertEquals(true, this.creationWithoutValueList.contains(0));
		this.creationWithValueList.addLast(-1);
		assertEquals(-1, this.creationWithValueList.getLast().getVal());
		this.creationWithValueList.setLast(0);
		assertEquals(0, this.creationWithValueList.getLast().getVal());
	}
	
	@Test
	public void testSetGivenIndex() {
		this.creationWithValueList.add(0);
		this.creationWithValueList.add(1);
		assertEquals(true, this.creationWithValueList.contains(0));
		assertEquals(1, this.creationWithValueList.indexOf(0));
		this.creationWithValueList.set(-1, 1);
		assertEquals(false, this.creationWithValueList.contains(0));
		assertEquals(-1, this.creationWithValueList.get(1).getVal());
	}
	
	@Test
	public void testToString() {
		this.creationWithValueList.setFirst(-1);
		this.creationWithValueList.add(0);
		this.creationWithValueList.add(1);
		String result = this.creationWithValueList.toString();
		assertEquals("1-0--1", result);
	}
	
	@Test
	public void testIterator() {
		DoublyLinkedListIterator<Integer> it = (DoublyLinkedListIterator<Integer>)this.creationWithValueList.iterator();
		this.creationWithValueList.add(0);
		this.creationWithValueList.add(1);
		this.creationWithValueList.add(2);
		assertEquals(Integer.MAX_VALUE, this.creationWithValueList.getLast().getVal());
		int last = 0;
		while(it.hasNext()) {
			last = it.next();
		}
		assertEquals(Integer.MAX_VALUE, last);
	}
}
