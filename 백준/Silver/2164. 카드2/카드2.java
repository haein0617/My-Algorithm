import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> cards = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			cards.add(i+1);
		}
		
		for (int i = 0; i < n-1; i++) {
			cards.remove();
			cards.add(cards.poll());
		}
		System.out.println(cards.peek());
		
	}
}
