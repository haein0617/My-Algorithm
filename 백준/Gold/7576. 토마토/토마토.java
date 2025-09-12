import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pair{
		int r,c;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	private static int n;
	private static int m;
	private static int[][] map;
	private static int day;
	static int cnt1;
	static int cnt0;
	static int cntM;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken()); // 열
		m = Integer.parseInt(st.nextToken()); // 행
		
		cnt1 = 0;
		cnt0 = 0;
		cntM = 0;
		map = new int[m][n];
		List<Pair> good = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					good.add(new Pair(i,j));
					cnt1++;
				}else if(map[i][j] == 0) {
					cnt0++;
				}else {
					cntM++;
				}
			}
		}
		if(cnt0 == 0) {
			System.out.println(0);
			return;
		}
		
		
		
		day = -1;
		bfs(good);
		if(n*m - cntM == cnt1) {
			System.out.println(day);
		}else if(cnt0>0){
			System.out.println(-1);
		}
		
		
	
	
	}
	private static void bfs(List<Pair> good) {
		Queue<Pair> q = new ArrayDeque<>();
		
		for (Pair pair : good) {
			q.add(pair);
		}
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				Pair cur = q.poll();
				
				for (int j = 0; j < 4; j++) {
					int nr = cur.r + dr[j];
					int nc = cur.c + dc[j];
					if(check(nr,nc) && map[nr][nc] == 0) {
						map[nr][nc] = 1;
						cnt0--;
						cnt1++;
						q.offer(new Pair(nr,nc));
					}
				}
			}
			day++;
		}
		
		
		
	}
	private static boolean check(int nr, int nc) {
		return nr>=0 && nr < m && nc >= 0 && nc < n;
	}
}
