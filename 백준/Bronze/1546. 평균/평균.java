import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력을 받자. n
		int n = sc.nextInt();
		int[] test = new int[n];
		int MAX_VALUE = 0;
		double[] newTest = new double[n];//세준이 방식대로 구한 점수
		double sum = 0;
		for (int i = 0; i < n; i++) {//배열에 각 시험 점수 받음
			test[i] = sc.nextInt();
			if(test[i]>MAX_VALUE) { //최고점 구하기.
				MAX_VALUE = test[i];
			}
		}
		
		for(int i = 0;i<n;i++) { //새로운 배열에 세준 식 점수 넣어버림 + 세준식 점수 합 구함) 
			newTest[i] = ((double)test[i]/MAX_VALUE) * 100;
			sum+= newTest[i];
		}
		System.out.println(sum/n);
	}
}
