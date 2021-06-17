package LinkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoublyCircularLinkedListTest {

	private DoublyCircularLinkedList<Integer> creationWithoutValueList;
	private DoublyCircularLinkedList<Integer> creationWithValueList;
	
	@BeforeEach
	public void setUp() {
		this.creationWithoutValueList = new DoublyCircularLinkedList<>();
		this.creationWithValueList = new DoublyCircularLinkedList<>(Integer.MAX_VALUE);
	}

	@Test
	public void testConstructors() {
		assertEquals(0, this.creationWithoutValueList.size());
		assertEquals(1, this.creationWithValueList.size());
		assertEquals(true, this.creationWithValueList.contains(Integer.MAX_VALUE));
	}
	
	@Test
	public void testAddFirst() {
		assertEquals(Integer.MAX_VALUE, this.creationWithValueList.getFirst().getVal());
		assertEquals(1, this.creationWithValueList.size());
		this.creationWithValueList.addFirst(0);
		assertEquals(2, this.creationWithValueList.size());
		assertEquals(0, this.creationWithValueList.getFirst().getVal());
	}
	
	@Test
	public void testAddLast() {
		assertEquals(Integer.MAX_VALUE, this.creationWithValueList.getLast().getVal());
		assertEquals(1, this.creationWithValueList.size());
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
		assertEquals(false, this.creationWithValueList.isEmpty());
		this.creationWithValueList.clear();
		assertEquals(true, this.creationWithValueList.isEmpty());
		assertEquals(0, this.creationWithValueList.size());
	}
	
	@Test
	public void testGetGivenIndex() {
		assertEquals(true, this.creationWithoutValueList.isEmpty());
		DLinkedListNode<Integer> node = (DLinkedListNode<Integer>)this.creationWithoutValueList.getFirst();
		assertEquals(null, node);
		assertEquals(false, this.creationWithValueList.isEmpty());
		this.creationWithValueList.clear();
		assertEquals(true, this.creationWithValueList.isEmpty());
		node = (DLinkedListNode<Integer>)this.creationWithValueList.getLast();
		assertEquals(null, node);
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
		assertEquals(false, this.creationWithValueList.contains(-1));
		assertEquals(-1, this.creationWithValueList.indexOf(-1));
		assertEquals(-1, this.creationWithValueList.lastIndexOf(-1));
	}
	
	@Test
	public void testRemoveFirst() {
		assertEquals(true, this.creationWithoutValueList.isEmpty());
		DLinkedListNode<Integer> removed = (DLinkedListNode<Integer>)this.creationWithoutValueList.removeFirst();
		assertEquals(null, removed);
		assertEquals(Integer.MAX_VALUE, this.creationWithValueList.getFirst().getVal());
		removed = (DLinkedListNode<Integer>)this.creationWithValueList.removeFirst();
		assertEquals(null, this.creationWithValueList.getFirst());
		assertEquals(Integer.MAX_VALUE, removed.getVal());
	}
	
	@Test
	public void testRemoveLast() {
		assertEquals(true, this.creationWithoutValueList.isEmpty());
		DLinkedListNode<Integer> removed = (DLinkedListNode<Integer>)this.creationWithoutValueList.removeLast();
		assertEquals(null, removed);
		assertEquals(Integer.MAX_VALUE, this.creationWithValueList.getLast().getVal());
		removed = (DLinkedListNode<Integer>)this.creationWithValueList.removeLast();
		assertEquals(null, this.creationWithValueList.getLast());
		assertEquals(Integer.MAX_VALUE, removed.getVal());
	}
	
	@Test
	public void testRemoveGivenIndex() {
		this.creationWithValueList.add(0);
		this.creationWithValueList.add(-1);
		assertEquals(0, this.creationWithValueList.get(1).getVal());
		assertEquals(3, this.creationWithValueList.size());
		DLinkedListNode<Integer> removed = (DLinkedListNode<Integer>)this.creationWithValueList.removeGivenIndex(1);
		assertEquals(Integer.MAX_VALUE, this.creationWithValueList.get(1).getVal());
		assertEquals(2, this.creationWithValueList.size());
		assertEquals(0, removed.getVal());
		assertEquals(false, this.creationWithValueList.contains(0));
	}
	
	@Test
	public void testRemoveGivenValue() {
		assertEquals(false, this.creationWithValueList.contains(0));
		DLinkedListNode<Integer> removed = (DLinkedListNode<Integer>)this.creationWithValueList.remove(0);
		assertEquals(null, removed);
		assertEquals(true, this.creationWithValueList.contains(Integer.MAX_VALUE));
		removed = (DLinkedListNode<Integer>)this.creationWithValueList.remove(Integer.MAX_VALUE);
		assertEquals(false, this.creationWithValueList.contains(Integer.MAX_VALUE));
		assertEquals(Integer.MAX_VALUE, removed.getVal());
	}
	
	@Test
	public void testRmoveLastOccurrence() {
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
}
