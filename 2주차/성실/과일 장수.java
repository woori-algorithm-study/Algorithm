import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int count = 0;
        int[] box = new int[score.length / m];
        Arrays.sort(score);
        
        
        for(int i = score.length - m; i >= 0; i -= m) {
            box[count] = score[i];
            count++;
        }
        
        
        for(int n : box) {
            answer += n * m;
        }
        
        return answer;
    }
}
