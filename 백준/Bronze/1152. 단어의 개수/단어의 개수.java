import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 몇 개의 단어로 이루어진 문자열일까?
		 * 그냥 공백 수 + 1 해보자
		 */
		String a = sc.nextLine();
		String trim = a.trim();
		if(trim.isEmpty()) {
			System.out.println(0);
		}else {
			String[] words = trim.split(" ");
			System.out.println(words.length);
		}
	}
}