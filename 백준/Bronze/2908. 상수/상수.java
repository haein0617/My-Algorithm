import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder a = new StringBuilder(st.nextToken());
		StringBuilder b = new StringBuilder(st.nextToken());
		String ra =	a.reverse().toString();
		String rb =	b.reverse().toString();
		int rra = Integer.parseInt(ra);
		int rrb = Integer.parseInt(rb);
		
		
		System.out.print(Math.max(rra,rrb));
		

	}
}