package java_intro;

public class Exercises2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "Kitten";

	}

	public static long toMilesPerHour(double kilometersPerHour) {
		return kilometersPerHour < 0 ? -1 : Math.round(kilometersPerHour / 1.61);
	}

	public boolean sleepIn(boolean weekday, boolean vacation) {
		if (!weekday || vacation) {
			return true;
		} else {
			return false;
		}
	}

	//	public static String missingChar(String str, int n) {
	//		  return str.replaceAll(((str.charAt(n))+""),"");
	//		}
	//	

	public String missingChar(String str, int n) {
		// return str.replaceAll(((str.charAt(n))+""),"");

		String front = str.substring(0, n);

		// Start this substring at n+1 to omit the char.
		// Can also be shortened to just str.substring(n+1)
		// which goes through the end of the string.
		String back = str.substring(n + 1, str.length());

		return front + back;
	}

}
