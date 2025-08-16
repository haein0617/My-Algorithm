import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			char b = str.charAt(i);
			if(b>='A' && b<'a') {
				b=(char) (b+32);
			}else if(b>='a') {
				b=(char) (b-32);
			}
			sb.append(b);
		}
		
		System.out.println(sb);
		
	}
}
