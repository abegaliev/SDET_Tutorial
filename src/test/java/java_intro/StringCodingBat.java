package java_intro;

public class StringCodingBat {

	public static void main(String[] args) {

		//System.out.println(xyzThere("abc.xyzxyz"));
		//	    System.out.println(getSandwich("mmbreadcreambread"));
		//		System.out.println(wordEnds("XY", "XY"));
		//		System.out.println(starOut("sm*eilly"));
		//		System.out.println(withoutString("HelLo heLLo HEllO", "llo"));
		//		System.out.println(stringMatch("afdg", "sfe"));
		System.out.println(matchUp(new String[] { "aa", "bb", "cc" }, new String[] { "", "", "ccc" }));
	}

	/*
	 * Given 2 arrays that are the same length containing strings, compare the 1st string
	 * in one array to the 1st string in the other array, the 2nd to the 2nd and so on.
	 * Count the number of times that the 2 strings are non-empty and start with the same char.
	 * The strings may be any length, including 0.
	 * 
	 * matchUp(["aa", "bb", "cc"], ["aaa", "xx", "bb"]) → 1
	 * matchUp(["aa", "bb", "cc"], ["aaa", "b", "bb"]) → 2
	 * matchUp(["aa", "bb", "cc"], ["", "", "ccc"]) → 1
	 */

	public static int matchUp(String[] a, String[] b) {
		int count = 0;

		for (int i = 0; i < a.length; i++) {
			if (!a[i].isEmpty() && !b[i].isEmpty()) {
				if (a[i].charAt(0) == b[i].charAt(0))
					count++;
			}
		}
		return count;
	}

	public static int stringMatch(String a, String b) {
		int count = 0;
		int shortest = Math.min(a.length(), b.length());

		for (int i = 0; i < shortest - 1; i++) {

			if (a.substring(i, i + 2).equals(b.substring(i, i + 2))) {
				count++;
			}
		}
		return count;
	}

	/*
	 * Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9
	 * ... so "kittens" yields "kien".
	 */

	public String altPairs(String str) {
		String result = "";

		// Run i by 4 to hit 0, 4, 8, ...
		for (int i = 0; i < str.length(); i += 4) {

			// Append the chars between i and i+2
			int end = i + 2;
			if (end > str.length()) {
				end = str.length();
			}

			result = result + str.substring(i, end);
		}

		return result;
	}

	public String lastTwo(String str) {
		if (str.length() < 2)
			return "";

		return str.substring(0, str.length() - 2)
				+ new StringBuilder(str.substring(str.length() - 2)).reverse().toString();
	}

	public static String deFront(String str) {
		int length = str.length();

		switch (length) {
		case 0:
			return "str";
		case 1:
			if (str.equals("a")) {
				return str;
			} else {
				return "";
			}
		default:
			String result = "";
			if (str.charAt(0) == 'a')
				result = "a";

			if (str.charAt(1) == 'b')
				result = result + "b";

			return result + str.substring(2);
		}
	}

	/*
	 * Return true, if the given string contains an appearance of "xyz"
	 * where the xyz is not directly preceeded by a period (.)
	 * So "xxyz" counts but "x.xyz" does not.
	 * 
	 * xyzThere("abcxyz") → true
	 * xyzThere("abc.xyz") → false
	 * xyzThere("xyz.abc") → true
	 * 
	 */

	public static boolean xyzThere(String str) {

		for (int i = 0; i < str.length() - 2; i++) {
			if (str.substring(i, i + 3).equals("xyz")) {
				if (i == 0) {
					return true;
				} else if (str.charAt(i - 1) != '.') {
					return true;
				}
			}
		}
		return false;

	}

	/*
	 * A sandwich is two pieces of bread with something in between.
	 * Return the string that is between the first and last appearance of "bread" in the given string,
	 * or return the empty string "" if there are not two pieces of bread.
	 * 
	 * getSandwich("breadjambread") → "jam"
	 * getSandwich("xxbreadjambreadyy") → "jam"
	 * getSandwich("xxbreadyy") → ""
	 * 
	 */

	public static String getSandwich(String str) {
		int firstIndex = (str.indexOf("bread"));
		int lastIndex = (str.lastIndexOf("bread"));

		if (firstIndex != lastIndex)
			return str.substring(firstIndex + 5, lastIndex);
		return "";
	}

	/*
	 * Given a string, compute a new string by moving the first char to come after the next two chars,
	 * so "abc" yields "bca". Repeat this process for each subsequent group of 3 chars,
	 * so "abcdef" yields "bcaefd". Ignore any group of fewer than 3 chars at the end.
	 * 
	 */

	public String oneTwo(String str) {
		String result = "";
		for (int i = 0; i < str.length() - 2; i += 3) {
			String subStr = str.substring(i, i + 3);
			result += subStr.substring(1) + subStr.charAt(0);
		}
		return result;
	}

	/*
	 * Given a string and a non-empty word string,
	 * return a string made of each char just before and just after every appearance
	 * of the word in the string. Ignore cases where there is no char before or after the word,
	 * and a char may be included twice if it is between two words.
	 * 
	 * wordEnds("abcXY123XYijk", "XY") → "c13i"
	 * wordEnds("XY123XY", "XY") → "13"
	 * wordEnds("XY1XY", "XY") → "11"
	 * 
	 */

