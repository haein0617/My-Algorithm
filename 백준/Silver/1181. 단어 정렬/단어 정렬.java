import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String[] str = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = br.readLine();
		}
		
		Arrays.sort(str, (s1, s2) -> {
            // 1. 1차 기준: 길이를 비교한다.
            int len_diff = s1.length() - s2.length();

            // 2. 길이가 다른 경우, 길이 비교 결과를 바로 반환한다.
            if (len_diff != 0) {
                return len_diff;
            }
            
            // 3. 길이가 같은 경우에만, 2차 기준인 사전순으로 비교한 결과를 반환한다.
            return s1.compareTo(s2);
        });
		
		for (int i = 0; i < str.length; i++) {
			if(i+1<str.length && str[i].equals(str[i+1])) { //중복 제거
				continue;
			}
			System.out.println(str[i]);
		}
		
		
		
		
		
	}
}
