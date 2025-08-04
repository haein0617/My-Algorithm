import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//이항계수
		//nCk = n!/(k! * (n-k)!)
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int numerator = 1;
		int denominator = 1;
		int denominator2 = 1;
		for (int i = 1; i <= n; i++) {
			numerator*=i;
		}
		for(int i = 1;i<=k;i++) {
			denominator2*=i;
		}
		for (int i = 1; i <= n-k; i++) {
			denominator2*=i;
		}
		System.out.println(numerator/(denominator*denominator2));
	}
}
