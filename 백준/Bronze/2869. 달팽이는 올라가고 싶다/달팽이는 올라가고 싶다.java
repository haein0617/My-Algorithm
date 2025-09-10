import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken()); // 낮 +
		int b = Integer.parseInt(st.nextToken()); // 밤 -
		int v = Integer.parseInt(st.nextToken()); // 정상
		
		
		int lastday = v-a;
		
		int result = 0;
		if(lastday % (a-b) == 0) {
			result = lastday/(a-b);
		}else {
			result = lastday/(a-b)+1;
		}
		
		
		System.out.println(result+1);
	}
}
