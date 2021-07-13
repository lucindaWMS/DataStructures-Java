package Arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Iterators.ArrayListIterator;

class ArrayListTest {

	private ArrayList<Integer> createWithoutCapacity;
	private ArrayList<Integer> createWithCapacity;
	
	@BeforeEach
	public void setUp() {
		this.createWithoutCapacity = new ArrayList<>();
		this.createWithCapacity = new ArrayList<>(3);
	}
	
	@Test
	public void testConstructors() {
		assertEquals(0, this.createWithoutCapacity.size());
		assertEquals(1, this.createWithoutCapacity.getCapacity());
		assertEquals(0, this.createWithCapacity.size());
		assertEquals(3, this.createWithCapacity.getCapacity());
	}
	
	@Test
	public void testAddGivenIndex() {
		this.createWithCapacity.add(0, 0);
		this.createWithCapacity.add(1, 0);
		assertEquals(2, this.createWithCapacity.size());
		assertEquals(3, this.createWithCapacity.getCapacity());
		assertEquals(1, this.createWithCapacity.getFirst());
		assertEquals(0, this.createWithCapacity.getLast());
		this.createWithCapacity.add(2);
		assertEquals(3, this.createWithCapacity.size());
		assertEquals(6, this.createWithCapacity.getCapacity());
		assertEquals(2, this.createWithCapacity.getLast());
	}
	
	@Test
	public void testEmptyTheList() {
		assertEquals(true, this.createWithCapacity.isEmpty());
		this.createWithCapacity.add(1);
		assertEquals(1, this.createWithCapacity.size());
		assertEquals(false, this.createWithCapacity.isEmpty());
	}
	
	@Test
	public void testGetGivenIndex() {
		this.createWithCapacity.add(0);
		this.createWithCapacity.add(1);
		this.createWithCapacity.add(2);
		assertEquals(3, this.createWithCapacity.size());
		assertEquals(1, this.createWithCapacity.get(1));
	}
	
	@Test
	public void testIndexOf() {
		assertEquals(true, this.createWithCapacity.isEmpty());
		int index = this.createWithCapacity.indexOf(0);
		assertEquals(-1, index);
		this.createWithCapacity.add(0);
		this.createWithCapacity.add(1);
		assertEquals(true, this.createWithCapacity.contains(0));
		index = this.createWithCapacity.indexOf(0);
		assertEquals(0, index);
		assertEquals(-1, this.createWithCapacity.indexOf(2));
		this.createWithCapacity.add(0);
		assertEquals(2, this.createWithCapacity.lastIndexOf(0));
	}
	
	@Test
	public void testRemoveFirst() {
		this.createWithCapacity.add(0);
		assertEquals(0, this.createWithCapacity.getFirst());
		int removed = this.createWithCapacity.removeFirst();
		assertEquals(0, removed);
		assertEquals(true, this.createWithCapacity.isEmpty());
		assertEquals(0, this.createWithCapacity.size());
	}
	
	@Test
	public void testRemoveLast() {
		this.createWithCapacity.add(0);
		this.createWithCapacity.add(1);
		assertEquals(1, this.createWithCapacity.getLast());
		assertEquals(2, this.createWithCapacity.size());
		int removed = this.createWithCapacity.removeLast();
		assertEquals(1, removed);
		assertEquals(0, this.createWithCapacity.getLast());
		assertEquals(1, this.createWithCapacity.size());
	}
	
	@Test
	public void testRemoveGivenIndex() {
		this.createWithCapacity.add(0);
		this.createWithCapacity.add(1);
		this.createWithCapacity.add(2);
		assertEquals(3, this.createWithCapacity.size());
		assertEquals(1, this.createWithCapacity.get(1));
		int removed = this.createWithCapacity.removeGivenIndex(1);
		assertEquals(1, removed);
		assertEquals(2, this.createWithCapacity.size());
		assertEquals(2, this.createWithCapacity.get(1));
	}
	
	@Test
	public void testRemoveGivenValue() {
		this.createWithCapacity.add(0);
		this.createWithCapacity.add(1);
		this.createWithCapacity.add(1);
		assertEquals(3, this.createWithCapacity.size());
		assertEquals(1, this.createWithCapacity.get(1));
		int removed = this.createWithCapacity.remove(1);
		assertEquals(1, removed);
		assertEquals(2, this.createWithCapacity.size());
		assertEquals(1, this.createWithCapacity.get(1));
	}
	
	@Test
	public void testRemoveLastOccurrence() {
		this.createWithCapacity.add(0);
		this.createWithCapacity.add(1);
		this.createWithCapacity.add(0);
		assertEquals(3, this.createWithCapacity.size());
		assertEquals(true, this.createWithCapacity.contains(0));
		assertEquals(1, this.createWithCapacity.get(1));
		int removed = this.createWithCapacity.removeFirstOccurrence(0);
		assertEquals(0, removed);
		assertEquals(2, this.createWithCapacity.size());
		assertEquals(true, this.createWithCapacity.contains(0));
		assertEquals(0, this.createWithCapacity.get(1));
		removed = this.createWithCapacity.removeLastOccurrence(0);
		assertEquals(0, removed);
		assertEquals(1, this.createWithCapacity.size());
		assertEquals(false, this.createWithCapacity.contains(0));
		assertEquals(1, this.createWithCapacity.getLast());
	}
	
	@Test
	public void testSetGivenIndex() {
		this.createWithCapacity.add(0);
		this.createWithCapacity.add(1);
		this.createWithCapacity.add(2);
		assertEquals(0, this.createWithCapacity.getFirst());
		assertEquals(3, this.createWithCapacity.size());
		this.createWithCapacity.setFirst(-1);
		assertEquals(-1, this.createWithCapacity.getFirst());
		assertEquals(3, this.createWithCapacity.size());
		assertEquals(2, this.createWithCapacity.getLast());
		this.createWithCapacity.setLast(-3);
		assertEquals(-3, this.createWithCapacity.getLast());
		assertEquals(3, this.createWithCapacity.size());
		assertEquals(1, this.createWithCapacity.get(1));
		this.createWithCapacity.set(-2, 1);
		assertEquals(-2, this.createWithCapacity.get(1));
		assertEquals(3, this.createWithCapacity.size());
	}
	
	@Test
	public void testToString() {
		this.createWithCapacity.add(0);
		this.createWithCapacity.add(1);
		this.createWithCapacity.add(2);
		String myList = this.createWithCapacity.toString();
		assertEquals("0, 1, 2", myList);
	}
	
	@Test
	public void testIterator() {
		this.createWithCapacity.add(0);
		this.createWithCapacity.add(1);
		ArrayListIterator<Integer> myIterator = (ArrayListIterator<Integer>) this.createWithCapacity.iterator();
		assertEquals(1, this.createWithCapacity.getLast());
		int last = 0;
		while (myIterator.hasNext()) {
			last = myIterator.next();
		}
		assertEquals(last, 1);
	}
}
