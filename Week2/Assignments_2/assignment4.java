package Assignments_2;

public class assignment4 {

	public static void main(String[] args) {
		DLList l = new DLList();
		l.addLast(new Integer(3));
		l.addLast(new Integer(2));
		l.addLast(new Integer(1));
		l.addLast(new Integer(4));

		l.addAtPosition(2, 5);
		l.addAtPosition(15, 50);

		l.removeFromPosition(0);
		// l.addAtPosition(2, new Integer(33));
		// l.removeFromPosition(2);
		// l.removeFromPosition(99);
		// l.removeFirst();
		// l.removeLast();
		// l.removeLast();
		System.out.println(l.size());

		DLList a = l.reverse();
		for (int i = 0; i < l.size(); i++) {
			System.out.print(l.get(i) + " ");
		}

		System.out.println();
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i) + " ");
		}
	}
}

class DLList {

	class Node {
		// Each node object has these three fields
		private Object element;
		private Node previous;
		private Node next;

		// Constructor: Creates a Node object with element = e, previous = p and next =
		// n
		Node(Object e, Node p, Node n) {
			element = e;
			previous = p;
			next = n;
		}

		// This function gets Object e as input and sets e as the element of the Node
		public void setElement(Object e) {
			element = e;
		}

		// This function returns the element variable of the Node
		public Object getElement() {
			return element;
		}

		// This function gets Node n as input and sets the next variable of the current
		// Node object as n.
		public void setNext(Node n) {
			next = n;
		}

		// This function returns the next Node
		public Node getNext() {
			return next;
		}

		// This function gets Node p as input and sets the previous variable of the
		// current Node object as p.
		public void setPrevious(Node p) {
			previous = p;
		}

		// This function returns the previous Node
		public Node getPrevious() {
			return previous;
		}
	}

	// Each object in DLList has one field head, which points to the starting Node
	// of DLList.
	private Node head;
	// Each object in DLList has one field tail, which points to the final Node of
	// DLList.
	private Node tail;

	// REMOVE THİS !!!!!!!!!!!!!!!!!!!!!

	public Object get(int index) {
		Node current = head;
		for (int i = 0; i < index; i++) {
			if (current.getNext() == null && i < index) {
				return null;
			}
			current = current.getNext();

		}
		return current.getElement();
	}

	/**
	 * Constructor: initialises the head and tail fields as null
	 */
	public DLList() {
		head = null;
		tail = null;
	}

	/**
	 * @return The element in the head Node of the DLL
	 */
	public Object getHead() {
		return head.getElement();
	}

	/**
	 * @return The element in the tail Node of the DLL
	 */
	public Object getTail() {
		return tail.getElement();
	}

	/**
	 * Adds element e in a new Node to the head of the list.
	 *
	 * @param e The element to add.
	 */
	public void addFirst(Object e) {
		if (head == null) {
			this.head = new Node(e, null, null);
			this.tail = this.head;
			return;
		}
		Node n = new Node(e, null, head);
		head.setPrevious(n);
		head = n;

	}

	/**
	 * Remove the first Node in the list and return its element.
	 *
	 * @return The element of the head Node. If the list is empty, this method
	 *         returns null.
	 */
	public Object removeFirst() {
		if (this.head == null) {
			return null;
		}

		Object n = head.getElement();
		this.head = this.head.getNext();
		if (head == null) {
			tail = null;
		}
		return n;
	}

	/**
	 * Adds element e in a new Node to the tail of the list.
	 *
	 * @param e The element to add.
	 */
	public void addLast(Object e) {
		if (head == null) {
			addFirst(e);
			return;
		}
		Node n = new Node(e, tail, null);
		tail.setNext(n);
		tail = n;
	}

	/**
	 * Remove the last Node in the list and return its element.
	 *
	 * @return The element of the tail Node. If the list is empty, this method
	 *         returns null.
	 */
	public Object removeLast() {
		if (head == null) {
			return null;
		}
		if (tail == head) {
			return removeFirst();
		}
		Object o = tail.getElement();
		Node prev = tail.getPrevious();
		tail = prev;
		tail.setNext(null);

		if (head == null) {
			tail = null;
		}
		return o;
	}

	/**
	 * @return the number of Nodes in the list
	 */
	public int size() {
		if (head == null) {
			return 0;
		}
		Node current = head;
		int size = 1;
		while (current != tail) {
			current = current.getNext();
			size++;
		}
		return size;
	}

	/**
	 * Adds element e in a new Node which is inserted at position pos. The list is
	 * zero indexed, so the first element in the list corresponds to position 0.
	 * This also means that `addAtPosition(0, e)` has the same effect as
	 * `addFirst(e)`. If there is no Node in position pos, this method adds it to
	 * the last position.
	 *
	 * @param pos The position to insert the element at.
	 * @param e   The element to add.
	 */
	public void addAtPosition(int pos, Object e) {
		if (head == null) {
			addFirst(e);
		}
		Node prev = head;
		Node current = head;
		for (int i = 0; i < pos; i++) {
			prev = current;
			current = current.getNext();
			if (current == null && i + 1 < pos) {

				addLast(e);

				return;
			}
		}
		Node n = new Node(e, prev, current);
		prev.setNext(n);
		current.setPrevious(n);

	}

	/**
	 * Remove Node at position pos and return its element. The list is zero indexed,
	 * so the first element in the list corresponds to position 0. This also means
	 * that `removeFromPosition(0)` has the same effect as `removeFirst()`.
	 *
	 * @param pos The position to remove the Node from.
	 * @return The element of the Node in position pos. If there is no Node in
	 *         position pos, this method returns null.
	 */
	public Object removeFromPosition(int pos) {
		Node prev = head;
		Node current = head;
		if (pos == 0) {
			return removeFirst();
		}
		for (int i = 0; i < pos; i++) {
			prev = current;
			current = current.getNext();
			if (current == null && i + 1 < pos) {
				return null;
			}
		}
		prev.setNext(current.getNext());
		current.getNext().setPrevious(prev);
		return current.getElement();
	}

	/**
	 * @return A new DLL that contains the elements of the current one in reversed
	 *         order.
	 */

	public DLList reverse() {

		Node currentTail = tail;
		DLList result = new DLList();

		int s = this.size();

		for (int i = 0; i < s; i++) {
			result.addLast(currentTail.getElement());
			currentTail = currentTail.getPrevious();
		}

		return result;
	}

	/*
	 * public DLList reverse() {
	 * 
	 * Node currentHead = head; Node currentTail = tail; Object temp; int s =
	 * this.size()/2;
	 * 
	 * for (int i = 0; i < s; i++) {
	 * 
	 * temp = currentTail.getElement();
	 * currentTail.setElement(currentHead.getElement());
	 * currentHead.setElement(temp); currentHead = currentHead.getNext();
	 * currentTail = currentTail.getPrevious(); }
	 * 
	 * DLList result = new DLList(); Node current = head; for (int i = 0; i <
	 * this.size(); i++) { result.addLast(current.getElement()); current =
	 * current.getNext(); }
	 * 
	 * 
	 * currentHead = head; currentTail = tail; for (int i = 0; i < s; i++) {
	 * 
	 * temp = currentTail.getElement();
	 * currentTail.setElement(currentHead.getElement());
	 * currentHead.setElement(temp); currentHead = currentHead.getNext();
	 * currentTail = currentTail.getPrevious(); } return result; }
	 */

}