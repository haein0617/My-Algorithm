import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			String num = String.valueOf(i);
			int count = 0;
			for (int j = 0; j < num.length() ; j++) {
				char ch = num.charAt(j); // 글자 수 만큼 반복해서.
				if(ch == '3' || ch=='6'||ch=='9') {
					count++;
				}
			}
			if(count>0) { //박수 쳐야하면 몇 번인지?
				for (int j = 0; j <count; j++) {
					sb.append('-');
				}
			}
			else { // 박수 칠 필요 없으면
				sb.append(num);
			}
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}
}