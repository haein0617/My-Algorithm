import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] field;
	static boolean[][] visited;
	static int n, m;
	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {// 테케 시작
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(st.nextToken()); // 가로
			n = Integer.parseInt(st.nextToken()); // 세로
			int k = Integer.parseInt(st.nextToken()); // 배추의 개수
			field = new boolean[m][n];
			visited = new boolean[m][n];
			for (int i = 0; i < k; i++) { // k 수만큼 좌표 받기
				st = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				field[r][c] = true;
			} // 좌표 받기 끝

			int count = 0;

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (field[i][j] && !visited[i][j]) { // 배추인지? 그리고 방문한적 없는지
						count++; // 그럼 지렁이 한 마리 추가
						dfs(i, j);
					}
				}
			}
			sb.append(count).append("\n");
		} // 테케 끝
		System.out.println(sb.toString());
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) { // 4방 탐색
			int next_r = r + dr[i];
			int next_c = c + dc[i];
			if (next_r >= 0 && next_r < m && next_c >= 0 && next_c < n) {
				// 다음 위치에 배추가 있고, 아직 방문하지 않았다면
				if (field[next_r][next_c] && !visited[next_r][next_c]) {
					dfs(next_r, next_c); // 그 위치로 이동하여 탐색 계속 (재귀 호출)
				}

			}

		}
	}
}
