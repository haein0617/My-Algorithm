import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		
		int[] dp = new int[x+1];
		
		//2부터 n까지 
		//dp[1]은 이미 0이고 dp[0]은 없으므로.
		for (int i = 2; i <= x; i++) {
			dp[i] = dp[i-1]+1;
			
			if(i%2 ==0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
			
			if(i%3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
		}
		System.out.println(dp[x]);
			
		}

}