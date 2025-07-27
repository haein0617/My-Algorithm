import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/* N개로 이루어진 수열 a와 정수 x a에서 x보다 작은 수를 모두 출력.
		 */
		int N=sc.nextInt();
		int X=sc.nextInt();
		int[] A = new int[N];
		for(int i = 0; i<N;i++) {
			A[i]=sc.nextInt();
			if(A[i]<X) {
				System.out.printf("%d ",A[i]);
			}
		}
		
		
	}
}
