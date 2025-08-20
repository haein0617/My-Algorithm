import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> cards = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			int card = Integer.parseInt(st.nextToken());
			if(cards.containsKey(card)) {
				cards.put(card, cards.get(card)+1);
			}else {
				cards.put(card, 1);
			}
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			int card = Integer.parseInt(st.nextToken());
			if(cards.containsKey(card)) {
				sb.append(cards.get(card));
			}else {
				sb.append(0);
			}
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}
}
