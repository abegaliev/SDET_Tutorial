package java_intro.collections;

public class Comparable_Comparator {

	/*
	 * 		Comparable														
	1) Comparable provides single sorting sequence. In other words, we can sort
	  the collection on the basis of single element such as id or name or price etc.
	  on a base of natural order (so you have not full control of the comparison).	
	  
	2) Comparable affects the original class i.e. actual class is modified.	
	
	3) Comparable provides compareTo() method to sort elements.	
	
	4) Comparable is found in java.lang package.	
	
	5) We can sort the list elements of Comparable type by Collections.sort(List) method.	
	
	
			Comparator
	1) Comparator provides multiple sorting sequence. In other words, we can sort 
	  he collection on the basis of multiple elements such as id, name and price etc.
	  (for each sort-criteria you have to provide a separate comparator).
	  A Comparator is its own definition of how to compare two objects, and can be used
	  to compare objects in a way that might not align with the natural ordering,
	  so you have full control  what have to be compared.
	  
	2) Comparator doesn't affect the original class i.e. actual class is not modified.
	
	3) Comparator provides compare() method to sort elements.
	
	4) Comparator is found in java.util package.
	
	5) We can sort the list elements of Comparator type by Collections.sort(List,Comparator) method.
	
	Comparable can only ever be implemented on the original class ( ,affects original Class ) and so 
	there can only ever be one implementation for it.  
	Comparator is not required to be implemented on the original class (Comparator doesn't affect the 
	original class i.e. actual class is not modified.), so there can be many implementations.
	
	 */
}
