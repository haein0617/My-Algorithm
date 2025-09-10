import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int n, x, y;

	static class Node implements Comparable<Node> {
		int to;
		double cost;

		public Node(int to, double cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Double.compare(this.cost, o.cost);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {// 테케 시작
			n = Integer.parseInt(br.readLine());

			int[] r = new int[n];
			int[] c = new int[n];

			StringTokenizer stX = new StringTokenizer(br.readLine(), " ");
			StringTokenizer stY = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				r[i] = Integer.parseInt(stX.nextToken());
				c[i] = Integer.parseInt(stY.nextToken());
			}

			double E = Double.parseDouble(br.readLine()); // 세율

			boolean[] visited = new boolean[n];
			PriorityQueue<Node> pq = new PriorityQueue<>();

			double totalCost = 0;
			int count = 0;

			pq.offer(new Node(0, 0));

			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				int curVertex = cur.to;
				double cost = cur.cost;

				if (visited[curVertex]) {
					continue;
				}

				visited[curVertex] = true;
				totalCost += cost;
				count++;

				if (count == n)
					break;

				for (int nextVertex = 0; nextVertex < n; nextVertex++) {
					// 아직 방문하지 않은 정점이라면
					if (!visited[nextVertex]) {
						// 거리의 제곱(L^2) 계산. 오버플로우 방지를 위해 long 사용
						long dx = (long) r[curVertex] - r[nextVertex];
						long dy = (long) c[curVertex] - c[nextVertex];

						// 환경 부담금 계산 (E * L^2)
						double edgeCost = (dx * dx + dy * dy) * E;

						// 계산된 간선 정보를 우선순위 큐에 추가
						pq.offer(new Node(nextVertex, edgeCost));
					}
				}

			}
			long finalAnswer = Math.round(totalCost);
            sb.append("#").append(tc).append(" ").append(finalAnswer).append("\n");

		} // 테케 끝
		System.out.println(sb.toString());
	}
}
