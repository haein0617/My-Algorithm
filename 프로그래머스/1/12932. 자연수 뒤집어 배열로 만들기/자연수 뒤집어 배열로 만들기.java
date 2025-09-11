import java.util.*;

class Solution {
    public int[] solution(long n) {
        
        int cnt = 0;
        List<Long> a = new ArrayList<>();
        while (n!=0){
            a.add(n%10);
            n /= 10;
            cnt++;
        }
        
        int[] answer = new int[cnt];
        for(int i = 0; i < cnt;i++){
            answer[i] = a.get(i).intValue();
        }
        return answer;
    }
}