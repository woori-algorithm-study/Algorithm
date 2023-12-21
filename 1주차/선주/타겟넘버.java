/*풀이중*/

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
       int len = numbers.length;
        //음수배열
        int[] umms= new int[len];
        for(int i=0; i<len; i++){
            umms[i]= -numbers[i];
        }
    
        return answer;
    }
}
