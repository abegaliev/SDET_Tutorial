package java_intro;

public class StringIntro {

	public static void main(String[] args) {

		//String Literal - String pool 
		String str1 = "Hello String ";
		// str1 is a reference to object
		// "Hello String" - is an object

		//String Object = Heap
		String str2 = new String("Hello String object");

		str1 = "HEllo2 ";
		//str1 reference is pointing now to a new object Hello2;

		String strNew = str1 + str2;

		String str3 = "Hello";
		String str4 = " Spaces    ";

		/*
		 * String'length()   length of the string
		 * String'charAt()   returns a char value at the given index number  
		 * String'concat()   combines specified string at the end of this string  
		 * String'contains()   returns true if chars are found in the string  
		 * String'startsWith()   checks if this string starts with given prefix  
		 * String'endsWith()   checks if this string ends with given suffix  
		 * String'equals()   compares the contents of two given strings  
		 * String'indexOf()   returns index of given character value or substring  
		 * String'isEmpty()   checks if this string is empty  
		 * String'replace()   returns a string replacing all the old char to new char  
		 * String'substring()   returns a part of the string  
		 * String'toCharArray()   converts this string into character array  
		 * String'toLowerCase()   returns the string in lowerCase letter  
		 * String'toUpperCase()   returns the string in upperCase letter  
		 * String'trim()   eliminates leading and trailing spaces 
		 */

		System.out.println(str3.length());
		System.out.println(str3.charAt(4));
		System.out.println(str3 = str3.concat(" added")); //adds a new String
		System.out.println(str3.contains("ed"));
		System.out.println(str3.endsWith("added"));
		System.out.println(str3.startsWith("Hello"));

		System.out.println(str3.equals(str2));
		System.out.println(str3.indexOf("e")); //if not found returns -1
		System.out.println(str3.isEmpty());
		str4.trim(); // Eliminates leading and trailing spaces 

		String str5 = "String'length()!\"!length!of!the!string! St";

		str5 = str5.replace('!', ' ').replace('"', ' ');

		String str6 = "Hello Java";

		System.out.println(str6.subSequence(4, 8));

		System.out.println(str6.substring(6, 9));

		System.out.println(str6.lastIndexOf('a'));

		char[] strArr = str6.toCharArray();

		for (int i = 0; i < strArr.length; i++) {

			System.out.println("Index of = " + strArr[i] + " is " + i);

		}

	}
}
