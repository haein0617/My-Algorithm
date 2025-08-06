import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args ) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()) ;
		for(int tc=1;tc<=t;tc++) {
		String str = br.readLine();
		int result = 1;
		for (int i = 0; i < str.length()/2; i++) {
			if(str.charAt(i)==str.charAt(str.length()-1-i)) {
			}else {
				result = 0;
				break;
			}
		}
		System.out.printf("#%d %d%n",tc,result);
		}
	}
}
