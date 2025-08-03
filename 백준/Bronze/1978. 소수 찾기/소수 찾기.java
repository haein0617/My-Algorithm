import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 일단 n입력 받음.
		// 소수 = 1과 자기 자신으로만 나눠지는 수.
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int cnt = 0; // 소수가 아닌거 개수 세기
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt();
			if (t == 1) {
				cnt++;
			}
			for (int j = 2; j < t; j++) { // 소수가 아닌거 세기?
				if (t % j == 0) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(n - cnt); // 받은 거 중에 소수 아닌거 빼고 출력.
	}
}
