import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n;

	static StringBuilder sb = new StringBuilder();

	private static List<Integer>[] graph;

	private static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken()); // 정점의 개수
		int m = Integer.parseInt(st.nextToken()); // 간선의 개수
		int v = Integer.parseInt(st.nextToken()); // 탐색 시작 정점 번호
		
		graph = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a); //양방향이라니까 둘 다 넣기.
		}
		for (int i = 1; i < n+1; i++) {
			Collections.sort(graph[i]);
		}
		
		
		visited = new boolean[n+1];
		dfs(v);
		sb.append("\n");
		visited = new boolean[n+1];
		bfs(v);
		System.out.println(sb.toString());
		
		
		
		
		
	}

	private static void bfs(int v) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(v);
		visited[v] = true;			

		while(!q.isEmpty()) {
			
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			
			for (int i = 0; i < graph[cur].size(); i++) {
				int a = graph[cur].get(i);
				if(!visited[a]) {
					visited[a] = true;
					q.offer(a);
				}
			}
			
		}
		
	}

	private static void dfs(int v) {
		if(visited[v]) {
			return;
		}
		else {
			sb.append(v).append(" ");
			visited[v] = true;
			for (int i = 0; i < graph[v].size(); i++) {
				int a = graph[v].get(i);
				dfs(a);
			}
		}
	}
}
