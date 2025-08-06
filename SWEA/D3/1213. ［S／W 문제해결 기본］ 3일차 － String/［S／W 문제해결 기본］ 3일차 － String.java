import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			
			String a = br.readLine(); // 2
			String b = br.readLine(); // 99
			int c = a.length(); // 2
			int d = b.length(); // 99
			int count = 0;

			for (int i = 0; i <= d - c; i++) { // 0~97
				boolean isMatch = true;
				for (int j = 0; j < c; j++) { // 0 1
					if (a.charAt(j) != b.charAt(i + j)) { // a.0 b.0
						isMatch = false;
						break;
					}
				}
				if(isMatch) {
					count++;
				}
			}
			System.out.printf("#%d %d%n", tc, count);
		}
	}
}
