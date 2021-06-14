package LinkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	public void testIndexOf() {
		assertEquals(true, this.creationWithValueList.contains(Integer.MAX_VALUE));
		assertEquals(0, this.creationWithValueList.indexOf(Integer.MAX_VALUE));
		this.creationWithValueList.add(0);
		this.creationWithValueList.add(1);
		this.creationWithValueList.add(0);
		assertEquals(1, this.creationWithValueList.indexOf(0));
		assertEquals(3, this.creationWithValueList.lastIndexOf(0));
	}
	
	@Test
	public void testRemoveFirst() {
		assertEquals(true, this.creationWithValueList.contains(Integer.MAX_VALUE));
		assertEquals(1, this.creationWithValueList.size());
		ListNode<Integer> removed = this.creationWithValueList.removeFirst();
		assertEquals(true, this.creationWithValueList.isEmpty());
		assertEquals(Integer.MAX_VALUE, removed.getVal());
	}
	
	@Test
	public void testRemoveLast() {
		assertEquals(true, this.creationWithValueList.contains(Integer.MAX_VALUE));
		assertEquals(1, this.creationWithValueList.size());
		ListNode<Integer> removed = this.creationWithValueList.removeLast();
		assertEquals(true, this.creationWithValueList.isEmpty());
		assertEquals(Integer.MAX_VALUE, removed.getVal());
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
}
