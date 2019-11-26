package extras;
import java.util.NoSuchElementException;

public class queue_ implements Queue{

	private SinglyLinkedList queue;
	
	public queue_() {
		this.queue = new SinglyLinkedList();
	}
	
	@Override
	public boolean isEmpty() {
		if(queue.size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return this.queue.size();
	}

	@Override
	public void enqueue(Object e) {
		this.queue.addLast(e);
	}

	@Override
	public Object dequeue() throws NoSuchElementException {
		return this.queue.removeFirst();
	}

	@Override
	public Object front() throws NoSuchElementException {	
		return this.queue.getHead();
	}

}
