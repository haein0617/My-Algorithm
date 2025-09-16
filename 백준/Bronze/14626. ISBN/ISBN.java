import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strNum = br.readLine();
		
		int sum = 0;
		int idx = 0;
		for (int i = 0; i < 13; i++) {
			char a = strNum.charAt(i);
			
			if(a=='*') {
				idx = i;
				continue;
			}
			
			if(i%2 == 0) {
				sum+= a-'0';
			}else {
				sum+= (a-'0') * 3;
			}
			
		}
		int result = 0;
		for (int i = 1; i < 10; i++) {
			if(idx %2 ==0) {
				if((sum+i) % 10 == 0) {
					result = i;
					break;
				}
				
			}else {
				if((sum+i*3) % 10 == 0) {
					result = i;
					break;
				}
				
				
			}
			
			
			
		}
		
		System.out.println(result);
		
		
		
	}
}
