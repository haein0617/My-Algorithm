import java.util.*;

class Solution {
   public String solution(String s) {
        String answer = "";

        String[] arr;
        arr = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            int a = Integer.parseInt(arr[i]);
            max = Math.max(a,max);
            min = Math.min(a,min);
            
        }
       	
        answer =  String.valueOf(min) + " "+String.valueOf(max) ;
        
        return answer;
    }
}