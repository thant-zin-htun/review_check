//import java.util.Objects;
//
//class MyNumber{
//	int num1;
//	int num2;
//	
//	public MyNumber() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//	public MyNumber(int num1, int num2) {
//		super();
//		this.num1 = num1;
//		this.num2 = num2;
//	}
//	
//	@Override
//	public String toString() {
//		return "MyNumber [num1=" + num1 + ", num2=" + num2 + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(num1, num2);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		MyNumber para = (MyNumber) obj;
//		return para.num1 == this.num1 && para.num2 == this.num2;
//	}
//	
//	
//	
//}
//
//
//
//
//public class Memory {
//
//	public static void main(String[] args) {
////		System.out.println(factorial(5,1));
////		System.out.println(factorial(5));
////	}
//	
////	public static int factorial(int num, int result) { // method recursive
////		if(num == 1)
////			return result;
////		else return factorial(num-1, num*result);
////	}
//	
////	public static int factorial(int num) { // method recursive
////		if(num == 1)
////			return 1;
////		else return num * factorial(num-1);
////	}
//		
//		// primitive = RAM, non-primitive heap, stack
//		
//		
//	 
//		MyNumber obj1 = new MyNumber(1,5); // heap
//		// MyNumber obj2 = obj1; // shallow copy
//		MyNumber obj2 = new MyNumber(); // deep copy
//		obj2.num1 = obj1.num1;
//		obj2.num2 = obj1.num2;
//		System.out.println(obj1);
//		System.out.println(obj2);
////		obj2.num1 = 10;
//		System.out.println(obj1);
//		System.out.println(obj2);
//		System.out.println((obj1 == obj2) + ":" + (obj1.equals(obj2)));
//		
////		String str = new String("Hello");
////		String str2 = new String("Hello");
////		System.out.println((str == str2) + ":" + (str.equals(str2)));	// object twy same lr sit chin yin equals() nk sit
//	}
//
//	
//}

import java.util.InputMismatchException;
import java.util.Scanner;

public class ErrorHandling {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter two integer ");
		try {
		int num1=Integer.parseInt(scanner.nextLine());
		int num2=scanner.nextInt();
		int result=num1/num2;
		System.out.println(result);
		}
		catch(NumberFormatException ex) {
			System.err.println("You typed wrong format");
		}
//		catch(InputMismatchException ex) {
//			System.err.println("You have to type number");
//		}
//		catch(ArithmeticException ex) {
//			System.err.println("You have to type positive number");
//		}
		catch(Exception ex) {
			System.err.println("Sth wrong");
		}
		finally {
		scanner.close();
		System.out.println("Program exit.");
		}
	}

}

// syntax error -> compile time error (IDE)
// semantic error -> run time error -> handling (try catch)
