package extras;

import extras.DLList.Node;

public class Circular_Linked_List { 
	public static void main(String[] args) {
		
	}
}

class CircularLinkedList extends SinglyLinkedList{
	
	private Node tail;
	
	public CircularLinkedList(){
		super();
	}
	
	@Override
	public void setHead(Node head) {
	
		if(this.getHead().getNext() == null) {
			this.tail = head;
		}
		
	}
	
	
	
}
