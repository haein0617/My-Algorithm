class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] arr;
        arr = s.toCharArray();
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '('){
                cnt++;
            }else if(arr[i] == ')'){
                cnt--;
            }
            
            if(cnt<0){
                answer = false;
                break;
            }
        }
        
        if(cnt != 0){
            answer = false;
        }
        
        
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}