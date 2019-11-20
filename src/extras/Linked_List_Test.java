package extras;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Linked_List_Test {
	
	@Test
	void get_Test() {
		LinkedList l = new LinkedList();
		l.addFirst(new Integer(0));
		Integer i = new Integer(0);
		assertEquals(l.get(0), i);
	}
	
	@Test
	void getLast_Test() {
		LinkedList l = new LinkedList();
		l.addFirst(new Integer(0));
		Integer i = new Integer(0);
		assertEquals(l.getLast(), i);
	}
	
	@Test
	void addFirst_test() {
		LinkedList l = new LinkedList();
		l.addFirst(new Integer(0));
		Integer i = new Integer(0);
		assertEquals(l.get(0), i, "addFirst method does not work");
	}

	@Test
	void addLast_test() {
		LinkedList l = new LinkedList();
		l.addFirst(new Integer(0));
		l.addLast(new Integer(1));
		l.addLast(new Integer(2));

		Integer i = new Integer(2);
		assertTrue(l.get(2).equals(i), "addlast method does not work");
	}
	
	@Test
	void add_test() {
		LinkedList l = new LinkedList();
		l.addFirst(new Integer(0));
		l.addLast(new Integer(1));
		l.addLast(new Integer(2));

		Integer i0 = new Integer(0);
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(99);
		Integer i3 = new Integer(2);		
		
		
		l.add(new Integer(99), 2);
		
		assertTrue(l.get(0).equals(i0) &&
				l.get(1).equals(i1) &&
				l.get(2).equals(i2) &&
				l.get(3).equals(i3));
	}
	 
	
	@Test
	void removeFromPosition_test() {
		LinkedList l = new LinkedList();
		l.addFirst(new Integer(0));
		l.addLast(new Integer(1));
		l.addLast(new Integer(2));
		l.addLast(new Integer(3));
		l.addLast(new Integer(4));
		l.addLast(new Integer(5));
		
		Integer i1 = new Integer(0);
		Integer i2 = new Integer(1);
		Integer i3 = new Integer(3);
		Integer i4 = new Integer(4);
		Integer i5 = new Integer(5);
		
		l.removeFromPosition(2);
		
		assertTrue(l.get(0).equals(i1) &&
				l.get(1).equals(i2) &&
				l.get(2).equals(i3) &&
				l.get(3).equals(i4) &&
				l.get(4).equals(i5));
	}
	
	
	@Test
	void removeLast_test() {
		LinkedList l = new LinkedList();
		l.addFirst(new Integer(0));
		l.addLast(new Integer(1));
		l.addLast(new Integer(2));
		l.addLast(new Integer(3));
		l.addLast(new Integer(4));
		l.addLast(new Integer(5));
		
		l.removeLast();
		
		assertNull(l.get(5));
	}
	
}
