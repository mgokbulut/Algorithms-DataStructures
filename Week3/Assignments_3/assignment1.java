package Assignments_3;
import java.util.*;
import extras.queue_;

public class assignment1 {
	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		queue_ m = new queue_();
		
		q.enqueue(3);
		q.enqueue("annen");
		q.enqueue(new Integer(8));
		for (int i = 0; i < 3; i++) {
			System.out.print(q.dequeue() + " ");
		}
		
		q.enqueue(3);
		q.enqueue("annen");
		q.enqueue(new Integer(8));
		
		q.reverse();
		System.out.println();
		for (int i = 0; i < 3; i++) {
			System.out.print(q.dequeue() + " ");
		}
		
	}
}

class MyQueue extends queue_ {
  /**
   * Reverses the queue itself. NB: This method should be recursive.
   */
	public void reverse() {
		if (this.size() == 0) {
			return;
		} else {
			Object a = this.dequeue();
			reverse();
			enqueue(a);
			return;	
		}
	}
	
	/**
	 * Answer method for weblab
	 */
	/*
	public void reverse() {
		if (this.size() == 0) {
			return;
		} else {
			T a = this.dequeue();
			reverse();
			enqueue(a);
			return;	
		}
	}
	 */
}
