package java_intro.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InteratorIntro {

	/* 
	 	An Iterator is an object that can be used to loop through collections,
	  like ArrayList and HashSet.
	
	  The iterator() method can be used to get an Iterator for any collection:
	*/

	public static void main(String[] args) {

		// Make a collection
		ArrayList<String> cars = new ArrayList<String>();
		cars.add("Volvo");
		cars.add("BMW");
		cars.add("Ford");
		cars.add("Mazda");

		// Get the iterator
		Iterator<String> it = cars.iterator();

		// Print the first item
		System.out.println(it.next());

		//To loop through a collection, use the hasNext() and next() methods of the Iterator:
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

	public List<Integer> removeInRange(List<Integer> numbers, int lower, int upper) {

		Iterator<Integer> it = numbers.iterator();

		while (it.hasNext()) {
			Integer i = it.next();

			if (i > lower && i < upper) {
				it.remove();
			}
		}
		return numbers;
	}

	/*
	 * 
	 * 
	 * 
	 *
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
}
