import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> table = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			table.add(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int target = 0;
		ArrayList<Integer> result = new ArrayList<>();
		while(true) {
			target= (target+K-1)%table.size();
			result.add(table.get(target));
			sb.append(table.get(target));
			table.remove(target);
		
			if(result.size()==N) {
				break;
			}
			sb.append(", ");
		}
		sb.append(">");
		
		System.out.println(sb);
	}
}
