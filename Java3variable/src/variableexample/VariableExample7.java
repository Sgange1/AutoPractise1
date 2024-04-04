package variableexample;

public class VariableExample7 {

	public static void main(String[] args) {
		System.out.println("Program Start");
		/*
		 * int a; int b; int c; a=10; b=20; c=a+b;
		 */

		int a = 10;
		int b = 20;
		int c = a + b;
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("addition of a and b=" + c);
		a = 50;
		c = a - b;
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("substraction of a and b=" + c);

		System.out.println("Program Ends");

	}

}
