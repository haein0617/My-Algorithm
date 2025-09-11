import java.util.*;

class Solution {
    public long[] solution(long n) {
        
        int cnt = 0;
        List<Long> a = new ArrayList<>();
        while (n!=0){
            a.add(n%10);
            n /= 10;
            cnt++;
        }
        
        long[] answer = new long[cnt];
        for(int i = 0; i < cnt;i++){
            answer[i] = a.get(i);
        }
        return answer;
    }
}