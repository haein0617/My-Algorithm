import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt(); long b = sc.nextInt();
		if (a>b) {
			System.out.println(a-b);
		}
		else if (a<=b)	{
			System.out.println((a-b)*-1);
		}
		
	}
}
