package java_intro.collections;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaIntro {

	public static void main(String[] args) {

		System.out.println(lower(Arrays.asList(new String[] { "A", "BB", "CCC" })));

	}
	/*
	 	===>  Lambda is a shortcut to define an implementation of a functional interface.
	 	Instead of creating a class that implements that functional interface and adding
	 	an implementation that you want of that single abstract method, and create an object
	 	of this class, you simply create a lambda expression that contains the implementation
	 	of that functional interface method that you want.
	 	
	 	Functional interface - is an interface with single abstract method.
	 							might contain other static and default methods, but has to
	 							have only 1 single abstract method.
	 	
	 */

	/*
	 *  // Assignment context
	 Predicate<String> p = String::isEmpty;
	
	 	// Method invocation context
	 stream.filter(e -> e.getSize() > 10)...
	
	 	// Cast context
	 stream.map((ToIntFunction) e -> e.getSize())...
	 *
	 */

	/*
	 * Given a list of integers, return a list where each integer is multiplied by 2.
	 * 
	 * doubling([1, 2, 3]) → [2, 4, 6]
	 * doubling([6, 8, 6, 8, -1]) → [12, 16, 12, 16, -2]
	 * doubling([]) → []
	 */

	public static List<Integer> doubling(List<Integer> nums) {
		nums.stream().map(n -> n * 2).collect(Collectors.toList());
		return nums;

		//		nums.replaceAll(n -> n *2);
		//		return nums;
	}

	/*
	 * Given a list of strings, return a list where each string has "*" added at its end.
	 * 
	 * addStar(["a", "bb", "ccc"]) → ["a*", "bb*", "ccc*"]
	 * addStar(["hello", "there"]) → ["hello*", "there*"]
	 * addStar(["*"]) → ["**"]
	 */

	public List<String> addStar(List<String> strings) {
		//		strings.replaceAll(n -> n + "*");
		//		return strings;

		strings = strings.stream().map(n -> n + "*").collect(Collectors.toList());
		return strings;
	}

	/*
	 * Given a list of strings, return a list where each string is replaced
	 * by 3 copies of the string concatenated together.
	 * 
	 * copies3(["a", "bb", "ccc"]) → ["aaa", "bbbbbb", "ccccccccc"]
	 * copies3(["24", "a", ""]) → ["242424", "aaa", ""]
	 * copies3(["hello", "there"]) → ["hellohellohello", "theretherethere"]
	 */

	public static List<String> copies3(List<String> strings) {
		//		return strings.stream().map(n -> n + n + n).toList();

		//		return strings.stream().map(n -> n + n + n).collect(Collectors.toList());

		strings.replaceAll(n -> n + n + n);
		return strings;
	}

	/*
	 * Given a list of strings, return a list where each string is converted
	 * to lower case (Note: String toLowerCase() method).
	 * 
	 * lower(["Hello", "Hi"]) → ["hello", "hi"]
	 * lower(["AAA", "BBB", "ccc"]) → ["aaa", "bbb", "ccc"]
	 * lower(["KitteN", "ChocolaTE"]) → ["kitten", "chocolate"]
	 */

	public static List<String> lower(List<String> strings) {
		//		strings.replaceAll(n -> n.toLowerCase());
		//		return strings;

		return strings.stream().map(n -> n.toLowerCase()).collect(Collectors.toList());

	}

	/*
	 * Given a list of strings, return a list where each string has all its "x" removed.
	 * 
	 * noX(["ax", "bb", "cx"]) → ["a", "bb", "c"]
	 * noX(["xxax", "xbxbx", "xxcx"]) → ["a", "bb", "c"]
	 * noX(["x"]) → [""]
	 */

	public List<String> noX(List<String> strings) {
		//	strings.replaceAll(n -> n.replaceAll("x", ""));

		strings = strings.stream().map(n -> n.replaceAll("x", "")).collect(Collectors.toList());

		return strings;
	}

	/*
	 * Given a list of integers, return a list of the integers, omitting any that are less than 0.
	 * 
	 * noNeg([1, -2]) → [1]
	 * noNeg([-3, -3, 3, 3]) → [3, 3]
	 * noNeg([-1, -1, -1]) → []
	 */

	public List<Integer> noNeg(List<Integer> nums) {

		// nums.removeIf(n-> n<0);

		//		Predicate<Integer> p = x -> x < 0;
		//		nums.removeIf(p);

		Predicate<Integer> p = n -> n >= 0;
		nums.stream().filter(p).collect(Collectors.toList());

		return nums;
	}

	/*
	 * Given a list of integers, return a list of those numbers,
	 * omitting any that are between 13 and 19 inclusive.
	 * 
	 * noTeen([12, 13, 19, 20]) → [12, 20]
	 * noTeen([1, 14, 1]) → [1, 1]
	 * noTeen([15]) → []
	 */

	public List<Integer> noTeen(List<Integer> nums) {

		//		Predicate<Integer> p = x -> (x >= 13 && x <= 19);
		//		nums.removeIf(p);

		Predicate<Integer> p = x -> !(x >= 13 && x <= 19);
		nums.stream().filter(p).collect(Collectors.toList());

		return nums;
	}

	/*
	 * Given a list of strings, return a list of the strings, omitting any string that contains a "z". 
	 *
	 * noZ(["aaa", "bbb", "aza"]) → ["aaa", "bbb"]
	 * noZ(["hziz", "hzello", "hi"]) → ["hi"]
	 * noZ(["hello", "howz", "are", "youz"]) → ["hello", "are"]
	 */

	public List<String> noZ(List<String> strings) {
		// java.util.function.Predicate<String> p =
		//         x -> x.contains("z");
		// strings.removeIf(p);

		Predicate<String> p = x -> !x.contains("z");
		strings = strings.stream().filter(p).collect(Collectors.toList());

		return strings;
	}

	/*
	 * Given a list of strings, return a list of the strings, omitting any string length 4 or more.
	 * 
	 * noLong(["this", "not", "too", "long"]) → ["not", "too"]
	 * noLong(["a", "bbb", "cccc"]) → ["a", "bbb"]
	 * noLong(["cccc", "cccc", "cccc"]) → []
	 */

	public List<String> noLong(List<String> strings) {
		//		Predicate<String> p =  x -> x.length() >= 4;
		//		strings.removeIf(p);

		Predicate<String> p = x -> x.length() < 4;
		strings = strings.stream().filter(p).collect(Collectors.toList());

		return strings;
	}

	/*
	 * Given a list of strings, return a list where each string has "y" added at its end,
	 * omitting any resulting strings that contain "yy" as a substring anywhere.
	 * 
	 * noYY(["a", "b", "c"]) → ["ay", "by", "cy"]
	 * noYY(["a", "b", "cy"]) → ["ay", "by"]
	 * noYY(["xx", "ya", "zz"]) → ["xxy", "yay", "zzy"]
	 */

	public List<String> noYY(List<String> strings) {

		strings.replaceAll(s -> s + "Y");
		strings.removeIf(s -> s.contains("yy"));

		//		strings = strings.stream().map(x -> x + "y").collect(Collectors.toList());
		//		strings.removeIf(x -> x.contains("yy"));

		strings = strings.stream().map(x -> x + "y").filter(x -> !x.contains("yy")).collect(Collectors.toList());

		return strings;

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
	 * 
	 * 
	 * 
	 */
}
