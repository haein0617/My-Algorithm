import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] queue = new int[n];
		int front = -1; //데이터 삭제 위치
		int rear = -1; //데이터 삽입 위치
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String a = st.nextToken();
			if(!a.equals("push")) {
				
				if(a.equals("front")) {//맨 앞에 있는 정수가 뭔지
					if(front==rear) {
						sb.append(-1).append("\n");
					}else {
						sb.append(queue[front+1]).append("\n");
					}
				}else if(a.equals("size")) {//사이즈가 몇인지
					sb.append(rear - front).append("\n");

				}else if(a.equals("empty")) { //비어 있는지
					if(front==rear) {
						sb.append(1).append("\n");
					}else {
						sb.append(0).append("\n");
					}
				}else if(a.equals("back")) {
					if(rear==front) {
						sb.append(-1).append("\n");
					}else {
						sb.append(queue[rear]).append("\n");
					}
				}else if (a.equals("pop")) {
					if(front==rear) {
						sb.append(-1).append("\n");
					}else {
						sb.append(queue[++front]).append("\n");
					}
				}
			}else if(a.equals("push")) {
				int b = Integer.parseInt(st.nextToken());
				queue[++rear]=b;
			}
			
		}
		System.out.println(sb);
	}
}
