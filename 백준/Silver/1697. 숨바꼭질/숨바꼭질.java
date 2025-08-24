import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited= new boolean[100001];
	static int K;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(N==K) {
			System.out.println(0);
			return;
		}
		int result = bfs(N);
		System.out.println(result);
	}

	private static int bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		visited[start] = true;
		
		int time = 0;
		
		while(!q.isEmpty()) {
			time++;
			
			
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				visited[cur] = true;
				if(inRange(cur-1) && !visited[cur-1]) {
					if(cur-1==K) {
						return time;
					}
					visited[cur-1] = true;
					q.offer(cur-1);
				}
				if(inRange(cur+1)&& !visited[cur+1]) {
					if(cur+1==K) {
						return time;
					}
					visited[cur+1] = true;
					q.offer(cur+1);
				}
				if(inRange(cur*2)&& !visited[cur*2]) {
					if(cur*2==K) {
						return time;
					}
					visited[cur*2] = true;
					q.offer(cur*2);
				}
			}
		}
		return -1;
	}

	private static boolean inRange(int i) {
		return i>=0 && i<=100000;
	}
}
