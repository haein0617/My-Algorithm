import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//일단 카드가 몇 장인지랑 만들어야 할 수가 몇인지 입력 받자.
		int n = sc.nextInt();
		int m = sc.nextInt();
		int max = Integer.MIN_VALUE;
		int [] cards = new int[n];
		for(int i = 0;i<n;i++) {
			cards[i] =sc.nextInt();
		}
		for(int i = 0;i<n-2;i++) {		//
			for(int j=i+1;j<n-1;j++) {
				for(int k = j+1;k<n;k++) {
					int sum = cards[i]+cards[j]+cards[k];
					
					if(sum<=m) {
						if(sum>max) {
							max = sum;
						}
					}
				}
			}
		}
		System.out.println(max);
	}
}
