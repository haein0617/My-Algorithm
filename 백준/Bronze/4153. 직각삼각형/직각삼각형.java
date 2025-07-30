import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int[] a = new int[3];
			//a를 오름차순 정렬
			for(int i =0;i<a.length;i++) {
				a[i] = sc.nextInt();
			}
			Arrays.sort(a);
			if (a[0] == 0 && a[1] == 0 && a[2] == 0) {
				break;
			}
			if (a[0] * a[0] + a[1] * a[1] == a[2] * a[2]) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
	}

}
