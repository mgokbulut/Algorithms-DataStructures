package extras;

public class Singly_Linked_List {
	public static void main(String[] args) {
		
		SinglyLinkedList l = new SinglyLinkedList();
		l.addFirst(new Integer(0));
		l.addLast(new Integer(1));
		l.addLast(new Integer(2));
		l.addLast(new Integer(3));
		l.addLast(new Integer(4));
		//l.removeLast();
		//l.add(99,2);
		//l.removeFromPosition(4);
		System.out.println(l.removeFromPosition(5));
		System.out.println(l.get(5));
		for (int i = 0; i < 10; i++) {
			System.out.print(l.get(i) + " ");
		}
	}
	
	
	/**
	 * Notes about linked list
	 * Head is the first element in the Linked list
	 * You can get the next element by using getNext method
	 * That means that you can traverse the list from head to tail
	 * However we can not traverse the list from tail to head
	 */
}




class SinglyLinkedList {
	
	private Node head;
	private int size;
	
	public SinglyLinkedList(Node head) {
		super();
		this.head = head;
		size++;
	}
	
	public SinglyLinkedList() {
		super();
	}
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
		size++;
	}
	
	//--Methods--//
	
	
	public void addFirst(Object e) {
		head = new Node(e, head);
		size++;
	}
		  
	public void addLast(Object element) {
		if(head == null) {
			addFirst(element);
			return;
		}
		Node current = head;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		Node node = new Node(element);
		current.setNext(node);
		size++;
	}
	
	public void add(Object element, int index) {
		Node current = head;
		for (int i = 0; i < index - 1; i++) {
			current = current.getNext();
		}
		
		if(current.getNext() == null) {
			current.setNext(new Node(element));
			size++;
			return;
		}
		//variable temp holds the next node because it 
		//is going to be overwritten by the element to be added
		
		Node temp = current.getNext();
		current.setNext(new Node(element, temp));
		size++;
	}
	
	public Object getLast() {
		Node current = head;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		return current.getData();
	}
	
	public Object get(int index) {
		Node current = head;
		for (int i = 0; i < index; i++) {
			if(current.getNext() == null && i < index) {
				return null;
			}
			current = current.getNext();
			
			
		}
		return current.getData();
	}
	
	public Object removeFirst() {
		if(head == null) {
			return null;
		}
		Node result = head;
		head = head.getNext();
		size--;
		return result.getData();
		  
	}
	
	public Object removeLast() {
		if(head == null) {
			return null;
		} 
		if(head.getNext() == null) {
			return removeFirst();
		}
		
		Node current = head;
		Node previous = null;
		while(current.getNext() != null) {
			previous = current;
			current = current.getNext();
		}
		previous.setNext(null);
		size--;
		return current.getData();
	}

	public Object removeFromPosition(int index) {
		if(index == 0) {
			return removeFirst();
		}
		if(index < 0) {
			return null;
		}
		
		Node current = head;
		Node previous = head;
		for (int i = 0; i < index - 1; i++) {			
			previous = previous.getNext();
			if(previous.getNext() == null && i < index) {
				return null;
			}
		}
		current = previous.getNext();
		previous.setNext(current.getNext());
		size--;
		return current.getData();
	}
	
	public int size() {
		return this.size;
	}
	
	class Node {

		private Object data;
		private Node next;
		
		public Node (Object data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		public Node (Object data) {
			this.data = data;
		}
		
		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
	}

}


