import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		sb.append("I");
		for (int i = 0; i < n; i++) {
			sb.append("OI");
		}
		int m = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		int cnt = 0;
		int fromIndex = 0; 
		String target = sb.toString();
		while((fromIndex = str.indexOf(target, fromIndex)) != -1) {
			cnt++;
			fromIndex++;
		}
		
		result.append(cnt);
		System.out.println(result.toString());
		
		
	}

}
