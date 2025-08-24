import java.io.*;
import java.util.*;


public class Main {
	static char[][] maze;
	static boolean[][] visited;
	static int R,C;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		maze = new char[R][C];
		visited = new boolean[R][C];
		
		Queue<Pair> q_jihoon = new ArrayDeque<>();
		Queue<Pair> q_fire = new ArrayDeque<>();
		
		for (int i = 0; i < R; i++) {
			String a = br.readLine();
			for (int j = 0; j < C; j++) {
				maze[i][j] = a.charAt(j);
				if(a.charAt(j)=='J') { // 지훈이 위치 큐에 넣기
					q_jihoon.offer(new Pair(i,j));
				}
				else if(a.charAt(j)=='F') { // 불 발견될 때마다 큐에 넣기 
					q_fire.offer(new Pair(i,j));
				}
				
			}
		}
		int result = bfs(q_jihoon,q_fire);
		if(result == -1) {
			System.out.println("IMPOSSIBLE");
		}else {
			System.out.println(result);
		}
		
		
		
		
	}
	private static int bfs(Queue<Pair> q_jihoon, Queue<Pair> q_fire) {
		int time = 0; // 탈출에 걸린 시간
		
		if(!q_jihoon.isEmpty()) { //지훈이 시작 지점 체크
			Pair start = q_jihoon.peek();
			visited[start.r][start.c] = true;
			
		}
		while(!q_jihoon.isEmpty()) {
			time++;
			
			int fireSize = q_fire.size();
			for (int i = 0; i < fireSize; i++) {
				Pair curF = q_fire.poll();
				for (int j = 0; j < 4; j++) {
					int nr = curF.r + dr[j];
					int nc = curF.c + dc[j];
					
					if(inRange(nr,nc) && maze[nr][nc] !='#' && maze[nr][nc]!='F') {
						maze[nr][nc] = 'F';
						q_fire.offer(new Pair(nr,nc));
						
					}
				}
			}
			
			int jihoonSize = q_jihoon.size();
			for (int i = 0; i < jihoonSize; i++) {
				Pair cur = q_jihoon.poll();
				
				if(cur.r==0 || cur.r==R-1||cur.c==0||cur.c==C-1) { // 가장자리라면?
					return time; //탈출 완
				}
				
				for (int j = 0; j < 4; j++) {
					int nr = cur.r+dr[j];
					int nc = cur.c+dc[j];
					if(inRange(nr,nc) && !visited[nr][nc] 
							&& maze[nr][nc] != '#' && maze[nr][nc] != 'F') {
						visited[nr][nc] = true;
						q_jihoon.offer(new Pair(nr,nc));
						
					}
				}
			}
		}
		return -1;
	}
	private static boolean inRange(int r2, int c2) {
		// TODO Auto-generated method stub
		return r2>=0 && r2<R && c2>=0 && c2<C;
	}
	static class Pair {
		int r;
		int c;
		
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
}

