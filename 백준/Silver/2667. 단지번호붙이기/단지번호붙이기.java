import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	private static int n,cnt;
	private static int[][] grid;
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		grid = new int[n][n];
		for (int i = 0; i < n; i++) { // 1 or 0 입력
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				grid[i][j] = str.charAt(j)-'0';
			}
		}
		
		visited = new boolean[n][n];
		int dfsCount = 0;
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					dfs(i, j);
					dfsCount++;
					result.add(cnt);
					cnt = 0;
				}
			}
		}
		
		Collections.sort(result);
		sb.append(dfsCount).append("\n");
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i)).append("\n");
		}
		System.out.println(sb.toString());

	}//메인 끝

	private static void dfs(int curR, int curC) {
		visited[curR][curC] = true;
		cnt++;
		for (int i = 0; i < 4; i++) {
			int nr = curR + dr[i];
			int nc = curC + dc[i];

			if (inRange(nr, nc) && !visited[nr][nc] && grid[nr][nc]==1) {
				dfs(nr,nc);
			}
		}
	}

	private static boolean inRange(int nr, int nc) {
		return nr >= 0 && nr < n && nc >= 0 && nc < n;
	}
}
