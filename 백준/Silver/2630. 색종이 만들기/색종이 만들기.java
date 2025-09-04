import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[][] grid;
	private static int n;
	static int cntB;
	static int cntW;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine()); // N * N 의 N크기
		grid = new int[n][n];

		// 탐색을 하는데 정사각형이 아니면?
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cntB = 0;
		cntW = 0;
		dfs(0, 0, n);

		System.out.println(cntW);
		System.out.println(cntB);

	}

	private static void dfs(int r, int c, int size) {
		if (check(r, c, size)) {
			if (grid[r][c] == 0) {
				cntW++;
			} else {
				cntB++;
			}
			return;

		}else {
			int mid = size / 2;
			dfs(r, c, mid);
			dfs(r + mid, c, mid);
			dfs(r, c + mid, mid);
			dfs(r + mid, c + mid, mid);
			
		}

	}

	private static boolean check(int r, int c, int size) {
		int a = grid[r][c];
		
		for (int i = r; i <r+ size; i++) {
			for (int j = c; j <c+ size; j++) {
				if (grid[i][j] != a) {
					return false;
				}
				
			}
		}
		return true;
	}
}
