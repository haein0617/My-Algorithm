import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 1;
		for(;n>1;n--) {//n부터 하나씩 내려가면서 곱하고 sum에 저장
			sum*=n;
		}
		System.out.println(sum);
	}
}
