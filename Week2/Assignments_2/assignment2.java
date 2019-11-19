package Assignments_2;

import java.util.ArrayList;

public class assignment2 {
	public static void main(String[] args) {
		test();
	}
	
  /**
   * Removes all elements from the ArrayList, using the removeLastOccurrence method.
   *
   * @param list
   *     to remove the elements from.
   */
	public static void removeAll(ArrayList<Integer> list) {
		for (int i = list.size() - 1; 0 <= i ; i--) {		
			removeLastOccurrence(list.get(i), list);
		}
	}

  /**
   * Takes an ArrayList and removes last occurrence of x,
   * shifting the rest of the elements left.
   * I.e. [5, 1, 5, 9, 8], with x = 5
   * would result in: [5, 1, 9, 8].
   * Note that this method does not return a new list.
   * Instead, the list that is passed as a parameter is changed.
   *
   * @param list
   *     to remove an element from.
   * @param x
   *     element value to look for
   */
	
	public static void removeLastOccurrence(int x, ArrayList<Integer> list) {		
		
		boolean found = false;
		for (int i = list.size() - 1; 0 <= i ; i--) {		
			if(!found && list.get(i) == x) {
				found = true;
				list.remove(i);
			} 
		}
	} 

	
	
	/*
	public static void removeLastOccurrence(int x, ArrayList<Integer> list) {
		ArrayList<Integer> copy = new ArrayList<Integer>(list.size());
		int current;
		boolean found = false;
		for (int i = list.size() - 1; 0 < i ; i--) {
			
			current = list.get(i);
			if(found) {
				
			} else {
				if(current != x) {
					copy.add(list.get(i));
				} else {
					found = true;
				}
			}
		}
		return copy;
	} 
	*/
	
	
	public static void test() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		
		removeLastOccurrence(0, list);
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		
		removeAll(list);
		System.out.println("\n" + list.size());
		
	}
}
