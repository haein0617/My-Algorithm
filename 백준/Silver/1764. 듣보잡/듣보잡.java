import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<String> dud = new HashSet<>();
		List<String> dudbo = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			dud.add(br.readLine());
		}
		for (int i = 0; i < m; i++) {
			String bo = br.readLine();
			if(dud.contains(bo)) {
				dudbo.add(bo);
			}
		}
		
		Collections.sort(dudbo);
		StringBuilder sb = new StringBuilder();
		sb.append(dudbo.size()).append("\n");
		for (int i = 0; i < dudbo.size() ; i++) {
			sb.append(dudbo.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}
