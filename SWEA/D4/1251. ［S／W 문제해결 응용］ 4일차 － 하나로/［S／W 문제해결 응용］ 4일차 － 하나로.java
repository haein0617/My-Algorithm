import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static class Edge{
		int from, to;
		double cost;
		public Edge(int from, int to, double cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	static int[] p;
	private static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t ; tc++) { // 테케 시작
			n = Integer.parseInt(br.readLine()); // 섬 개수
			
			int[] r = new int[n];
			int[] c = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) { // 섬 좌표 r 받기
				r[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) { // 섬 좌표 c 받기
				c[i] = Integer.parseInt(st.nextToken());
			}
			double E = Double.parseDouble(br.readLine()); // 세율
			
			ArrayList<Edge> edgeList = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					long dR = (long)r[i]-r[j];
					long dC = (long)c[i]-c[j];
					double cost = (dR*dR + dC*dC) * E;
					
					edgeList.add(new Edge(i,j,cost));
				}
			}
			//일단 모든 간선이랑 가격 구했음. 이제 정렬 하면 될 듯?
			
			edgeList.sort((o1, o2) -> Double.compare(o1.cost, o2.cost));
			
			p = new int[n+1];
			
			for (int i = 0; i <= n; i++) {
				makeSet(i);
			}
			
			
			double ans = 0;
			int pick = 0;
			
			for (Edge now : edgeList) { // 향상된 for문으로 변경 (더 깔끔함)
	            int px = findSet(now.from);
	            int py = findSet(now.to);
	            if (px != py) {
	                union(px, py);
	                ans += now.cost;
	                pick++;
	            }
	            if (pick == n - 1) break; // n-1개 간선을 뽑으면 MST 완성
	        }
			
			long Answer = Math.round(ans);
			sb.append("#").append(tc).append(" ").append(Answer).append("\n");
			
		}// 테케 끝
		System.out.println(sb.toString());
		
	}
	private static void union(int px, int py) {
		p[py] = px;
	}
	private static int findSet(int i) {
		if(i != p[i]) {
			p[i] = findSet(p[i]);
		}
		return p[i];
		
	}
	private static void makeSet(int i) {
		p[i]=i;
	}
}
