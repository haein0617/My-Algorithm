import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
		String a = sb.readLine();
		while (!a.equals("0")) {
			boolean b = true;
			for (int i = 0; i < a.length()/2; i++) {
				if (a.charAt(i)==(a.charAt(a.length()-1-i))) {
					continue;
				} else {
					b = false;
					break;
				}
			}
			if (b) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			a=sb.readLine();
		}
	}
}