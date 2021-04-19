import java.util.Scanner;

//2020313582 - Selin Samra

public class SimpleCalculator {

	public static void main(String[] args)throws OutOfRangeException {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] numbers = input.split("[+-]");
		
		int[] intNumbers = new int[2];
		for(int i = 0;i<2;i++) {
			intNumbers[i]= Integer.valueOf(numbers[i]);
		}
		
		int result = 0;
		try {
			result = calculate(input,intNumbers[0],intNumbers[1]);
			if(result<0 || result>1000 || intNumbers[0]<0 || intNumbers[0]>1000 || intNumbers[1]<0 || intNumbers[1]>1000)
				throw new OutOfRangeException();
		}catch (OutOfRangeException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		System.out.println(result);
	}
	public static int calculate(String input,int a,int b) {
		int result = 0;
		if (input.contains("+")) {
			try {
				if (a==0||b==0)
					throw new AddZeroException();
			}catch (AddZeroException e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
			result = a + b;
		}
		else if (input.contains("-")) {
			try {
				if (a==0||b==0)
					throw new SubstractZeroException();
			}catch (SubstractZeroException e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
			result = a - b;
		}
		return result;
	}
}
class OutOfRangeException extends Exception{
	public OutOfRangeException() {
		super( "OutOfRangeException");
	}
}
class AddZeroException extends Exception{
	public AddZeroException() {
		super( "AddZeroException");
	}
}
class SubstractZeroException extends Exception{
	public SubstractZeroException() {
		super( "SubstractZeroException");
	}
}
