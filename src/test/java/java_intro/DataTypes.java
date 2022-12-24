package java_intro;

public class DataTypes {

	public static void main(String[] args) {

		/*
		 * Byte
		 *  
		 * Min:    -128
		 * Max:    128
		 * Default: 0  
		 */

		byte byteNum = 127;
		System.out.println("Byte = " + byteNum);

		/*
		 * Short
		 *  
		 * Min:    -32,768
		 * Max:    -32,768
		 * Default: 0  
		 */

		short shortNum = 32000;
		System.out.println("Short = " + shortNum);

		/*
		 * Integer
		 * 
		 * Min:    -2,147,483,648
		 * Max:    -2,147,483,648
		 * Default: 0  
		 */

		int intNum = 33000;
		System.out.println("Integer = " + intNum);

		/*
		 * Long
		 * 
		 * Min:    -2^63
		 * Max:    -2^63 - 1
		 * Default: 0  
		 */
		long longNum = 100000L;
		System.out.println("Long = " + longNum);

		/*
		 * Float
		 * 
		 * Default: 0  
		 */

		float floatNum = 32.3F;
		System.out.println("Float = " + floatNum);

		/*
		 * Double
		 * 
		 * Default: 0  
		 */

		double doubleNum = 32.3;
		double doubleMax = Double.MAX_VALUE;
		System.out.println("Double = " + doubleNum);

		/*
		 * Boolean 
		 * 
		 * value = false and true
		 * default = false;
		 */

		boolean booleanVar = true;
		System.out.println("Boolean = " + booleanVar);

		/*
		 * Char 
		 * 
		 * Min: 0
		 * Max: 65,535
		 */

		char charValue = 'A';
		char charValue2 = 65;
		System.out.println("CHar value 1 = " + charValue);
		System.out.println("Char value2 " + charValue2);

	}

}
