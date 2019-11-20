package Tutorial_2;

public class Assignment2 {
	public static void main(String[] args) {
		
	}
}

//  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  \\
//  !! BETTER IMPLEMENTATION IS GIVEN IN LINKED_LIST CLASS IN EXTRAS PACKAGE IN SRC FOLDER. !!  \\  
//  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  \\

class SLList {
	
	  class Node {

	    // Each node object has these two fields
	    private Object element;

	    private Node next;

	    // Constructor: Creates a Node object with element = e and next = n
	    Node(Object e, Node n) {
	      element = e;
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

	    // This function gets Node n as input and sets the next variable of the current Node object as n.
	    public void setNext(Node n) {
	      next = n;
	    }

	    // This function returns the next Node
	    public Node getNext() {
	      return next;
	    }
	  }

	  // Each object in SLList has one field head, which points to the starting Node of SLList.
	  private Node head;

	  /**
	   * Constructor: initialises the head field as null
	   */
	  public SLList() {
	    head = null;
	  }

	  /**
	   * @return The element in the head Node of the SLL
	   */
	  public Object getHead() {
	    return head.getElement();
	  }

	  /**
	   * Adds element e in a new Node to the head of the list.
	   *
	   * @param e The element to add.
	   */
	  public void addFirst(Object e) {
		  head = new Node(e, head);
		  /*
		  Node n = new Node(e.toString(), null);
		  this.head.setNext(n);
		  this.head = n;
		  */
	  }

	  /**
	   * Remove the first Node in the list and return its element.
	   *
	   * @return The element of the head Node. If the list is empty, this method returns null.
	   */
	  public Object removeFirst() {
		  if(head == null) {
			  return null;
		  }
		  Node result = head;
		  head = head.getNext();
		  return result.getElement();
		  
	  }

	  /**
	   * Adds element e in a new Node to the tail of the list.
	   *
	   * @param e
	   *     The element to add.
	   */
	  public void addLast(Object e) {
		  if(head == null) {
			  addFirst(e);
			  return;
		  } else {
			  Node n = new Node(e, null);
			  Node tail = head;
			  while(tail.getNext() != null) {
				  tail = tail.getNext();
			  }
			  tail.setNext(n);
		  }
		  
	  }

	  /**
	   * Remove the last Node in the list and return its element.
	   *
	   * @return The element of the tail Node. If the list is empty, this method returns null.
	   */
	  public Object removeLast() {
	    if(head == null) {
	    	return null;
	    }
	    if(head.getNext() == null) {
	    	return removeFirst();
	    }
	    Node tail = head.getNext();
	    Node prev = head;
	    
	    while(tail.getNext() != null) {
	    	prev = tail;
	    	tail = tail.getNext();
	    }
	    prev.setNext(null);
	    return tail.getElement();
	  }

	  /**
	   * Remove Node at position pos and return its element.
	   * The list is zero indexed, so the first element in the list corresponds to position 0.
	   * This also means that `removeFromPosition(0)` has the same effect as `removeFirst()`.
	   *
	   * @param pos The position to remove the Node from.
	   * @return The element of the Node in position pos. If there is no Node in position pos, this method returns null.
	   */
	  public Object removeFromPosition(int pos) {
		  if(pos == 0) {
				return removeFirst();
			} else if (pos < 0) {
				return null;
			}
			Node current = head;
			Node previous = head;
			for (int i = 0; i < pos - 1; i++) {
				previous = previous.getNext();
			}
			current = previous.getNext();
			
			if(current.getNext() == null) {
				previous.setNext(null);
				return current.getElement();
			}
			previous.setNext(current.getNext());
			return current.getElement();
	  }
	}


