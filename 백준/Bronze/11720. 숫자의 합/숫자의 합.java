import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String a = sc.next();
		int sum = 0;
		for(int i = 0;i<a.length();i++) {
			sum += a.charAt(i)-'0';
		}
		System.out.println(sum);
		
	}
}
