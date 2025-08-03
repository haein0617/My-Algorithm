import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 음 (이거랑 )이거 개수가 똑같으면 yes 아니면 no하면 될듯?
		// 예제 돌려보니까 그러면 안되네. 개수는 같은데 아예 반대 방향일수도 있으니까.
		// 그럼 뭐로 해야하지..?
		// 아 ( 나오면 무조건 ) 나와야되니까 (나오면 +하고 )나오면 -하고 0되면 YES
		int t = sc.nextInt(); // testcase
		for (int i = 0; i < t; i++) {
			String vps = sc.next();
			int counter = 0;

			for (int j = 0; j < vps.length(); j++) {
				char c = vps.charAt(j);
				if (c == '(') {
					counter++;
				} else if (c == ')') {
					counter--;
				}
				if(counter<0) {
					break;
				}
			}
			if (counter == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
