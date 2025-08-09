import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();
		a = a.replace("c=", "a");
		a = a.replace("c-", "a");
		a = a.replace("dz=", "a");
		a = a.replace("d-", "a");
		a = a.replace("lj", "a");
		a = a.replace("nj", "a");
		a = a.replace("s=", "a");
		a = a.replace("z=", "a");

		System.out.println(a.length());

	}
}