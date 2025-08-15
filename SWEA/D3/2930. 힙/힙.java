import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {//테케 시작
			int n = Integer.parseInt(br.readLine());
			sb.append("#").append(tc).append(" ");
			PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				
				int a = Integer.parseInt(st.nextToken());
				if(a==1) {
					int b = Integer.parseInt(st.nextToken());
					heap.add(b);
				}else if(a==2) {
					if(heap.isEmpty()) {
						sb.append(-1).append(" ");
					}else {
						sb.append(heap.poll()).append(" ");
					}
				}
			}
			
			sb.append("\n");
		}//테케 끝
		System.out.println(sb);
	}
}