	public static String wordEnds(String str, String word) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.substring(i).startsWith(word)) {

				if (i == 0 && i == str.length() - word.length()) {

				} else if (i == 0) {
					result = result + str.charAt(i + word.length());
					i = i + word.length() - 1;

				} else if (i == str.length() - word.length()) {
					result = result + str.charAt(i - 1);
					i = i + word.length() - 1;
				} else {
					result = result + str.charAt(i - 1) + str.charAt(i + word.length());
				}
			}
		}
		return result;
	}

	/*
	 * Return a version of the given string, where for every star (*)
	 * in the string the star and the chars immediately to its left and right are gone.
	 * So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
	 * 
	 * starOut("ab*cd") → "ad"
	 * starOut("ab**cd") → "ad"
	 * starOut("sm*eilly") → "silly"
	 * 
	 */

	public static String starOut(String str) {
		String result = "";

		for (int i = 0; i < str.length(); i++) {

			if (i == 0 && str.charAt(i) != '*')
				result += str.charAt(i);

			if (i > 0 && str.charAt(i) != '*' && str.charAt(i - 1) != '*')
				result += str.charAt(i);

			if (i > 0 && str.charAt(i) == '*' && str.charAt(i - 1) != '*')
				result = result.substring(0, result.length() - 1);
		}
		return result;
	}

	public static String withoutString(String base, String remove) {
		String result = "";
		result = base.replaceAll(remove, "");
		result = result.replaceAll(remove.toLowerCase(), "");
		result = result.replaceAll(remove.toUpperCase(), "");

		return result;
	}

	public boolean gHappy(String str) {
		boolean isHappy = true;
		int length = str.length();

		for (int i = 0; i < length - 1; i++) {

			if (str.substring(i, i + 2).equals(""))
				i = 3;

		}
		return isHappy;
	}

	/*
	 * Given a string, return the longest substring that appears at both
	 * the beginning and end of the string without overlapping.
	 * For example, sameEnds("abXab") is "ab".
	 * 
	 * sameEnds("abXYab") → "ab"
	 * sameEnds("xx") → "x"
	 * sameEnds("xxx") → "x"
	 */

	public static String sameEnds(String string) {
		String result = "";
		int length = string.length();
		int middle = length / 2;

		for (int i = 0; i < middle; i++) {

			int oddMiddle = middle;
			if ((length % 2) != 0)
				oddMiddle = middle + 1;

			if (string.substring(0, middle - i).equals(string.substring(oddMiddle + i, length))) {
				return string.substring(0, middle - i);
			}
		}
		return result;
	}

	/*
	 * Given a string, look for a mirror image (backwards) string at both the beginning
	 * and end of the given string. In other words, zero or more characters at the very
	 * beginning of the given string, and at the very end of the string in reverse order 
	 * (possibly overlapping). For example, the string "abXYZba" has the mirror end "ab".
	 * 
	 * mirrorEnds("abXYZba") → "ab"
	 * mirrorEnds("abca") → "a"
	 * mirrorEnds("aba") → "aba"
	 */
	public static String mirrorEnds(String string) {

		int length = string.length();
		int middle = length / 2;

		for (int i = 0; i < middle; i++) {

			int oddMiddle = middle;

			if ((length % 2) != 0)
				oddMiddle = middle + 1;

			System.out.println(
					"Reverse String: == " + new StringBuilder(string.substring(0, oddMiddle - i)).reverse().toString());

			if (new StringBuilder(string.substring(0, oddMiddle - i)).toString()
							.equals(string.substring(middle + i, length))) {
				return string.substring(0, oddMiddle - i);
			}
		}
		return "";
	}

	/*
	 * Given a string, return the length of the largest "block" in the string.
	 * A block is a run of adjacent chars that are the same.
	 * 
	 * maxBlock("hoopla") → 2
	 * maxBlock("abbCCCddBBBxx") → 3
	 * maxBlock("") → 0
	 * maxbLock("XXBBBbbxxXXXX");
	 */

	public static int maxBlock(String str) {
		int count = 1;
		int countMax = 0;

		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				count++;
			} else {
				count = 1;
			}
			if (count > countMax)
				countMax = count;
		}

		return countMax;
	}

	/*
	 * Given a string, return the sum of the numbers appearing in the string,
	 * ignoring all other characters. A number is a series of 1 or more digit chars in a row.
	 * (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'.
	 * Integer.parseInt(string) converts a string to an int.)
	 * 
	 * sumNumbers("abc123xyz") → 123
	 * sumNumbers("aa11b33") → 44
	 * sumNumbers("7 11") → 18
	 */

	public static int sumNumbers(String str) {
		int sum = 0;
		String temp = "";

		for (int i = 0; i < str.length(); i++) {

			if (Character.isDigit(str.charAt(i))) {
				temp = temp + str.charAt(i);

			} else {
				if (!temp.isEmpty())
					sum = sum + Integer.parseInt(temp);
				temp = "";
			}
			if (i == str.length() - 1)
				if (!temp.isEmpty())
					sum = sum + Integer.parseInt(temp);
		}
		return sum;
	}

	/*
	 * Given a string, return a string where every appearance of the lowercase word "is"
	 * has been replaced with "is not". The word "is" should not be immediately preceeded or
	 * followed by a letter -- so for example the "is" in "this" does not count.
	 * (Note: Character.isLetter(char) tests if a char is a letter.)
	 * 
	 * notReplace("is test") → "is not test"
	 * notReplace("is-is") → "is not-is not"
	 * notReplace("This is right") → "This is not right"
	 */

	public String notReplace(String str) {
		String result = "";
		String[] splitted = str.split(" ");

		for (int i = 0; i < splitted.length; i++) {

			if (splitted[i].equals("is"))
				splitted[i] = "is not";

			result = result + splitted[i] + " ";
		}
		return result.trim();
	}

}