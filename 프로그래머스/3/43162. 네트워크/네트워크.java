import java.util.*;


class Solution {
    
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            
                if(!visited[i]){
                    visited[i] = true;
                    bfs(computers, i,n);
                    answer++;
                
            }
        }
        
        return answer;
    }
    
    static void bfs(int[][] computers, int r, int n){
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i<n; i++){
            if(computers[r][i]==1 && !visited[i]){
                q.offer(i);
            }
        }
        
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i = 0; i<n; i++){
                if(computers[cur][i]==1 && !visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
            
        }
        
    }
    
}