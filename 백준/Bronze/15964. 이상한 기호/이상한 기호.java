import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong(); // 입력값이 클 수 있으므로 long 사용
        long b = sc.nextLong();
        
        long result = (a + b) * (a - b);
        System.out.println(result);
    }
}