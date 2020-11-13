package Assignments_4;

import java.util.EmptyStackException;

public class assignment1 {

}

class ArrayStack {
	private Object[] elements;
	private int size;
	private int capacity;

	/**
	 * Creates an empty ArrayStack with capacity 1.
	 */
	public ArrayStack() {
		this.size = 0;
		this.capacity = 1;
		this.elements = new Object[this.capacity];
	}

	/**
	 * @return The size of this ArrayStack.
	 */
	public int size() {
		return size;
	}

	/**
	 * @return `true` iff this ArrayStack is empty, `false` otherwise.
	 */
	public boolean isEmpty() {
		if (this.size <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * @return `true` iff the size is equal to the capacity, `false` otherwise.
	 */
	public boolean isFull() {
		if (this.size == this.capacity) {
			return true;
		}
		return false;
	}

	/**
	 * @return the top element of the stack without removing it
	 */
	public Object peek() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return this.elements[this.size - 1];
	}

	/**
	 * Adds `o` to the stack. If capacity of stack was too small, capacity is
	 * doubled and `o` is added.
	 *
	 * @param o the element to add to the stack.
	 */
	public void push(Object o) {
		if (this.isFull()) {
			this.resize(this.capacity * 2);
		}

		this.elements[this.size] = o;
		this.size++;
	}

	/**
	 * Removes the top element from the stack. If removing top would make the stack
	 * use less than 25% of its capacity, then the capacity is halved.
	 *
	 * @return the element which was at the top of the stack.
	 * @throws EmptyStackException iff the stack is empty
	 */

	private void resize(int newSize) {
		Object[] newArray = new Object[newSize];
		for (int i = 0; i < this.size; i++) {
			newArray[i] = this.elements[i];
		}
		this.elements = newArray;
		this.capacity = newSize;
	}

	public Object pop() throws EmptyStackException {

		if (isEmpty()) {
			throw new EmptyStackException();
		}
		Object o = elements[size - 1];
		this.size--;
		if (this.size < (this.capacity / 4) && this.capacity >= 2) {
			// if the size used is less than %25
			this.resize(this.capacity / 2);
		}

		return o;

	}

	/**
	 * @return a String representation of the ArrayStack Example output for
	 *         ArrayStack with 2 elements and capacity 5: <ArrayStack[1,2]>(Size=2,
	 *         Cap=5)
	 */
	public String toString() {
		String result = "<ArrayStack[";
		boolean b = false;
		for (int i = 0; i < size; i++) {
			result += elements[i] + ",";
			b = true;
		}
		if (b == true) {
			result = result.substring(0, result.length() - 1);
		}
		result += "]>(Size=" + size() + ", Cap=" + this.capacity + ")";
		return result;
	}

	// For testing, do not remove or change.
	public Object[] getElements() {
		return elements;
	}
}
