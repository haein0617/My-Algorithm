import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long a= Long.parseLong(st.nextToken());
		long b= Long.parseLong(st.nextToken());
		
		long result = bfs(a,b);
		System.out.println(result);
		
	}
	private static long bfs(long start, long end) {
		Queue<Long> q = new ArrayDeque<>();
		q.offer(start);
		
		long cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int i = 0; i < size; i++) {
				long cur = q.poll();
				if(cur == end) return cnt;
				if(cur*2<=end) {
					q.offer(cur*2);
				}
				
				String sCur = Long.toString(cur);
				long next = Long.parseLong(sCur+"1");
				if(next <= end) {
					q.offer(next);
				}
			}
		}
		
		
		return -1;
	}
}
