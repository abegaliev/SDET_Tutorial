package java_intro;

public class Exercises {

	public static void main(String[] args) {
		System.out.println(hasOne(21433));

	}

	public static String frontBack(String str) {
		if (str.length() <= 1)
			return str;
		char firstChar = str.charAt(0);
		char lastChar = str.charAt(str.length() - 1);
		String middle = str.substring(1, str.length() - 1);

		return lastChar + middle + firstChar;
	}

	int[] numbers = new int[3];

	public boolean hasTeen(int a, int b, int c) {
		int numbers[] = new int[] { a, b, c };

		for (int i = 0; i < 3; i++) {
			if (numbers[i] >= 13 && numbers[i] <= 19) {
				return true;
			}

		}
		return false;
	}

	public String delDel(String str) {
		if (str.length() < 4)
			return str;

		String compareStr = str.substring(1, 4);
		return compareStr.equals("del") ? str.replaceAll("del", "") : str;
	}

	public String startOz(String str) {
		if (str.length() < 2) {
			if (str.equals("o")) {
				return "o";
			}
		}
		char char1 = str.charAt(0);
		char char2 = str.charAt(1);
		if (char1 == 'o') {
			if (char2 == 'z') {
				return "" + char1 + char2;
			}
		} else if (char2 == 'z') {
			return "" + char2;
		}
		return "";

	}

	public String endUp(String str) {
		int strLength = str.length();

		if (strLength < 3) {
			return str.toUpperCase();
		}
		return str.substring(0, strLength - 3) + str.substring(strLength - 3, strLength - 1).toUpperCase();
	}

	/*
	 * Given a positive int n, return true if it contains a 1 digit.
	 * Note: use % to get the rightmost digit, and / to discard the rightmost digit.
	 * 
	 * hasOne(10) → true
	 * hasOne(22) → false
	 * hasOne(220) → false
	 * 
	 */
	public static boolean hasOne(int n) {

		while (n > 0) {
			if (n % 10 == 1)
				return true;

			n = n / 10;

		}
		return false;
	}

}
