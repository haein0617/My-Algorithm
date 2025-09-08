import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static boolean[][] visited;
	static int[][] mine;
	static int cnt;
	static int n;
	private static char[][] grid;

	static class Pair {
		int r, c;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) { // 테케 시작
			n = Integer.parseInt(br.readLine());
			cnt = 0;
			grid = new char[n][n];
			mine = new int[n][n];
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				grid[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(grid[i][j] == '*') {
						mine[i][j] = -1;
						continue;
					}
					
					int count = 0;
					if (grid[i][j] != '*') {
						for (int k = 0; k < 8; k++) { // 8방 탐색
							int nr = i + dr[k];
							int nc = j + dc[k];

							// 범위 안이고 지뢰 몇 개인지 체크.
							if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == '*') {
								count++;
							}
						}
					}
					
					mine[i][j] = count;
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (mine[i][j] == 0 && !visited[i][j]) { // 지뢰 0개고 방문 안 했으면?
						bfs(i, j);
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && grid[i][j] != '*') {
						cnt++;
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(cnt).append("\n");

		} // 테케 끝
		System.out.println(sb.toString());

	}

	private static void bfs(int r, int c) {
		cnt++;
		Queue<Pair> q = new ArrayDeque<>();

		visited[r][c] = true;
		q.offer(new Pair(r, c));

		while (!q.isEmpty()) {
			Pair cur = q.poll();

			int curR = cur.r;
			int curC = cur.c;

				for (int i = 0; i < 8; i++) { // 8방 탐색
					int nr = curR + dr[i];
					int nc = curC + dc[i];

					if (check(nr, nc)) {
						if(mine[nr][nc] == 0) {
							visited[nr][nc] = true;
							q.offer(new Pair(nr, nc));
						}else {
							visited[nr][nc] = true;
						}
					}
				}

		}

	}

	private static boolean check(int nr, int nc) {
		if (nr >= n || nr < 0 || nc >= n || nc < 0) { // 범위 벗어나는지?
			return false;
		}
		if (visited[nr][nc]) {// 방문 했었는지?
			return false;
		}
		if (grid[nr][nc] == '*') { // 지뢰인지?
			return false;
		}

		return true; // 아니면 ㄱㄱ
	}
}
