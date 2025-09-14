import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};// 상하좌우
	static int n; // n*n배열
	public static boolean[][] visited;
	static char [][] grid1; // 색약 없는 버전
	static char [][] grid2; // 색약 있는 버전
	static int cnt; 
	
	public static class Pair{
		int r,c;
		char color;

		public Pair(int r, int c,char color) {
			this.r = r;
			this.c = c;
			this.color = color;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		grid1 = new char[n][n];
		grid2 = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			grid1[i] = str.toCharArray();
			grid2[i] = str.toCharArray();
			for (int j = 0; j < n; j++) {
				if(grid2[i][j]=='G') { // G와 R을 통일 시키기.
					grid2[i][j]='R';
				}
			}
		}// 입력 끝
		
		visited = new boolean[n][n];
		cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					bfs(new Pair(i,j,grid1[i][j]));
				}
			}
		}
		sb.append(cnt).append(" ");
		
		cnt = 0;
		visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					bfs2(new Pair(i,j,grid2[i][j]));
				}
			}
		}
		sb.append(cnt);
		
		System.out.println(sb.toString());
		
		
	}

	private static void bfs(Pair pair) {
		cnt++;
		Queue<Pair> q = new ArrayDeque<>();
		q.offer(pair);
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			char curCol = cur.color;
			
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc= cur.c + dc[i];
				//범위 안에 있고, 방문하지 않았고, 현재 색상과 같으면?
				if(inRange(nr,nc) && !visited[nr][nc]) {
					if(grid1[nr][nc] == curCol) {
						visited[nr][nc] = true;
						q.offer(new Pair(nr,nc,curCol));
						
					}
				}
			}
		}
	}
	private static void bfs2(Pair pair) {
		cnt++;
		Queue<Pair> q = new ArrayDeque<>();
		q.offer(pair);
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			char curCol = cur.color;
			
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc= cur.c + dc[i];
				//범위 안에 있고, 방문하지 않았고, 현재 색상과 같으면?
				if(inRange(nr,nc) && !visited[nr][nc]) {
					if(grid2[nr][nc] == curCol) {
						visited[nr][nc] = true;
						q.offer(new Pair(nr,nc,curCol));
						
					}
				}
			}
		}
	}

	private static boolean inRange(int nr, int nc) {
		return nr>=0 && nr<n && nc>=0 && nc<n;
	}
}
