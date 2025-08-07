import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) { // 테스트 케이스 시작
			int t = Integer.parseInt(br.readLine()); // 테스트 케이스 입력 생략.
			int n = 100;
			char[][] arr = new char[n][n];
			
			for (int i = 0; i < n; i++) { // 배열에 하나씩 입력 받았음.
				String temp = br.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = temp.charAt(j);
				}
			}
			int max = Integer.MIN_VALUE;
            for (int r=0; r<100; r++) { // 행 
                for (int c=0; c<100; c++) { // 열 
                    // 짝수 가로 펠린드롬 찾기
                    int i = c; // 펠린드롬 판별 시작점 
                    int j = c+1; // 펠린드롬 판별 끝점 
                    while (i>=0 && j<=99 && arr[r][i] == arr[r][j]) {
                        i --; j++;
                    }
                    max = Math.max(max, j-i-1);
                     
                    // 짝수 세로 펠린드롬 찾기
                    i = r;
                    j = r+1;
                    while (i>=0 && j<=99 && arr[i][c] == arr[j][c]) {
                        i --; j++;
                    }
                    max = Math.max(max, j-i-1);
                     
                    // 홀수 가로 펠린드롬 찾기
                    i = c-1;
                    j = c+1;
                    while (i>=0 && j<=99 && arr[r][i] == arr[r][j]) {
                        i --; j++;
                    }
                    max = Math.max(max, j-i-1);
                     
                    // 홀수 세로 펠린드롬 찾기
                    // 짝수 세로 펠린드롬 찾기
                    i = r-1;
                    j = r+1;
                    while (i>=0 && j<=99 && arr[i][c] == arr[j][c]) {
                        i --; j++;
                    }
                    max = Math.max(max, j-i-1);
                }
            }
            System.out.println("#"+t+" "+max);
		} // 테스트 케이스 끝
	}// 메인 끝
}
