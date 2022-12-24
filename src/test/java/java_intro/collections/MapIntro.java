package java_intro.collections;

import java.util.HashMap;
import java.util.Map;

public class MapIntro {

	public static void main(String[] args) {

		System.out.println(romanToInt("MCMXCIV"));

	}

	/*
	 * Given a roman numeral, convert it to an integer.
	 * 
	 * romanToInt("III")  	 -> [ 3 ];
	 * romanToInt("LVIII")   -> [ 58 ]
	 * romanToInt("MCMXCIV") -> [1994]; 
	 */

	public static int romanToInt(String number) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int sum = 0;
		int prev = 0, curr = 0;
		for (int i = number.length() - 1; i >= 0; i--) {

			curr = map.get(number.charAt(i));
			if (curr < prev) {
				sum -= curr;
			} else {
				sum += curr;
			}
			prev = curr;
		}
		return sum;
	}

	/*
	 * Modify and return the given map as follows: if the key "a" has a value,
	 * set the key "b" to have that value, and set the key "a" to have the value "".
	 * Basically "b" is a bully, taking the value and replacing it with the empty string.
	 * 
	 * mapBully({"a": "candy", "b": "dirt"}) → {"a": "", "b": "candy"}
	 * mapBully({"a": "candy"}) → {"a": "", "b": "candy"}
	 * mapBully({"a": "candy", "b": "carrot", "c": "meh"}) → {"a": "", "b": "candy", "c": "meh"}
	 */

	public Map<String, String> mapBully(Map<String, String> map) {

		if (map.containsKey("a") && !map.get("a").isEmpty()) {
			map.put("b", map.get("a"));
			map.replace("a", "");
		}

		return map;
	}

	/*
	 * Modify and return the given map as follows: if the key "a" has a value,
	 * set the key "b" to have that same value. In all cases remove the key "c",
	 * leaving the rest of the map unchanged.
	 * 
	 * mapShare({"a": "aaa", "b": "bbb", "c": "ccc"}) → {"a": "aaa", "b": "aaa"}
	 * mapShare({"b": "xyz", "c": "ccc"}) → {"b": "xyz"}
	 * mapShare({"a": "aaa", "c": "meh", "d": "hi"}) → {"a": "aaa", "b": "aaa", "d": "hi"}
	 */

	public Map<String, String> mapShare(Map<String, String> map) {
		if (map.containsKey("a") && !map.get("a").isEmpty()) {
			map.put("b", map.get("a"));
		}
		map.remove("c");
		return map;
	}

	/*
	 * Modify and return the given map as follows: for this problem the map may
	 * or may not contain the "a" and "b" keys. If both keys are present,
	 * append their 2 string values together and store the result under the key "ab".
	 * 
	 * mapAB({"a": "Hi", "b": "There"}) → {"a": "Hi", "ab": "HiThere", "b": "There"}
	 * mapAB({"a": "Hi"}) → {"a": "Hi"}
	 * mapAB({"b": "There"}) → {"b": "There"}
	 */

	public Map<String, String> mapAB(Map<String, String> map) {
		if (map.containsKey("a") && map.containsKey("b") && (!map.get("a").isEmpty() && !map.get("b").isEmpty())) {
			map.put("ab", map.get("a") + map.get("b"));
		}
		return map;

	}

	/*
	 * The classic word-count algorithm: given an array of strings, return a
	 * Map<String, Integer> with a key for each different string, with the value
	 * the number of times that string appears in the array.
	 * 
	 * wordCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
	 * wordCount(["c", "b", "a"]) → {"a": 1, "b": 1, "c": 1}
	 * wordCount(["c", "c", "c", "c"]) → {"c": 4}
	 * 
	 */

	public Map<String, Integer> wordCount(String[] strings) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int length = strings.length;

		for (int i = 0; i < length; i++) {
			if (map.containsKey(strings[i])) {
				map.replace(strings[i], map.get(strings[i]) + 1);
			} else {
				map.put(strings[i], 1);
			}
		}
		return map;
	}

	/*
	 * We'll say that 2 strings "match" if they are non-empty and their first chars are the same.
	 * Loop over and then return the given array of non-empty strings as follows: 
	 * f a string matches an earlier string in the array, swap the 2 strings in the array.
	 * A particular first char can only cause 1 swap, so once a char has caused a swap,
	 * its later swaps are disabled. Using a map, this can be solved making just one 
	 * pass over the array. More difficult than it looks.
	 * 
	 * firstSwap(["ab", "ac"]) → ["ac", "ab"]
	 * firstSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "aaa", "azz"]
	 * firstSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "ai", "aj", "bx", "by"]
	 */

	public String[] firstSwap(String[] strings) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < strings.length; i++) {
			String firstChar = strings[i].substring(0, 1);

			if (map.containsKey(firstChar) && map.get(firstChar) == -1) {
				continue;
			} else {
				if (map.containsKey(firstChar)) {
					int index = map.get(firstChar);
					String old = strings[index];
					strings[index] = strings[i];
					strings[i] = old;

					map.replace(firstChar, -1);
				} else {
					map.put(firstChar, i);
				}
			}

		}
		return strings;
	}

}
