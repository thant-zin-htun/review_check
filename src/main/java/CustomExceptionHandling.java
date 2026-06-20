import java.util.Scanner;

public class CustomExceptionHandling {

	public static void main(String[] args) throws AgeException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your age:");
		int num=Integer.parseInt(sc.nextLine());
		if(num < 0 || num > 120) {
			throw new AgeException("Age is invalid.");
		}
		System.out.println("Your age is " + num);

	}

}

class AgeException extends Exception{
	public AgeException(String mesg) {
		System.err.println(mesg);
	}
}
