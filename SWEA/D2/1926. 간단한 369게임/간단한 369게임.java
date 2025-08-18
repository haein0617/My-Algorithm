import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String[] game= new String[n+1];
		for (int i = 1; i <= n; i++) {
			game[i] = String.valueOf(i);
		}
		for (int i = 1; i <= n; i++) {
			if(game[i].contains("3") || game[i].contains("6") ||game[i].contains("9")) {
				int count = 0;
				for (int j = 0; j < game[i].length(); j++) {
					if(game[i].charAt(j)=='3' || game[i].charAt(j)=='6' || game[i].charAt(j)=='9') {
						count++;
					}
				}
				for (int j = 0; j < count; j++) {
					sb.append('-');
				}
				
			}else {
				sb.append(game[i]);
			}
			sb.append(" ");
		}
		
		System.out.println(sb);
		
	}
}
