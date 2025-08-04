import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
        int v = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
			if(arr[i]==v) {
				cnt++;
			}
		}
        System.out.println(cnt);
    }
}