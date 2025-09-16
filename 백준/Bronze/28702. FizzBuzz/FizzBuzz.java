import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = new String[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = br.readLine();
		}
		
		int result = 0;
		for (int i = 0; i < 3; i++) {
			if(Character.isDigit(arr[i].charAt(0))) {
				result = Integer.parseInt(arr[i]) + 3-i;
				break;
			}
		}
		
		if(result % 5 == 0 && result % 3 == 0 ) {
			System.out.println("FizzBuzz");
		}else if(result % 3 == 0) {
			System.out.println("Fizz");
		}else if(result % 5 == 0) {
			System.out.println("Buzz");
		}else {
			System.out.println(result);
		}
		
		
	}
}
