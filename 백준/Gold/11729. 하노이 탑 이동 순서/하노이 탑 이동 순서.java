import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		sb.append((1<<n)-1).append("\n");
		hanoi2(n,1,2,3);
		System.out.println(sb.toString());
		
	}

	public static void hanoi2(int n, int a, int b, int c) {
		if(n==1) {
			sb.append(a).append(" ").append(c).append("\n");
		}else {
			hanoi2(n-1,a,c,b);
			sb.append(a).append(" ").append(c).append("\n");
			hanoi2(n-1,b,a,c);
		}
	}
}