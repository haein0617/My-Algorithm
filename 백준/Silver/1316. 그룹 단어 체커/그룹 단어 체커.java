import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력
		int count = 0;
		
		for (int i = 0; i < n; i++) { // 테스트 케이스 시작
			
			String a = br.readLine(); // 단어 입력
			boolean groupword = true;
			boolean[] b = new boolean[26];
			char prevChar = ' ';
			

			for (int j = 0; j < a.length(); j++) {
				char currentChar = a.charAt(j);
				
				if (currentChar == prevChar) { // 전 꺼랑 같으면 넘어가기
					continue;
				}
				
				if (b[currentChar-'a']) { // 이미 나온거면 false
					groupword = false;
					break;
				}
				
				b[currentChar - 'a'] = true; //처음 등장한거면 true로 변경
				prevChar = currentChar; //다음 비교 할 거 바꾸기
				
			}
			if(groupword) {
				count++;
			}
			
			
		} // 테스트 케이스 종료
		System.out.println(count);
	}
}