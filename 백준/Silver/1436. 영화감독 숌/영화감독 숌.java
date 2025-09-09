import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int pointer = 666;
		Integer.toString(cnt);
		while(n!=cnt) {
			String str = Integer.toString(pointer);
			if(str.contains("666")) {
				cnt++;
			}
			pointer++;
		}
		System.out.println(pointer-1);
		
		
	}
}
