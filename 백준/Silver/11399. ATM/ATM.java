import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] ans = new int[n];
		int sum = 0;
		int result = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			ans[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ans);
		for (int i = 0; i < ans.length; i++) {
			sum +=ans[i];
			result += sum;
		}
		System.out.println(result);
		
	}
}
