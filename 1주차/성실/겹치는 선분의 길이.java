class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] result = new int[200];
        
        for(int i=0; i<3; i++) {
            int a = lines[i][0];
            int b = lines[i][1];
            
            a += 100;
            b += 100;
            
            if (b-1 == a) {
                result[a] += 1;
            } else {
                for(int j=a; j<b; j++) {
                    result[j] += 1;
                }
            }
        }
        
        for (int i : result) {
            if (i >= 2) {
                answer += 1; 
            }
        }
        
        return answer;
    }
}
