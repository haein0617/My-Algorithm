import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String a = "*";
        for(int j = N ; j>0;j--) {
        	
        	for (int i = j-1;i>0;i--) {//공백을 n-1~0까지
        		System.out.print(" ");
        	}
        	for (int i = 0; i <= N-j; i++) {
        		System.out.print("*");
        	}
        	System.out.println();
        }
    }
}