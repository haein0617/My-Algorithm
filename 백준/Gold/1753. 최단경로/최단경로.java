import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge>{
		int to,cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost-o.cost;
		}

		@Override
		public String toString() {
			return "Edge [to=" + to + ", cost=" + cost + "]";
		}
		
		
		
	}
	static int[] dist;
	private static List<Edge>[]  list;
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());//정점의 수
		int E = Integer.parseInt(st.nextToken());// 간선의 수
		int K = Integer.parseInt(br.readLine()); // 시작 정점 번호
		
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		list = new ArrayList[V+1];
		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Edge(b,c));
		}
		
		dijkstra(K);
		
		
		for (int i = 1; i <= V; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			}
			else {
				sb.append(dist[i]).append("\n");
			}
		}
		
		System.out.println(sb.toString());
		
		
		
	}
	private static void dijkstra(int k) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[k] = 0;
		pq.offer(new Edge(k,0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			int vertex = cur.to;
			int cost = cur.cost;
			
			if(cost > dist[vertex]) {
				continue;
			}
			
			for (Edge nei : list[vertex]) {
				int neiVer = nei.to;
				int neiCost = nei.cost;
				
				int totalCost = cost + neiCost;
				
				if(totalCost<dist[neiVer]) {
					dist[neiVer] = totalCost;
					
					pq.offer(new Edge(neiVer, totalCost));
				}
				
			}
			
			
		}
		
		
	}
}
