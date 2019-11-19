package extras;

public class Linked_List {
	public static void main(String[] args) {
		
		LinkedList l = new LinkedList(new Node(0));
		l.addLast(1);
		l.addLast(2);
		l.addLast(3);
		l.addLast(4);
		l.add(99,2);
		for (int i = 0; i < 6; i++) {
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




class LinkedList {
	
	private Node head;

	public LinkedList(Node head) {
		super();
		this.head = head;
	}
	
	public LinkedList() {
		super();
	}
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	//--Methods--//
	
	public void addLast(int element) {
		Node current = head;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		Node node = new Node(element);
		current.setNext(node);
	}
	
	public void add(int element, int index) {
		Node current = head;
		for (int i = 0; i < index - 1; i++) {
			current = current.getNext();
		}
		
		if(current.getNext() == null) {
			current.setNext(new Node(element));
			return;
		}
		//variable temp holds the next node because it 
		//is going to be overwritten by the element to be added
		
		Node temp = current.getNext();
		current.setNext(new Node(element, temp));
	}
	
	public Node getLast() {
		Node current = head;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		return current;
	}
	
	public int get(int index) {
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current.getData();
	}
}

class Node {

	private int data;
	private Node next;
	
	public Node (int data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	public Node (int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}

