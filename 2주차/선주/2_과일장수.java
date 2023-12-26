import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer=0;
        
        if(m<=score.length){
            Arrays.sort(score);//오름차순 정렬
            for(int i =score.length-m; i>=0; i-=m){//9, 6, 3, 0
                answer += score[i]*m;
                    
                    //[0] 1  2 [3] 4  5 [6] 7  8 [9] 10 11
                    //[1, 1, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4]           
            }
        }
        else {return 0;}//이익이 발생하지 않는 경우 : m보다 length작을 때 m=3, [1, 2]
        return answer;
    }
}
