import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Set<Integer> a = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			a.add(Integer.parseInt(br.readLine()));
		}
		Object[] arr = a.toArray();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}