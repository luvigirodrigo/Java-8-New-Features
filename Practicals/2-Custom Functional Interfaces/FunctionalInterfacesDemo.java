// Specifies the interface as a functional interface and verify it in compie time
@FunctionalInterface
interface MyFunctionalInterface<T,U,R> {
	static double getSquareRoot(int number) {
		return Math.sqrt(number);
	}
	
	default void display() {
		System.out.println("MyFunctionalInterface display() default method");
	}
	
	// Single abstract method
	public abstract R generateResult(T t,U u);
}

// Creating another functional interface in order to represent multiple inheritance behaviour
@FunctionalInterface
interface MyAnotherFunctionalInterface<T> {
	default void display() {
		System.out.println("MyAnotherFunctionalInterface display() method");
	}
	
	public abstract T getCalculatedValue(T t);
}

// Traditional interface implementation
class MyClass implements MyFunctionalInterface<Integer,Boolean,String>, MyAnotherFunctionalInterface<Integer>{
	@Override
	public String generateResult(Integer number,Boolean isValid) {
		return "The numbber is "+number+" and validity is "+isValid;
	}
	
	@Override
	public Integer getCalculatedValue(Integer number) {
		return number*number;
	}
	
	// Handling multiple inheritance
	@Override
	public void display() {
		//Defining which interface display() method should be executed (Multiple inheritance with respect to interfaces)
		MyFunctionalInterface.super.display();
	}
}

class FunctionalInterfacesDemo {
	public static void main(String[] args) {
		// Java 1.8 Lambda expression related functional interface implementation
		MyAnotherFunctionalInterface<String> funcInterf = s->"Your text value is : "+s.toUpperCase();
		System.out.println(funcInterf.getCalculatedValue("I love java"));
		
		// Calling a static method inside a functional interface or just a normal interface
		double sqrt = MyFunctionalInterface.getSquareRoot(25);
		System.out.println("Sqare root is : "+ sqrt);
	}
}