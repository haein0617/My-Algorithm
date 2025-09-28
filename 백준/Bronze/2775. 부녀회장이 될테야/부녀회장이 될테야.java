import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine()); // tc
		for (int t = 0; t < tc; t++) {

			int k = Integer.parseInt(br.readLine()); // k층
			int n = Integer.parseInt(br.readLine()); // n호

			int[][] apt = new int[k + 1][n + 1];
			int[][] dp = new int[k + 1][n + 1];
			for (int j = 1; j < apt[0].length; j++) {
				apt[0][j] = j;
				dp[0][j] += dp[0][j - 1] + j;
			} // 1층 채우기 끝

			for (int i = 1; i < apt.length; i++) {
				dp[i][1] = 1;
				for (int j = 1; j < apt[0].length; j++) {
					apt[i][j] = dp[i - 1][j];
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
			sb.append(apt[k][n]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
