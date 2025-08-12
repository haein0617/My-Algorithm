import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine()); // 테케 입력
		for (int tc = 1; tc <= t; tc++) { // 테케 시작
			int n = Integer.parseInt(br.readLine()); // 배열 n 입력.
			int[][] arr = new int[n][n]; // n*n의 방 생성
			for (int i = 0; i < n; i++) { // 방들의 값 입력 받음.
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 방들의 값 입력 종료
				// 방향 배열 상 하 좌 우
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };
			int max = Integer.MIN_VALUE;
			int rnum = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int count = 1;
					int r = i;
					int c = j;
					while (true) {// 탐색 시작
						boolean moved = false;

						for (int k = 0; k < 4; k++) {
							int nr = r + dr[k]; // 다음 이동 방향 체크용
							int nc = c + dc[k]; // 다음 이동 방향 체크용

							if (nr < n && nr >= 0 && nc < n && nc >= 0) {// 배열 범위 안에 있는지 확인하는 if문
								if (arr[nr][nc] == arr[r][c] + 1) {// 4방 중 1큰게 있는지 찾기
									r = nr;
									c = nc;
									count++;
									moved = true;
									break; // 이동 했으니까 다음 방으로 ㄱㄱ
								}
							}
						}
						if (!moved) {// 4방 탐색으로 더 이상 못 찾으면?
							break;
						}
					} // 탐색 while문 종료
					if(count>max) { //방금 카운트가 더 크면 갱신
						max = count;
						rnum = arr[i][j];
					}else if (count==max) { //만약 카운트가 맥스랑 같으면?
						if(arr[i][j]<rnum) { //방 번호만 더 작은걸로 갱신.
							rnum=arr[i][j];
						}
					}
					
				}//안쪽 for문 종료
			}//바깥쪽 for문 종료
			sb.append("#").append(tc).append(" ").append(rnum).append(" ").append(max).append("\n");
		} // 테케 끝
		System.out.println(sb);
	}
}
