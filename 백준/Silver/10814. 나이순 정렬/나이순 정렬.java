import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[][] members = new String[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			members[i][0] = st.nextToken();//나이
			members[i][1] = st.nextToken();//이름
		}
		
		Arrays.sort(members, (a1,a2)->{
			return Integer.parseInt(a1[0])- Integer.parseInt(a2[0]);
		});
		
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(members[i][0]).append(" ").append(members[i][1]).append("\n");
		}
		System.out.println(sb);
	}
}
