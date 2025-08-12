import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine()); // 26입력
		int s = 0;
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String a = st.nextToken();
			
			
			if(a.equals("all")) {
				s = (1<<20) -1;
			}else if (a.equals("empty")) {
				s = 0;
			}else {
				int b = Integer.parseInt(st.nextToken());
				if (a.equals("add")) {
					s = s | (1 << (b - 1));
				} else if (a.equals("check")) {
					if ((s & (1 << (b - 1))) != 0) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
				} else if (a.equals("remove")) {
					s = s & ~(1 << (b - 1));
				}else if(a.equals("toggle")) {
					s = s ^ (1 << (b-1));
				} 
			}
		}
		System.out.println(sb);

	}// 메인 끝

}
