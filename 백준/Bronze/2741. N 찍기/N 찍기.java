import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/* N을 받고 1부터 N까지 찍기
		 */
		int N=sc.nextInt();
		for(int i = 1; i<=N;i++) {
			System.out.println(i);
		}
	}
}
