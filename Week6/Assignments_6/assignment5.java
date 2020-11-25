package Assignments_6;

import java.util.LinkedList;

public class assignment5 {
	public static void main(String[] args) {
//		HashTable table = new HashTableImpl(4);
//		table.put("Hello World!", 42);
//		table.put("FortyTwo", 84);
//		table.put("Arthur Dent", 123);
//		System.out.println(table.containsKey("Hello World!"));
//		System.out.println(table.containsKey("Arthur Dent"));
//		System.out.println(table.containsKey("FortyTwo"));
//		System.out.println(table.containsKey("Not In There!"));
//		System.out.println(42 + " " + (int) table.get("Hello World!"));
//		System.out.println(84 + " " + (int) table.get("FortyTwo"));
//		System.out.println(123 + " " + (int) table.get("Arthur Dent"));
//		System.out.println(table.get("Not In There!"));
		System.out.println("hi");
	}
}

/**
 * Entry objects are used to represent "Key-Value" pairs. An entry can be
 * created by using new Entry(String key, Integer Value) The .equals() method of
 * Entry will compare the keys only.
 */
class Entry {
	public final String key;
	public final Integer value;

	public Entry(String s, Integer v) {
		key = s;
		value = v;
	}

	public boolean equals(String s) {
		return s == null && key == null || key.equals(s);
	}

	@Override
	public boolean equals(Object o) {
		return this == o || o != null && getClass() == o.getClass() && this.equals(((Entry) o).key);
	}

	public String getKey() {
		return key;
	}

	public int getValue() {
		return value;
	}
}

abstract class HashTable {
	protected LinkedList<Entry>[] myTable;

	/**
	 * Constructs a new HashTable.
	 *
	 * @param capacity to be used as capacity of the table.
	 * @throws IllegalArgumentException if the input capacity is invalid.
	 */
	@SuppressWarnings("unchecked")
	public HashTable(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException();
		}
		this.myTable = new LinkedList[capacity];
	}

	/**
	 * Add a key value pair to the HashTable.
	 *
	 * @param key   to identify the value.
	 * @param value that is identified by the key.
	 */
	public void put(String key, Integer value) {
		int hashedKey = this.hash(key);
		Entry obj = new Entry(key, value);
		if (myTable[hashedKey] == null) {
			myTable[hashedKey] = new LinkedList<Entry>();
			this.myTable[hashedKey].add(obj);
			return;

		}

		for (int i = 0; i < myTable[hashedKey].size(); i++) {
			Entry current = this.myTable[hashedKey].get(i);
			if ((key == null && current.getKey() == null) || current.getKey().equals(key)) {
				Entry replace = new Entry(key, value);
				this.myTable[hashedKey].set(i, replace);
				return;
			}
		}
		this.myTable[hashedKey].add(obj);
	}

	/**
	 * @param key to look for in the HashTable.
	 * @return true iff the key is in the HashTable.
	 */
	public boolean containsKey(String key) {

		int hashedKey = this.hash(key);
		if (this.myTable[hashedKey] == null) {
			return false;
		}
		for (Entry current : this.myTable[hashedKey]) {
			if ((key == null && current.getKey() == null) || current.getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Get a value from the HashTable.
	 *
	 * @param key that identifies the value.
	 * @return the value associated with the key or `null` if the key is not in the
	 *         HashTable.
	 */
	public Integer get(String key) {
		int hashedKey = this.hash(key);
		if (this.myTable[hashedKey] == null) {
			return null;
		}
		for (Entry current : this.myTable[hashedKey]) {
			if ((key == null && current.getKey() == null) || current.getKey().equals(key)) {
				Integer ret = new Integer(current.getValue());
				return ret;
			}
		}
		return null;
	}

	/**
	 * @return the capacity of the HashTable.
	 */
	public int getCapacity() {
		return myTable.length;
	}

	/**
	 * Hashes a string/key.
	 *
	 * @param item to hash.
	 * @return the hashcode of the string, modulo the capacity of the HashTable.
	 */
	public abstract int hash(String item);
}