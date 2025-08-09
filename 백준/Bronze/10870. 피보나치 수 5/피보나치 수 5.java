import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(fibo(n));
		
	}

	public static int fibo(int n) {
		if(n<=1) {//반환식
			return n;
		}
		else {//재귀식
			return fibo(n-1)+fibo(n-2);
		}
	}
}