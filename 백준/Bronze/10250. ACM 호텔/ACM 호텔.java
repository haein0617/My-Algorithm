import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * w개의 방 h층 건물 엘베는 가장 왼쪽, n번째 손님 t개의 테스트 케이스
		 */
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) { // 테스크 케이스만큼 반복.
			int h = sc.nextInt(); //층
			int w = sc.nextInt(); //호 수
			int n = sc.nextInt(); // 몇 번째 손님인지
			if (n % h != 0) {
				int y = n % h; // 층 수
				int x = (n / h) + 1; // 호 수
				System.out.printf("%d%02d%n", y, x);
			}else if(n%h==0) {
				int x = (n / h); // 호 수
				System.out.printf("%d%02d%n", h, x);
			}
		}
	}
}