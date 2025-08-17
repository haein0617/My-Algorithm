import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		int m = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수
		
		ArrayList<Integer>[] graph = new ArrayList[n+1];
		
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		
		boolean[] visited = new boolean[n+1];
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		int count = 0; //1번을 제외한 감염 수
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for (int neighbor : graph[node]) {
				if(!visited[neighbor]) {
					visited[neighbor] =true;
					q.add(neighbor);
					count++; 
				}
			}
		}
		
		System.out.println(count);
		
	}
}
