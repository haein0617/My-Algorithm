import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 10_000_001;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int m = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) { // 최대 가격보다 크게 설정
			Arrays.fill(map[i], INF);
		}
		
		for (int i = 1; i < n+1; i++) { // 본인에게 가는 비용은 0
			map[i][i] = 0;
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[from][to] = Math.min(cost, map[from][to]);
		}
		
		for (int k = 1; k < n+1; k++) { // 중간 지점
			for (int i = 1; i < n+1; i++) { // 출발 지점
				for (int j = 1; j < n+1 ; j++) { // 도착 지점
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
				
			}
			
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				if(map[i][j]==INF) map[i][j] = 0;
				sb.append(map[i][j]).append(" ");
			}sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
