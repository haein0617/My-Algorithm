import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][] board;
	static int N;
	static int answerCount = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		queen(0);

		System.out.println(answerCount);
	}

	private static void queen(int row) {
		if (row == N) { // 행이 끝까지 가면 퀸을 성공적으로 다 놨다는거니까.
			answerCount++; // 정답 개수 하나 증가.
			return;
		}
		// 현재 행의 모든 열에 퀸을 놓아보자.
		for (int col = 0; col < N; col++) {
			if (isSafe(row, col)) {
				board[row][col] = 1;

				queen(row + 1); // 다음 행 보내버려.

				// 퀸을 다시 회수한다. (백트래킹)
				board[row][col] = 0;
			}
		}

	}

	private static boolean isSafe(int row, int col) {
		// 주변에 퀸이 있는지 확인해야함.

		// 1. 같은 열(Column)에 다른 퀸이 있는지 확인
		// 현재 행(row)보다 위쪽 행들(i)만 검사.
		for (int i = 0; i < row; i++) {
			if (board[i][col] == 1) {
				return false; // 있다면 안전하지 않음
			}
		}

		// 2. 왼쪽 위 대각선에 다른 퀸이 있는지 확인
		// 현재 위치에서 한 칸씩 왼쪽 위로 이동하며 검사
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false; // 있다면 안전하지 않음
			}
		}

		// 3. 오른쪽 위 대각선에 다른 퀸이 있는지 확인
		// 현재 위치에서 한 칸씩 오른쪽 위로 이동하며 검사.
		for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
			if (board[i][j] == 1) {
				return false; // 있다면 안전하지 않음
			}
		}

		// 위 3가지 검사를 모두 통과했다면 안전한 위치
		return true;
	}
}
