package testng;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestngDemo {

	@BeforeClass
	public void beforeClass() {
		System.out.println("Testng_Demo2");
	}

	@Test
	public void test1() {

		System.out.println("Running a test 1");
	}

	@Test
	public void test3() {

		System.out.println("Running a test 3");
	}

	@Test
	public void test2() {

		System.out.println("Running a test 2");
	}


}
