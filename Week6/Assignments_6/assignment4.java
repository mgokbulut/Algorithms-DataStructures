package Assignments_6;

import java.util.HashSet;
import java.util.Iterator;

public class assignment4 {
	public static void main(String[] args) {
		MySet ms1 = new MySet();
		ms1.add("a");
		ms1.add("b");
		ms1.add("c");
		ms1.add("d");
		MySet ms2 = new MySet();
		ms2.add("a");
		ms2.add("d");
		ms2.add("t");
		ms2.add("t");

		System.out.println(ms1.toString());
	}
}

class MySet extends HashSet<String> {
	private static final long serialVersionUID = 1L;

	public MySet() {
		super();
	}

	/**
	 * @return the union of the elements of this and that
	 */
	public MySet union(MySet that) {
		MySet result = new MySet();
		Iterator<String> this_ = this.iterator();
		if (that != null) {
			Iterator<String> that_ = that.iterator();
			while (that_.hasNext()) {
				result.add(that_.next());
			}
		}

		while (this_.hasNext()) {
			result.add(this_.next());
		}

		return result;
	}

	/**
	 * @return the intersection of the elements of this and that
	 */
	public MySet intersection(MySet that) {
		MySet result = new MySet();
		if (that == null) {
			return result;
		}
		Iterator<String> this_ = this.iterator();
		Iterator<String> that_ = that.iterator();
		while (this_.hasNext()) {
			String current = this_.next();
			if (that.contains(current)) {
				result.add(current);
			}
		}
		while (that_.hasNext()) {
			String current = that_.next();
			if (this.contains(current)) {
				result.add(current);
			}
		}

		return result;
	}

	/**
	 * @return the difference of the elements of this and that
	 */
	public MySet difference(MySet that) {
		MySet result = new MySet();

		Iterator<String> this_ = this.iterator();
		while (this_.hasNext()) {
			String current = this_.next();

			if (that == null || !that.contains(current)) {
				result.add(current);
			}
		}

		return result;
	}

	/**
	 * @return the exclusive or (XOR) of the elements of this and that
	 */
	public MySet exclusiveOr(MySet that) {
		MySet result = new MySet();

		Iterator<String> this_ = this.iterator();
		if (that == null) {
			while (this_.hasNext()) {
				result.add(this_.next());
			}
			return result;
		}
		Iterator<String> that_ = that.iterator();

		while (this_.hasNext()) {
			String current = this_.next();
			if (!that.contains(current)) {
				result.add(current);
			}
		}

		while (that_.hasNext()) {
			String current = that_.next();
			if (!this.contains(current)) {
				result.add(current);
			}
		}

		return result;
	}

	/**
	 * @return a String representation of a MySet object
	 */
	public String toString() {
		String result = "<MySet{";

		Iterator<String> this_ = this.iterator();

		while (this_.hasNext()) {
			result += this_.next() + ",";
		}
		result = result.substring(0, result.length() - 1);
		result += "}>";
		return result;
	}
}
