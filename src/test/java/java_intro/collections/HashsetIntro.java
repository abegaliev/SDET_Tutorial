package java_intro.collections;

import java.util.HashSet;

public class HashsetIntro {

	// A HashSet is a collection of items where every item is unique

	public static void main(String[] args) {
		HashSet<String> cars = new HashSet<String>();
		cars.add("Volvo");
		cars.add("BMW");
		cars.add("Ford");

		//even though BMW is added twice it only appears once in the set
		cars.add("BMW");
		cars.add("Mazda");

		System.out.println(cars);
	}

}
