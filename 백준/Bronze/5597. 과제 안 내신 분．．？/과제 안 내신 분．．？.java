import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] pass = new boolean[31];
		for (int i = 0; i < 28; i++) {
			int a = Integer.parseInt(br.readLine());
			pass[a] = true;
		}
		
		for (int i = 1; i < pass.length; i++) {
			if(pass[i]==false) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}
}
