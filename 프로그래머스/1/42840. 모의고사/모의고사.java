class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] po1 = {1,2,3,4,5};
        int[] po2 = {2,1,2,3,2,4,2,5};
        int[] po3 = {3,3,1,1,2,2,4,4,5,5};
        int max = 0;
        
        int[] count = new int[4];
        for(int i = 0; i < answers.length;i++){ 
            if(po1[i%5]==answers[i]){
                count[1]++;
            }
        }
        max = Math.max(count[1],max);
        int count2 = 0;
        for(int i = 0; i < answers.length;i++){ 
            if(po2[i%8]==answers[i]){
                count[2]++;
            }
        }
        max = Math.max(count[2],max);
        int count3 = 0;
        for(int i = 0; i < answers.length;i++){ 
            if(po3[i%10]==answers[i]){
                count[3]++;
            }
        }
        max = Math.max(count[3],max);
        
        int maxCnt = 0;
        int[] pointer = new int[4];
        for(int i = 1; i<4; i++){
            if(count[i]==max){
                maxCnt++;
                pointer[i]=i;
            }            
        }
        answer = new int[maxCnt];
        int j = 0;
        for(int i = 0; i < 4;i++){
            if(pointer[i]!=0){
                answer[j] = pointer[i];
                j++;
            }
        }
        
        
        return answer;
    }
}