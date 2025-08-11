import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] fibo = new int[41][2]; // 0부터 40까지/ 0과 1의 개수.

	public static void main(String[] args) throws Exception {

		fibo[0][0] = 1; // 0호출하면 0은 1번
		fibo[0][1] = 0; // 0호출하면 1은 0번

		fibo[1][0] = 0; // 1호출하면 0은 0번
		fibo[1][1] = 1; // 1호출하면 1은 1번

		for (int i = 2; i <= 40; i++) {
			fibo[i][0] = fibo[i - 1][0] + fibo[i - 2][0];
			fibo[i][1] = fibo[i - 1][1] + fibo[i - 2][1];
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int a = Integer.parseInt(br.readLine());

			sb.append(fibo[a][0]).append(" ").append(fibo[a][1]).append("\n");
		}
		System.out.println(sb.toString());

	}// 메인 끝

}
