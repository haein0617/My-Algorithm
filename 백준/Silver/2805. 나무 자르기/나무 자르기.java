import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int m,n;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int max = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine(), " ");
		int[] trees = new int[n];
		for (int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, trees[i]);
		}
		int mid = max/2;
		int min = 0;
		long sum = 0;
		int result = 0;
		while(min<=max) {
			mid = (min+max) / 2;
			sum = 0;
			for (int i = 0; i < trees.length; i++) {
				if(trees[i]>mid) {
					sum += trees[i]-mid;
				}
			}
			
			
			if(sum >= m) {
				result = mid;
				min = mid + 1;
				
			}else if (sum<m) {
				max = mid - 1;
			}
			
		}
		
		System.out.println(result);
		
		
	}
}
