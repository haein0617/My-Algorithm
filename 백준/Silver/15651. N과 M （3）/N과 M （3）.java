import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int m;
	private static int n;
	static int[] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		result = new int[m];

		bt(0);
		System.out.println(sb.toString());

	}

	private static void bt(int cnt) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		} else {

			for (int i = 1; i <= n; i++) {
				result[cnt] = i;
				bt(cnt + 1);
			}
		}
	}

}
