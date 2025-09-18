import java.util.*;


class Solution {
    static class Pair{
    int r,c;
    Pair(int r, int c){
        this.r = r;
        this.c = c;
    }
}   
    
    
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited;
    static int n,m;
    public int solution(int[][] maps) {
        int answer = 1;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(0,0));
        visited[0][0] = true;
       
        while(!q.isEmpty()){
            
            answer++;
            int size = q.size();
            for(int j = 0; j<size;j++){
                Pair cur = q.poll();
            
                for(int i = 0; i<4; i++){
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];
                
                    if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && maps[nr][nc]==1){
                        visited[nr][nc] = true;
                        maps[nr][nc] = answer;
                        q.offer(new Pair(nr,nc));
                    }
                }
            }
            
            
            
}
        if(!visited[n-1][m-1]){
                answer = -1;
            }else{
                answer = maps[n-1][m-1];
            }
        
        return answer;
    }
    
}