import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String a = sc.next();
		int[] b=new int[a.length()];
		int sum = 0;
		for(int i = 0;i<a.length();i++) {
			sum += a.charAt(i)-48;
		}
		System.out.println(sum);
		
	}
}
