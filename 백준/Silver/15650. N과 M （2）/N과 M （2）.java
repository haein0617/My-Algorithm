import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	private static int m;
	static boolean[] visited;
	private static int n;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1];
		result = new int[m];
		bt(0,1);
		System.out.println(sb.toString());
				
		
	}
	private static void bt(int cnt, int cur) {
		if(cnt == m) { // 숫자 m개 정했으면?
			for (int i = 0; i < m; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}else {
			for (int i = cur; i <= n ; i++) {
				
				if(!visited[i]) {
					result[cnt]=i;
					visited[i] = true;
					bt(cnt+1, i+1);
					result[cnt]=0;
					visited[i] = false;
				}
				
				
			}
			
		}
	}
}
