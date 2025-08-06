import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) { // 테스트케이스 시작
			String[] arr = new String[5];
			int max_size = 0;
			for (int i = 0; i < arr.length; i++) { // 배열에 하나씩 입력.
				arr[i] = br.readLine();
				if (arr[i].length() > max_size) {
					max_size = arr[i].length();
				}
			}
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < max_size; j++) {
				for (int i = 0; i < arr.length; i++) {
					if (arr[i].length() > j) {
						sb.append(arr[i].charAt(j));
					}
				}
			}

			System.out.println("#" + tc + " " + sb);
		} // 테스트 케이스 종료

	}
}
