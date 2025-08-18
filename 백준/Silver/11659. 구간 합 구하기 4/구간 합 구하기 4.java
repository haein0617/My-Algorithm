import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // 수의 개수
		int m = Integer.parseInt(st.nextToken()); // 구간의 개수
		int[] sumArr = new int[n+1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			sumArr[i] = sumArr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for (int k = 0; k < m; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken())-1;
			int j = Integer.parseInt(st.nextToken());
			
			int sum = sumArr[j] - sumArr[i];
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}
