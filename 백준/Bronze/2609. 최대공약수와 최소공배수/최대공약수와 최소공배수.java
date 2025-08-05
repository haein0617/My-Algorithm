import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(sb.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int max = Integer.MIN_VALUE;
		if(a>=b) {
			max = gcd(a,b);
		}else {
			max = gcd(b,a);
		}
		
		System.out.println(max);
		System.out.println((a*b)/max);
	}
	
	public static int gcd(int a, int b) { //유클리드 호제법
	    while (b != 0) {
	        int temp = a % b;
	        a = b;
	        b = temp;
	    }
	    return a;
	}
	
	
}