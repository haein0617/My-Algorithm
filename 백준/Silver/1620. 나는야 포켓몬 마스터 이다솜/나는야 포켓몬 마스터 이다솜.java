import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> pokemon = new HashMap<>();
		String[] arr = new String[n + 1];
		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			arr[i] = str;
			pokemon.put(str, i);
		}
		
		
		
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			
			if(Character.isDigit(str.charAt(0))) {
				int a = Integer.parseInt(str);
				sb.append(arr[a]).append("\n");
			}else {
				sb.append(pokemon.get(str)).append("\n");
			}
			


		}

		System.out.println(sb.toString());

	}
}
