import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] chess = new char[n][m];
		for (int i = 0; i < n; i++) {
			chess[i] = br.readLine().toCharArray();
		}
		
		int ans = 64;
		
		for (int i = 0; i <= n - 8; i++) {
			for (int j = 0; j <= m - 8; j++) {
				int countB = 0;
				int countW = 0;
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						int r = i + k;
						int c = j + l;
						// (k+l)의 홀짝 여부로 올바른 색을 결정
						// 합이 짝수이면 시작 색과 같아야 함
						if ((k + l) % 2 == 0) {
							if (chess[r][c] != 'W')
								countW++; // W로 시작하는 패턴과 다를 경우
							if (chess[r][c] != 'B')
								countB++; // B로 시작하는 패턴과 다를 경우
						}
						// 합이 홀수이면 시작 색과 달라야 함
						else {
							if (chess[r][c] != 'B')
								countW++; // W로 시작하는 패턴과 다를 경우
							if (chess[r][c] != 'W')
								countB++; // B로 시작하는 패턴과 다를 경우
						}
					}

				}
				ans = Math.min(ans, Math.min(countW, countB));
			}
			
		}
		System.out.println(ans);
	}
}
