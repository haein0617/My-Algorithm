import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] p = new int[9];
		for(int i = 0; i < p.length ;i++) {
			p[i] = sc.nextInt();
		}
		int max = p[0];
		int maxIndex = 0;
		for(int i = 0; i <p.length;i++) {
			if(max<p[i]) {
				max = p[i];
				maxIndex = i;
			}
		}
		System.out.println(max);
		System.out.println(maxIndex+1); 
		
	}
}
