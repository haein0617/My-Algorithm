import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int c = Integer.parseInt(br.readLine());
		for (int i = 0; i < c; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int sum = 0;
			int[] score = new int[n];
			for (int j = 0; j < n; j++) {
				score[j]=Integer.parseInt(st.nextToken());
				sum+=score[j];
			}
			double avg = (double)sum/n;
			//평균을 넘는 학생들의 비율?
			//평균 넘는 애들 / 전체 *100?
			double good = 0;
			for (int j = 0; j < score.length; j++) {
				if(score[j]>avg) {
					good++;
				}
			}
			sb.append(String.format("%.3f", good/n*100)).append("%").append("\n");
		}
		System.out.print(sb);
	}
}