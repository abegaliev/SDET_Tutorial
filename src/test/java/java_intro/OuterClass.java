package java_intro;

// Maind
public class OuterClass {

	// Inner class can be public -> protected -> default -> private, also
	// static and final just like methods
	protected static final class InnerClass {

	}

	class InnerPublic1 {

	}

	public class InnerPublic2 {

	}

	public void testing() {
		// To access the inner class, create an object of the outer class,
		// and then create an object of the inner class:

		OuterClass outter = new OuterClass();
		InnerPublic1 inner = outter.new InnerPublic1();

		OuterClass myOuter = new OuterClass();
		OuterClass.InnerPublic2 myInner = myOuter.new InnerPublic2();

	}

}

/*
 	You can have only 1 public class within the package level
 	
  public class SecondPublic{
		
  }
   
 */

// You can have multiple non public classes within the package level
// they can be only default, final or abstract

class First {

}

final class Second {

}

abstract class Third {

}

interface Forth {

}