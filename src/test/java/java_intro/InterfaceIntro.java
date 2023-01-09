package java_intro;

public interface InterfaceIntro {

    // Variable must be initialized
    // ALL VARIABLES are only public static final; 

    // when not specified the access modifier is public by default
    static int num = 5;
    public String name = "My name";

    // Abstract Method 
    public void abstractMethod();

    // Static method with implementation;
    public static void staticMethod() {
	System.out.println("Static method inside an interface");
    }

    // Default instance method inside an interface since java 8. 
    public default void defaultMethod() {
	System.out.println("Default method inside an interface");
    }

    // When you do not specify the access modifier it is public by default
    void byDefaultPublicMethod();

}
