package LinkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Iterators.SinglyCircularLinkedListIterator;

class SinglyCircularLinkedListTest {
	
	private SinglyCircularLinkedList<Integer> creationWithoutValueList;
	private SinglyCircularLinkedList<Integer> creationWithValueList;
	
	@BeforeEach
	public void setUp() {
		this.creationWithoutValueList = new SinglyCircularLinkedList<>();
		this.creationWithValueList = new SinglyCircularLinkedList<>(Integer.MAX_VALUE);
	}

	@Test
	public void testConstructors() {
		assertEquals(0, this.creationWithoutValueList.size());
		assertEquals(1, this.creationWithValueList.size());
		assertEquals(true, this.creationWithValueList.contains(Integer.MAX_VALUE));
	}

	@Test
	public void testAddFirst() {
		this.creationWithValueList.addFirst(0);
		assertEquals(0, this.creationWithValueList.getFirst().getVal());
		assertEquals(Integer.MAX_VALUE, this.creationWithValueList.get(1).getVal());
		assertEquals(2, this.creationWithValueList.size());
	}
	
	@Test
	public void testAddLast() {
		this.creationWithValueList.addLast(0);
		assertEquals(0, this.creationWithValueList.getLast().getVal());
		assertEquals(Integer.MAX_VALUE, this.creationWithValueList.get(0).getVal());
		assertEquals(2, this.creationWithValueList.size());
	}
	
