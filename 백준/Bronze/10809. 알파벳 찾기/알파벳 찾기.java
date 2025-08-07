import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		int[] c = new int[26];
		for (int i = 0; i < c.length; i++) {
			c[i] = -1;
		}
		for (int i = 0; i < s.length(); i++) {
			c[s.charAt(i)-'a'] =  s.indexOf(s.charAt(i)) ;   
		}
		for (int i = 0; i < c.length; i++) {
			sb.append(c[i]).append(" ");
		}
		System.out.println(sb);
		
	}
}