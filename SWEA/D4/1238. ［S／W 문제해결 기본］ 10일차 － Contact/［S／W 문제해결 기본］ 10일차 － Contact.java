import java.io.*;
import java.util.*;

public class Solution {
	private static int n;
	static List<Integer>[] list;
	static boolean[] visited;
	private static int max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10 ; tc++) { // 테케 시작
			StringTokenizer st = new StringTokenizer(br.readLine() , " ");
			n = Integer.parseInt(st.nextToken()); // 받을 데이터 수
			int m = Integer.parseInt(st.nextToken()); // 출발 정점 번호
			
			list = new ArrayList[101];
			for (int i = 0; i < 101; i++) {
				list[i] = new ArrayList<>();
			}
			visited = new boolean[101];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0 ; i < n/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
			}
			bfs(m);
			sb.append("#").append(tc).append(" ").append(max).append("\n");
			
		}//테케 끝
		System.out.println(sb.toString());
	}
	
	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		
		visited[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			max = Integer.MIN_VALUE;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				max = Math.max(max, cur);
				for (int next : list[cur]) {
					if(!visited[next]) {
						visited[next] = true;
						q.offer(next);
					}
				}
			}
		}
		
		
		
	}
	
	
}
