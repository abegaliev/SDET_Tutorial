package java_intro;

public class LoopsIntro {

    public static void main(String[] args) {

	String str = "Java world";

	char[] strArr = str.toCharArray();

	for (int i = 0; i < strArr.length; i++) {

	    System.out.println("Index of = " + strArr[i] + " is " + i);

	}

	int in = 0;
	while (in < strArr.length) {
	    System.out.println("While loop " + strArr[in]);
	    in++;

	}

	int im = 0;

	do {
	    System.out.println("do while loop  " + strArr[im] + " index " + im);
	    im++;
	} while (im < strArr.length);

	System.out.println("Table of multiplication: ");

	LOOP1: for (int i = 0; i < 10; i++) {
	    //			if(i==5)break LOOP1;

	    if (i == 1)
		continue;

	    for (int num = 0; num < 10; num++) {
		if (i == 0 || num > 7)
		    break;
		if (num == 0)
		    continue;
		//				if(num >7)break;
		System.out.println(i + " * " + num + " = " + i * num);

	    }

	    System.out.println();

	}

    }

}
