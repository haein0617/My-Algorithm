import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	private static int n;
	private static List<Integer>[]  list;
	static boolean[] visited;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) { // 테케 시작
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken()); // 사람 수
			int m = Integer.parseInt(st.nextToken()); // 관계 수
			
			list = new ArrayList[n+1];
			visited = new boolean[n+1];
			for (int i = 0; i < n+1; i++) {
				list[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			result = 0;
			for (int i = 1; i < n+1; i++) {
				if(!visited[i]) {
					link(i);
				}
				
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}// 테케 끝
		System.out.println(sb.toString());
		
	}

	private static void link(int i) {
		visited[i] = true;
		result++;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(i);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int j = 0; j < list[cur].size(); j++) {
				int next = list[cur].get(j);
				if(!visited[next]) {
					q.offer(next);
					visited[next] = true;
				}
			}
		}
		
	}
}
