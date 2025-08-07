import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine(); //문자열 입력 받음
		String S = s.toUpperCase(); // 문자열 대소문자 통일
		int [] arr = new int [26];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			arr[S.charAt(i)-'A']++;
			
		}
		char result='?';
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>max) {
				max = arr[i];
				result = (char)('A'+i); 
			}else if(arr[i]==max) {
				result = '?';
			}
			
		}
		
		System.out.println(result);
	}
}