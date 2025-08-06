import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 10;
		for (int k = 1; k <= tc; k++) {
			br.readLine();
			int n = 100;
			int[][] arr = new int[n][n];

			int rdsum = 0; // 우하향대각선
			int rusum = 0; // 우상향대각선
			int max = Integer.MIN_VALUE;

			for (int i = 0; i < n; i++) { // 하나씩 입력 받음
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < n; i++) { // 우하향 대각선 다 더함
				rdsum += arr[i][i];
			}
			if (rdsum > max) {
				max = rdsum;
			}

			for (int i = 0; i < n; i++) { // 우상향 대각선 다 더함
				rusum += arr[i][n - 1 - i];
			}
			if (rusum > max) {
				max = rusum;
			}

			for (int i = 0; i < n; i++) { // 가로줄 다 더하기
				int rowsum = 0;
				for (int j = 0; j < n; j++) {
					rowsum += arr[i][j];
				}
				if (rowsum > max) {
					max = rowsum;
				}
			}

			for (int i = 0; i < n; i++) { // 세로줄 다 더하기
				int colsum = 0;
				for (int j = 0; j < n; j++) {
					colsum += arr[j][i];
				}
				if (colsum > max) {
					max = colsum;
				}
			}
			System.out.printf("#%d %d%n",k,max);
		}
	}
}
