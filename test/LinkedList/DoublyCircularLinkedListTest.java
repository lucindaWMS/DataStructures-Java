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
}
