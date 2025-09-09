import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int n;
	static int[] p;
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {// 테케 시작
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			p = new int[n+1];
			makeSet();
			
			for (int i = 0; i < m; i++) {// 연산 입력
				st = new StringTokenizer(br.readLine(), " ");
				int check = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(check == 0) {
					union(a,b);
				}else if (check == 1) {
					int pA = findSet(a);
					int pB = findSet(b);
					if(pA==pB) {
						sb.append(1);
					}else if(pA != pB){
						sb.append(0);
					}
				}
				
			}//연산 끝
			sb.append("\n");
		}//테케 끝
		System.out.println(sb.toString());
		
	}
	private static void union(int a, int b) {
		int pA = findSet(a);
		int pB = findSet(b);
		
		if(pB!=pA) {
			p[pB] = pA;
		}
		
		
	}
	private static int findSet(int a) {
		if(p[a]==a) return a;
		
		return p[a] = findSet(p[a]);
	}
	
	private static void makeSet() {
		for (int i = 0; i < p.length; i++) {
			p[i]=i;
		}
	}
}
