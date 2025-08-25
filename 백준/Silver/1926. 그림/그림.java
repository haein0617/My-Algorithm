import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static boolean[][] visited;
	static int count = 0;
	static int max = 0;
	static int[][] grid;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int n,m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n][m];
		grid = new int[n][m];
		
		for (int i = 0; i < n; i++) { // 격자에 1,0 입력받기.
			st=new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력 for문 끝
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(grid[i][j]==1 && !visited[i][j]) {
					visited[i][j] = true;
					bfs(new Pair(i,j));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(count).append("\n").append(max);
		System.out.println(sb);
	}

	private static void bfs(Pair start) {
		Queue<Pair> q = new ArrayDeque<>();
		
				
		q.add(start);
		count++;
		
		int pollcount = 0;
		while(!q.isEmpty()) {
			Pair cur =q.poll();
			pollcount ++;
			int r = cur.r;
			int c = cur.c;
			
			for (int i = 0; i < 4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(inRange(nr,nc) && grid[nr][nc]==1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new Pair(nr,nc));
					
				}
				
			}
			
		}
		max = Math.max(pollcount, max);
		
		
	}

	private static boolean inRange(int nr, int nc) {
		return nr>=0 && nr< n && nc>=0 && nc<m;
	}
	
	static class Pair{
		int r;
		int c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		
	}
	
}
