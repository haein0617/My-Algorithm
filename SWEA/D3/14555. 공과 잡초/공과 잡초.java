import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t ; tc++) { //테케 시작
			
			String a = br.readLine();
			a=a.replace("()", "B");
			a=a.replace("(|", "B");
			a=a.replace("|)", "B");
			int count = 0;
			for (int i = 0; i < a.length(); i++) {
				if(a.charAt(i)=='B')
					count++;
			}
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}//테케 끝
		System.out.println(sb);
		
		
	}
}
