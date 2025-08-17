import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] dp = new long[1001];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < dp.length; i++) {
			dp[i]=(dp[i-1]+dp[i-2])%10007;
		}
		int n = Integer.parseInt(br.readLine());
		System.out.println(dp[n]);
	}
}
