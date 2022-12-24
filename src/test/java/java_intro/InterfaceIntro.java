package java_intro;

public interface InterfaceIntro {

	// ALL VARIABLES are only public static final; 

	// Method can be private otherwise always public

	// Variable must be initialized
	// when not specified the access modifier is public by default
	static int num = 5;
	public String name = "My name";

	// Abstract Method 
	public void abstractMethod();

	// Static method with implementation;
	public static void staticMethod() {
		System.out.println("Static method inside an interface");
	}

	// Default instance method inside an interface
	public default void defaultMethod() {

	}

	// When you do not specify the access modifier it is public by default
	void byDefaultPublicMethod();

}
