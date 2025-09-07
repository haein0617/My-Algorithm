import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int[][] cafe;
	static boolean[][] visited;
	static int[] dr = {1,1,-1,-1};//우하,좌하,좌상,우상
	static int[] dc = {1,-1,-1,1};
	static int startR,startC;
	static int result;
	static List<Integer> eaten;
	private static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {//테케 시작
			n = Integer.parseInt(br.readLine());
			cafe = new int[n][n];
			eaten = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					cafe[i][j] = Integer.parseInt(st.nextToken());
				}
			}//입력 끝
			result = -1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited = new boolean[n][n];
					eaten.clear();
					startR = i;
					startC = j;
					dfs(i,j,0,0);
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}//테케 끝
		System.out.println(sb);
		
	}
	private static void dfs(int r, int c,int cnt, int dir) {
		eaten.add(cafe[r][c]);
		visited[r][c] = true;
		cnt++;
		
		
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		if(check(nr,nc)) {
			dfs(nr,nc,cnt,dir);
		}
		
		
		if(dir<3) {
			nr=r+dr[dir+1];
			nc=c+dc[dir+1];
			if(nr==startR && nc == startC) {
				result = Math.max(cnt, result);
			}
			if(check(nr,nc)) {
				dfs(nr,nc,cnt,dir+1);
			}
		}
		
		if(dir ==3) {
			nr=r+dr[dir];
			nc=c+dc[dir];
			if(nr==startR && nc == startC) {
				result = Math.max(cnt, result);
			}
		}
		
		
		eaten.remove(eaten.size()-1);
		visited[r][c] = false;
		
		
	}
	private static boolean check(int nr, int nc) {
		if(nr<0 || nr>=n || nc< 0 || nc>=n) { // 지역 벗어났는지?
			return false;
		}
		if(visited[nr][nc]) { // 방문한적 있는지?
			return false;
		}
		if(eaten.contains(cafe[nr][nc])) { // 먹은 적 있는지?
			return false;
		}
		
		return true; // 다 아니면 ㄱㄱ
	}
}