	@Test
	public void testAddGivenIndex() {
		this.creationWithValueList.add(0);
		this.creationWithValueList.add(1);
		assertEquals(3, this.creationWithValueList.size());
		this.creationWithValueList.add(-1, 1);
		assertEquals(-1, this.creationWithValueList.get(1).getVal());
		assertEquals(4, this.creationWithValueList.size());
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
	public void testGetGivenIndex() {
		assertEquals(0, this.creationWithoutValueList.size());
		DLinkedListNode<Integer> node = (DLinkedListNode<Integer>)this.creationWithoutValueList.getFirst();
		assertEquals(null, node);
		this.creationWithValueList.clear();
		assertEquals(true, this.creationWithValueList.isEmpty());
		node = (DLinkedListNode<Integer>) this.creationWithValueList.getLast();
		assertEquals(null, node);
	}
	
	@Test
	public void testIndexOf() {
		assertEquals(true, this.creationWithValueList.contains(Integer.MAX_VALUE));
		assertEquals(0, this.creationWithValueList.indexOf(Integer.MAX_VALUE));
		this.creationWithValueList.add(0);
		this.creationWithValueList.add(1);
		this.creationWithValueList.add(0);
		assertEquals(1, this.creationWithValueList.indexOf(0));
		assertEquals(3, this.creationWithValueList.lastIndexOf(0));
		assertEquals(false, this.creationWithValueList.contains(-1));
		assertEquals(-1, this.creationWithValueList.indexOf(-1));
		assertEquals(-1, this.creationWithValueList.lastIndexOf(-1));
	}
	
	@Test
	public void testRemoveFirst() {
		assertEquals(true, this.creationWithValueList.contains(Integer.MAX_VALUE));
		assertEquals(1, this.creationWithValueList.size());
		ListNode<Integer> removed = this.creationWithValueList.removeFirst();
		assertEquals(true, this.creationWithValueList.isEmpty());
		assertEquals(Integer.MAX_VALUE, removed.getVal());
		assertEquals(true, this.creationWithoutValueList.isEmpty());
		removed = (DLinkedListNode<Integer>) this.creationWithoutValueList.removeFirst();
		assertEquals(null, removed);
	}
	
	@Test
	public void testRemoveLast() {
		assertEquals(true, this.creationWithValueList.contains(Integer.MAX_VALUE));
		assertEquals(1, this.creationWithValueList.size());
		ListNode<Integer> removed = this.creationWithValueList.removeLast();
		assertEquals(true, this.creationWithValueList.isEmpty());
		assertEquals(Integer.MAX_VALUE, removed.getVal());
		assertEquals(true, this.creationWithoutValueList.isEmpty());
		removed = (DLinkedListNode<Integer>) this.creationWithoutValueList.removeLast();
		assertEquals(null, removed);
	}
	
	@Test
	public void testRemoveGivenIndex() {
		this.creationWithValueList.add(0);
		this.creationWithValueList.add(1);
		assertEquals(3, this.creationWithValueList.size());
		assertEquals(0, this.creationWithValueList.get(1).getVal());
		ListNode<Integer> removed = this.creationWithValueList.removeGivenIndex(1);
		assertEquals(2, this.creationWithValueList.size());
		assertEquals(1, this.creationWithValueList.get(1).getVal());
		assertEquals(0, removed.getVal());
	}
	
	@Test
	public void testRemoveGivenValue() {
		this.creationWithValueList.add(0);
		assertEquals(2, this.creationWithValueList.size());
		assertEquals(true, this.creationWithValueList.contains(0));
		ListNode<Integer> removed = this.creationWithValueList.remove(0);
		assertEquals(1, this.creationWithValueList.size());
		assertEquals(false, this.creationWithValueList.contains(0));
		assertEquals(0, removed.getVal());
		removed = this.creationWithValueList.remove(-1);
		assertEquals(null, removed);
	}
	
	@Test
	public void testRemoveLastOccurrence() {
		this.creationWithValueList.add(0);
		this.creationWithValueList.add(0);
		assertEquals(3, this.creationWithValueList.size());
		assertEquals(0, this.creationWithValueList.getLast().getVal());
		ListNode<Integer> removed = this.creationWithValueList.removeLastOccurrence(0);
		assertEquals(2, this.creationWithValueList.size());
		assertEquals(0, this.creationWithValueList.getLast().getVal());
		assertEquals(0, removed.getVal());
		ListNode<Integer> newlyRemoved = this.creationWithValueList.removeFirstOccurrence(0);
		assertEquals(1, this.creationWithValueList.size());
		assertEquals(false, this.creationWithValueList.contains(0));
		assertEquals(Integer.MAX_VALUE, this.creationWithValueList.getLast().getVal());
		assertEquals(0, newlyRemoved.getVal());
	}
	
	@Test
	public void testSetFirst() {
		assertEquals(Integer.MAX_VALUE, this.creationWithValueList.getFirst().getVal());
		assertEquals(1, this.creationWithValueList.size());
		this.creationWithValueList.setFirst(0);
		assertEquals(0, this.creationWithValueList.get(0).getVal());
		assertEquals(1, this.creationWithValueList.size());
		assertEquals(true, this.creationWithoutValueList.isEmpty());
		this.creationWithoutValueList.setFirst(0);
		assertEquals(1, this.creationWithoutValueList.size());
		assertEquals(true, this.creationWithoutValueList.contains(0));
	}
	
	@Test
	public void testSetLast() {
		assertEquals(Integer.MAX_VALUE, this.creationWithValueList.getLast().getVal());
		assertEquals(1, this.creationWithValueList.size());
		this.creationWithValueList.setLast(0);
		assertEquals(0, this.creationWithValueList.getLast().getVal());
		assertEquals(1, this.creationWithValueList.size());
		assertEquals(true, this.creationWithoutValueList.isEmpty());
		this.creationWithoutValueList.setLast(0);
		assertEquals(1, this.creationWithoutValueList.size());
		assertEquals(true, this.creationWithoutValueList.contains(0));
	}
	
	@Test
	public void testSetGivenIndex() {
		this.creationWithValueList.add(0);
		this.creationWithValueList.add(1);
		assertEquals(3, this.creationWithValueList.size());
		assertEquals(0, this.creationWithValueList.get(1).getVal());
		this.creationWithValueList.set(-1, 1);
		assertEquals(3, this.creationWithValueList.size());
		assertEquals(-1, this.creationWithValueList.get(1).getVal());
	}
	
	@Test
	public void testToString() {
		this.creationWithValueList.setFirst(-1);
		this.creationWithValueList.add(0);
		this.creationWithValueList.add(1);
		String result = this.creationWithValueList.toString();
		assertEquals("-1-0-1", result);
	}
	
	@Test
	public void testIterator() {
		SinglyCircularLinkedListIterator<Integer> it = (SinglyCircularLinkedListIterator<Integer>) this.creationWithValueList.iterator();
		this.creationWithValueList.add(0);
		this.creationWithValueList.add(1);
		this.creationWithValueList.add(2);
		assertEquals(2, this.creationWithValueList.getLast().getVal());
		int last = 0;
		while (it.hasNext()) {
			last = it.next();
		}
		assertEquals(2, last);
	}
}
