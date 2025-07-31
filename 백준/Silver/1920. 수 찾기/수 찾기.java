import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// n이랑 m입력 받아서 같은지 비교하면 됨.
		int[] n = new int[sc.nextInt()];// n입력
		for (int i = 0; i < n.length; i++) {// n에 하나씩 대입
			n[i] = sc.nextInt();
		}
		Arrays.sort(n);
		int[] m = new int[sc.nextInt()];// m입력
		for (int i = 0; i < m.length; i++) {// m에 하나씩 대입
			m[i] = sc.nextInt();
		}
		for (int i = 0; i < m.length; i++) {
			int index = Arrays.binarySearch(n,m[i]);
				if (index >=0) {
					System.out.println(1);
				}else {
					System.out.println(0);
			}
		}
	}
}
