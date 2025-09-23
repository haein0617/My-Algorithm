import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0 ; i < commands.length; i ++) {
            int from = commands[i][0];
            int to = commands[i][1];
            int target = commands[i][2];
            int[] newArr = new int[to-from+1];
            int pointer = 0;
            for(int j = from - 1;j<to;j++){
                newArr[pointer] = array[j];
                pointer++;
            }
            Arrays.sort(newArr);
            answer[i] = newArr[target-1];
            
        }
        
        
        return answer;
    }
}