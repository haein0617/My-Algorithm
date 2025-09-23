import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        for(int i = 0 ; i < sizes.length;i++){
            if(sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = temp;
            }
        } // 다 0번이 더 길고 1이 더 짧음.
        
        int maxW = 0;
        int maxH = 0;
        for(int i = 0; i < sizes.length; i++){
            maxW = Math.max(maxW, sizes[i][0]);
            maxH = Math.max(maxH, sizes[i][1]);
        }
        
        answer = maxW * maxH;
        
        return answer;
    }
}