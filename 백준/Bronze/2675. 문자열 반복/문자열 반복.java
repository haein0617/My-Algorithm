import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 반복 횟수 R 테스트케이스 개수 T 문자열 S 출력 할 문자열 P
		 */
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int R = sc.nextInt();
			String S = sc.next();
			for (int j = 0; j < S.length(); j++) {
				char a = S.charAt(j);
				System.out.print(String.valueOf(a).repeat(R));
			}
			System.out.println();
		}

	}
}
