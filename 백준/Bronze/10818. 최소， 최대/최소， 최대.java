import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] p = new int[N];
		for(int i = 0; i < p.length ;i++) {
			p[i] = sc.nextInt();
		}
		int max = p[0];
		int min = p[0];
		for(int i = 0; i <p.length;i++) {
			if(max<p[i]) {
				max = p[i];
			}
		}
		for(int i = 0; i <p.length;i++) {
			if(min>p[i]) {
				min = p[i];
			}
		}
		System.out.printf("%d %d",min,max);
		
	}
}
