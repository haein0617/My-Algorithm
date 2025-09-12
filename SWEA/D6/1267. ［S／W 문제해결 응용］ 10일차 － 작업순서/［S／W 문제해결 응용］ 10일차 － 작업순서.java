import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10 ; tc++) { // 테케 시작 (10개)
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int v = Integer.parseInt(st.nextToken()); // 정점의 수 (3 <= v <= 1000)
			int e = Integer.parseInt(st.nextToken()); // 간선의 수 (2 <= e <= 3000)
			
			 List<Integer>[] adjList = new ArrayList[v + 1];
	            for (int i = 0; i <= v; i++) {
	                adjList[i] = new ArrayList<>(); // 각 리스트 초기화
	            }
			int[] inDegree = new int[v+1]; //진입차수 저장 배열 ( 선행 과제 수 )
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < e; i++) {
				int in = Integer.parseInt(st.nextToken());
				int out = Integer.parseInt(st.nextToken());
				
				 adjList[in].add(out);
				inDegree[out]++;
			}// 입력 완료
			
			Queue<Integer> q = new ArrayDeque<>();
			
			for(int i = 1; i<v+1; i++) {
				if(inDegree[i] == 0) {
					q.offer(i);
				}
			}
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				sb.append(cur).append(" ");
				
				for (int to : adjList[cur]) {
					inDegree[to]--;
					
					if(inDegree[to] == 0) {
						q.offer(to);
					}
				}
			}
			sb.append("\n");
		}// 테케 끝
		System.out.println(sb.toString());
		
		
	}// 메인 끝
}//클래스 끝
