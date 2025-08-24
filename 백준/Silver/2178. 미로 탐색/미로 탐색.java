import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int [][] grid;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N,M,cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String r = br.readLine();
			for (int j = 0; j < M; j++) {
				grid[i][j] = r.charAt(j) - '0';
				
			}
		}
		bfs(0,0);
		System.out.println(grid[N-1][M-1]);
		
	}

	private static void bfs(int i, int j) {
		Queue<Pair> q = new ArrayDeque<>();
		q.offer(new Pair(i,j));
		visited[i][j]=true;
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			
			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(inRange(nr,nc) && !visited[nr][nc] && grid[nr][nc]==1) {
					visited[nr][nc] = true;
					grid[nr][nc] = grid[r][c] +1;
					q.offer(new Pair(nr,nc));
				}
			}
			
			
		}
	}

	private static boolean inRange(int nr, int nc) {
		// TODO Auto-generated method stub
		return nr>=0 && nr<N && nc>=0 && nc<M;
	}
}

class Pair {
	int r;
	int c;
	
	public Pair(int r, int c) {
		this.r = r;
		this.c = c;
	}

}
