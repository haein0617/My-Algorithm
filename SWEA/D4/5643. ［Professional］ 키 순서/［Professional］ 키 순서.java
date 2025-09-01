import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	private static int result;
	private static int n;
	private static ArrayList<Integer>[] shorterList;
	private static ArrayList<Integer>[] tallerList;
	private static int cnt;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) { // 테케 시작
			n = Integer.parseInt(br.readLine()); // 학생 수
			int m = Integer.parseInt(br.readLine()); // 비교 수

			tallerList = new ArrayList[n + 1];
			shorterList = new ArrayList[n + 1];
			for (int i = 0; i < n + 1; i++) {
				tallerList[i] = new ArrayList<>();
				shorterList[i] = new ArrayList<>();
			}

			for (int i = 0; i < m; i++) { // 비교 입력 for문
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				tallerList[a].add(b); // b는 a보다 크다
				shorterList[b].add(a); // a는 b보다 작다
			}
			result = 0;
			for (int i = 1; i <= n; i++) {
				cnt = 0;
				visited = new boolean[n + 1];
				dfs(i, tallerList);
				visited[i] = false;

				visited = new boolean[n + 1];
				dfs(i, shorterList);

				if (cnt == n - 1) {
					result++;
				}
			}

			sb.append("#").append(tc).append(" ").append(result).append("\n");
		} // 테케 끝
		System.out.println(sb);
	}

	private static void dfs(int i, ArrayList<Integer>[] List) {
		visited[i] = true;
		for (int next : List[i]) {
			if (!visited[next]) {
				cnt++;
				dfs(next, List);
			}
		}

	}
}
