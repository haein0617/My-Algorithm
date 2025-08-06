import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 10;
		for (int t = 1; t <= tc; t++) {
			br.readLine();
			int n = 100;
			int[][] arr = new int[n][n];
			int last = 0;
			boolean a = true;

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < n; i++) { // 일단 출발점은 찾았음.
				if (arr[n - 1][i] == 2) {
					last = i;
				}
			}

			int r = n - 1;
			int c = last;
			while (a) { // 출발지를 찾을 때까지 반복.
				//
					if (c>0 && arr[r][c - 1] == 1) {// 왼쪽이 1이면 왼쪽으로 ㄱㄱ
						c--;
						while (c>0 &&arr[r][c-1] == 1) {
							c--;
						}
						r--;
					} else if (c<n-1 && arr[r][c + 1] == 1) {// 오른쪽이 1이면 오른쪽으로 ㄱㄱ
						c++;
						while (c<n-1 && arr[r][c+1] ==1) {
							c++;
						}
						r--;
					} else { // 양쪽으로 안 가면 위로.
						r--;
					}

					if (r == 0) {
						a = false;
					}
				}
			System.out.printf("#%d %d%n", t, c);
		}// testcase end
	}
}
