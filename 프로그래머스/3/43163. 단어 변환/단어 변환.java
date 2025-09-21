import java.util.*;

class Solution {
    static class Pair{
        String now;
        int cnt;
        public Pair(String now, int cnt){
            this.now = now;
            this.cnt = cnt;
        }
        
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        if(!Arrays.asList(words).contains(target)){
            return answer;
        }
        
        boolean[] visited = new boolean[words.length];
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(begin,0));
        
        while(!q.isEmpty()){
            Pair cur = q.poll();
            
            if (cur.now.equals(target)) {
                answer = cur.cnt;
                return answer;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && check(cur.now, words[i])) {
                    visited[i] = true;
                    q.offer(new Pair(words[i], cur.cnt + 1));
                }
            }
            
            
            
        }
        return answer;
    }
    private boolean check(String word1, String word2) {
        int diffCnt = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCnt++;
            }
        }
        return diffCnt == 1;
    }
    
    
    
}