import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int m;
	static boolean[] visited;
	static List<Integer> result;
	static StringBuilder sb = new StringBuilder();
	private static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		result = new ArrayList<>();
		visited = new boolean[n+1];
		bt(1);
		
		System.out.println(sb.toString());
		
		
	}

	private static void bt(int i) {
		if(i==m+1) {
			for (int j = 0; j < result.size(); j++) {
				sb.append(result.get(j)).append(" ");
			}
			sb.append("\n");
			return;
		}else {
			
			for (int j = 1; j <= n; j++) {
				if(!visited[j]) {
					visited[j] = true;
					result.add(j);
					bt(i+1);
					result.remove(result.size()-1);
					visited[j] = false;
				}
			}
		}
		
		
		
	}
}
