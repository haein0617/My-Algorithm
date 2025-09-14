import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] result;
	static int n,m;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		result = new int[m+1];
		bt(1);
		System.out.println(sb.toString());
		
		
		
	}
	private static void bt(int cur) {
		if(cur > m) {
			for (int i = 1; i <= m; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}else {
			
			for (int i = 1; i <= n; i++) {
				if(result[cur-1]<=i) {
					result[cur]=i;
					bt(cur+1);
				}
				
			}
			
			
			
		}
		
		
		
	}
}
