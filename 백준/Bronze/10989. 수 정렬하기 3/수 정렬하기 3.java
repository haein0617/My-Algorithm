import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 빠른 입력을 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 2. 수의 범위(1 ~ 10000)를 인덱스로 하는 카운팅 배열 선언
        //    모든 값은 0으로 자동 초기화됩니다.
        int[] counts = new int[10001];

        // 3. N번 반복하며 숫자를 입력받고, 해당 숫자의 인덱스 값을 1 증가
        //    (예: 숫자 5가 들어오면 counts[5]의 값이 1 늘어남)
        for (int i = 0; i < n; i++) {
            counts[Integer.parseInt(br.readLine())]++;
        }

        // 입력 스트림 닫기
        br.close();

        // 4. 빠른 출력을 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();

        // 5. 카운팅 배열을 1부터 순회
        for (int i = 1; i < 10001; i++) {
            // 6. 해당 인덱스에 저장된 횟수(counts[i])만큼 반복하며
            //    인덱스 번호(i)를 StringBuilder에 추가
            while (counts[i] > 0) {
                sb.append(i).append('\n');
                counts[i]--; // 출력했으니 카운트 1 감소
            }
        }

        // 7. StringBuilder에 쌓인 내용을 한 번에 출력
        System.out.println(sb);
    }
}