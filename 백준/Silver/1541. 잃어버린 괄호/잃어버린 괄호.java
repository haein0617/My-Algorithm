import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String[] strArr = str.split("-");
		int result = 0;
		
		String[] fir = strArr[0].split("\\+");
		for (String string : fir) {
			result += Integer.parseInt(string);
		}
		
		for (int i = 1; i < strArr.length; i++) {
			String sec = strArr[i];
			String[] strResult = sec.split("\\+"); 
			for (int j = 0; j < strResult.length; j++) {
				result-=Integer.parseInt(strResult[j]);
			}
		}
		
		
		
		System.out.println(result);
	}
}
