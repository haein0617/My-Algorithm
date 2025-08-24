import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] listArr = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			listArr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			listArr[b].add(a);
		}
		int[] dp = new int[N+1];
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if(listArr[i].isEmpty()) { // 선수과목이 없다면?
				dp[i]=1;
				sb.append(1).append(" ");
			}else {
				int max = 0; 
				for (int j = 0; j < listArr[i].size(); j++) {
					max = Math.max(dp[listArr[i].get(j)],max);
				}
				dp[i]=max+1; //다음 학기에 들어야 하니까.
				sb.append(max+1).append(" ");
			}
		}
		
		System.out.println(sb);
	}
}
