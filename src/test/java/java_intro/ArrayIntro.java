package java_intro;

public class ArrayIntro {

	public static void main(String[] args) {

		//		for (int num : front11(new int[0], new int[] { 5, 4, 3, 2 })) {
		//			System.out.println(num);
		//
		//			System.out.println(8 % 20);
		//		}

		//		for (int num : canBalance(new int[] { 1, 99, 10 })) {
		//			System.out.println(num);
		//		}
		//		System.out.println(linearIn(new int[] { -1, 0, 3, 3, 3, 10, 12 }, new int[] { -1, 0, 3, 12 }));

		//		for (int num : squareUp(3)) {
		//			System.out.println(num);
		//		}

		reverse(new int[]{1, 2, 3, 4, 5});

	}

	/*
	 * Given an array of ints length 3, return a new array with the elements in
	 * reverse order, so {1, 2, 3} becomes {3, 2, 1}.
	 */

	public static int[] reverseArray(int[] nums) {
		int[] newNums = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			newNums[(nums.length - 1) - i] = nums[i];
		}

		return newNums;
	}

	/*
	 * Given 2 int arrays, a and b, of any length, return a new array with the first
	 * element of each array. If either array is length 0, ignore that array.
	 * 
	 * 
	 * front11([1, 2, 3], [7, 9, 8]) → [1, 7]
	 * front11([1], [2]) → [1, 2]
	 * front11([1, 7], []) → [1]
	 * 
	 */

	public static int[] front11(int[] a, int[] b) {

		if (a.length > 0 && b.length > 0) {
			return new int[]{a[0], b[0]};

		} else if (a.length > 0) {
			return new int[]{a[0]};

		} else if (b.length > 0) {

			return new int[]{b[0]};

		} else {
			return b;
		}
	}

	/*
	 * We want to make a row of bricks that is goal inches long.
	 * We have a number of small bricks (1 inch each)
	 * and big bricks (5 inches each).
	 * Return true if it is possible to make the goal by choosing from the given bricks.
	 * 
	 * makeBricks(3, 1, 8) → true
	 * makeBricks(3, 4, 9) → false
	 * makeBricks(3, 2, 10) → true
	 * 
	 */

	public static boolean makeBricks(int small, int big, int goal) {
		//return (small >= goal % 5 && big * 5 >= goal - small);

		while (big > 0 && goal >= 5) {
			big--;
			goal -= 5;
		}
		if (goal <= small)
			return true;
		return false;
	}

	/*
	 * For this problem, we'll round an int value up to the next multiple of 10
	 * if its rightmost digit is 5 or more, so 15 rounds up to 20.
	 * Alternately, round down to the previous multiple of 10 if its rightmost digit is less than 5,
	 * so 12 rounds down to 10. Given 3 ints, a b c, return the sum of their rounded values.
	 * To avoid code repetition, write a separate helper "public int round10(int num).
	 * 
	 * roundSum(16, 17, 18) → 60
	 * roundSum(12, 13, 14) → 30
	 * roundSum(6, 4, 4) → 10
	 */

	public static int roundSum(int a, int b, int c) {
		return round10(a) + round10(b)
			+ round10(c);
	}

	public static int round10(int num) {
		if (num % 10 >= 5) {
			return ((num / 10) * 10) + 10;
		}

		return (num / 10) * 10;
	}

	/*
	 * Given three ints, a b c, one of them is small, one is medium and one is large.
	 * Return true if the three values are evenly spaced,
	 * so the difference between small and medium is the same as the difference between medium and large.
	 * 
	 * evenlySpaced(2, 4, 6) → true
	 * evenlySpaced(4, 6, 2) → true
	 * evenlySpaced(4, 6, 3) → false
	 * 
	 */

	public boolean evenlySpaced(int a, int b, int c) {
		int small = Math.min(a, Math.min(b, c));
		int large = Math.max(a, Math.max(b, c));
		int medium = (a + b + c) - (small + large);

		return medium - small == large - medium;
	}

	/**
	 * Given an array of ints, return true if the array contains
	 * a 2 next to a 2 or a 4 next to a 4, but not both.
	 * 
	 * either24([1, 2, 2]) → true
	 * either24([4, 4, 1]) → true
	 * either24([4, 4, 1, 2, 2]) → false
	 * 
	 * @param int
	 * @return boolean
	 */

	public static boolean either24(int[] nums) {
		boolean check2 = false;
		boolean check4 = false;

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 2 && nums[i + 1] == 2)
				check2 = true;

			if (nums[i] == 4 && nums[i + 1] == 4)
				check4 = true;
		}
		if (check2 && !check4)
			return true;
		else if (!check2 && check4)
			return true;

		return false;
	}

	/*
	 * Given an array of ints, return true if there is a 1 in the array
	 * with a 2 somewhere later in the array.
	 * 
	 * has12([1, 3, 2]) → true
	 * has12([3, 1, 2]) → true
	 * has12([3, 1, 4, 5, 2]) → true
	 */

	public boolean has12(int[] nums) {
		int length = nums.length;
		boolean check = false;

		for (int i = 0; i < length; i++) {
			if (nums[i] == 1)
				check = true;

			if (check)
				if (nums[i] == 2)
					return true;
		}
		return false;
	}

	/*
	 * Return true if the array contains, somewhere,
	 * three increasing adjacent numbers like .... 4, 5, 6, ... or 23, 24, 25.
	 * 
	 * tripleUp([1, 4, 5, 6, 2]) → true
	 * tripleUp([1, 2, 3]) → true
	 * tripleUp([1, 2, 4]) → false
	 */

	public static boolean tripleUp(int[] nums) {
		int length = nums.length;

		for (int i = 0; i < length - 2; i++) {
			if ((nums[i + 1] - nums[i]) == 1
				&& (nums[i + 2] - nums[i + 1]) == 1
				&& (nums[i + 2] - nums[i + 1]) == 1
				&& (nums[i + 2] - nums[i + 1]) == 1)
				return true;
		}
		return false;
	}

	/*
	 * Return a version of the given array where all the 10's have been removed.
	 * The remaining elements should shift left towards the start of the array as needed,
	 * and the empty spaces a the end of the array should be 0.
	 * 
	 * withoutTen([1, 10, 10, 2]) → [1, 2, 0, 0]
	 * withoutTen([10, 2, 10]) → [2, 0, 0]
	 * withoutTen([1, 99, 10]) → [1, 99, 0]
	 * 
	 */
	public static int[] withoutTen(int[] nums) {
		int length = nums.length;
		int index = 0;

		for (int i = 0; i < length; i++) {
			if (nums[i] != 10) {
				int temp = nums[index];
				nums[index] = nums[i];
				nums[i] = temp;
				index++;
			}
		}

		for (int i = 0; i < length; i++) {
			if (nums[i] == 10)
				nums[i] = 0;
		}

		return nums;
	}

	/*
	 * Given a non-empty array, return true if there is a place to split
	 * the array so that the sum of the numbers on one side is equal to the 
	 * sum of the numbers on the other side.
	 * 
	 * canBalance([1, 1, 1, 2, 1]) → true
	 * canBalance([2, 1, 1, 2, 1]) → false
	 * canBalance([10, 10]) → true
	 */

	public static boolean canBalance(int[] nums) {
		int length = nums.length;
		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i < length; i++) {
			sum1 += nums[i];
		}
		for (int i = length - 1; i > 0; i--) {
			sum2 += nums[i];
			sum1 -= nums[i];
			if (sum1 == sum2)
				return true;
		}
		return false;
	}

	/*
	 * Given two arrays of ints sorted in increasing order, outer and inner,
	 * return true if all of the numbers in inner appear in outer.
	 * The best solution makes only a single "linear" pass of both arrays,
	 * taking advantage of the fact that both arrays are already in sorted order.
	 * 
	 * linearIn([1, 2, 4, 6], [2, 4]) → true
	 * linearIn([1, 2, 4, 6], [2, 3, 4]) → false
	 * linearIn([1, 2, 4, 4, 6], [2, 4]) → true
	 */

	public static boolean linearIn(int[] outer, int[] inner) {
		int length = inner.length;
		int count = 0;

		for (int i = 0; i < inner.length; i++) {
			for (int n = 0; n < outer.length; n++) {
				if (inner[i] == outer[n]) {
					count++;
					break;
				}
			}
		}

		return count == length;
	}

	/*
	 * Given n>=0, create an array length n*n with the following pattern,
	 * shown here for n=3 : {0, 0, 1,    0, 2, 1,    3, 2, 1} (spaces added to show the 3 groups).
	 * 
	 * squareUp(3) → [0, 0, 1, 0, 2, 1, 3, 2, 1]
	 * squareUp(2) → [0, 1, 2, 1]
	 * squareUp(4) → [0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3, 2, 1]
	 * 
	 */

	public static int[] squareUp(int n) {
		int[] nums = new int[n * n];
		int startIndex = nums.length;
		int repNum = n;

		for (int i = 0; i < n; i++) {
			startIndex = startIndex - n;
			int index = startIndex + i;

			for (int m = repNum; m > 0; m--) {
				nums[index] = m;
				index++;
			}
			repNum -= 1;
		}
		return nums;
	}

	private static int[] reverse(int[] nums) {
		int len = nums.length;

		for (int i = 0; i < len; i++) {
			int num = nums[i];

			nums[i] = nums[(len - 1) - i];
			nums[(len - 1) - i] = num;

			if (((len - 1) - i) == i)
				break;
		}

		return nums;
	}

	public static void printArray(Object[] arr) {
		for (Object o : arr) {
			System.out.println(o);
		}
	}

}
