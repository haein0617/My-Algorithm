import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	static int[] dr = {-1,1,0,0}; 
	static int[] dc = {0,0,-1,1}; // 상하좌우 탐색 배열
	private static int[][] map;
	static int[][] sum;
	static class Node implements Comparable<Node>{
		int r,c,cost;

		public Node(int r, int c,int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost-o.cost;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while(true) {//테케 시작
			n = Integer.parseInt(br.readLine());
			if(n==0)break; // 테케 종료 조건
			
			map = new int[n][n];
			sum = new int[n][n]; // 최소 루피 배열
			for (int i = 0; i < n ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}//루피 입력 완료
			
			dijkstra(0,0);
			sb.append("Problem ").append(tc).append(": ").append(sum[n-1][n-1]).append("\n");
			tc++;
		}//테케 끝
		System.out.println(sb.toString());
	}
	private static void dijkstra(int r, int c) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) { // sum 배열을 매우 큰 값으로 초기화
			Arrays.fill(sum[i], Integer.MAX_VALUE);
		}
		
		sum[r][c] = map[r][c]; // 시작점의 비용
		pq.offer(new Node(r, c, sum[r][c]));
		
		//다익스트라 시작
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(sum[cur.r][cur.c] < cur.cost) {
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if(check(nr,nc)) {
					int nextCost = cur.cost + map[nr][nc];
					if(sum[nr][nc]>nextCost) {
						sum[nr][nc] = nextCost;
						pq.offer(new Node(nr,nc,nextCost));
					}
					
					
				}
				
				
			}
			
		}
		
		
		
		
	}
	//범위 나가는지 확인
	private static boolean check(int nr, int nc) {
		return nr>=0 && nr < n && nc >=0 && nc < n;
	}
}
