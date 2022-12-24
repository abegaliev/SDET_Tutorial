package java_intro;

public class IntegerIntro {

	public static void main(String args[]) {

		System.out.println(dividesSelf(42));

		Integer num = 55;
		int n = num.byteValue();

	}

	/*
	 * We'll say that a positive int divides itself if every digit in the number divides into
	 * the number evenly. So for example 128 divides itself since 1, 2, and 8 all divide
	 * into 128 evenly. We'll say that 0 does not divide into anything evenly,
	 * so no number with a 0 digit divides itself. Note: use % to get the rightmost digit,
	 * and / to discard the rightmost digit.
	 * 
	 * dividesSelf(128) → true
	 * dividesSelf(12) → true
	 * dividesSelf(120) → false
	 */

	public static boolean dividesSelf(int n) {
		int temp = n;

		while (temp > 0) {
			int lastDigit = temp % 10;
			if (lastDigit == 0)
				return false;

			if (n % lastDigit != 0)
				return false;
			temp = temp / 10;
		}
		return true;
	}

}
