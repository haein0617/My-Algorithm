import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int sum = 0;
			int score = 0;
			String result = br.readLine();
			for (int j = 0; j < result.length(); j++) {
				
				if(result.charAt(j)=='O') {
					score++;
					sum+=score;
				}else {
					score=0;
				}
			}
			System.out.println(sum);
		}
	}
}