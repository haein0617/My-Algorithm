import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 5자리 고유 번호 받기.
		 * 각 수의 제곱들의 합을 10으로 나누고 나머지.
		 */
		int sum=0;
		for(int i = 0; i<5;i++) {
			int a = sc.nextInt();
			sum += a*a;
		}
		System.out.println(sum%10);
	}
}
