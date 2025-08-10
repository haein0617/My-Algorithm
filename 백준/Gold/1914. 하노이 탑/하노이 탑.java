import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if (n <= 20) {
			sb.append((1 << n) - 1).append("\n");
			hanoi2(n, 1, 2, 3);
			System.out.println(sb.toString());
		}else {
			// 1. BigInteger 객체 생성
	        // BigInteger.valueOf()를 사용해 정수 2를 BigInteger 객체로 변환합니다.
	        BigInteger base = BigInteger.valueOf(2);

	        // 2. n 제곱 계산
	        // pow(n) 메소드를 사용해 2의 n제곱을 계산합니다.
	        BigInteger result = base.pow(n);

	        // 3. 1 빼기
	        // subtract() 메소드를 사용해 1을 뺍니다.
	        // BigInteger.valueOf(1)을 사용해 정수 1을 객체로 만들어야 합니다.
	        BigInteger finalResult = result.subtract(BigInteger.valueOf(1));

	        // 결과 출력
	        System.out.println(finalResult);
		}
	}

	public static void hanoi2(int n, int a, int b, int c) {
		if (n == 1) {
			sb.append(a).append(" ").append(c).append("\n");
		} else {
			hanoi2(n - 1, a, c, b);
			sb.append(a).append(" ").append(c).append("\n");
			hanoi2(n - 1, b, a, c);
		}
	}
}