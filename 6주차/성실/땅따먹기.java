class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for(int i = 1; i < land.length; i++) {
            for(int j = 0; j < 4; j++) {
                int max = -1;
                
                for(int k = 0; k < 4; k++) {
                    if(j != k) max = Math.max(max, land[i-1][k]); // 같은 열이 아닌 열 중에 최대값
                }
                
                land[i][j] += max;            
            }
        }

        for(int i = 0; i < 4; i++) {
            
            answer = Math.max(answer, land[land.length-1][i]);
        }
        return answer;
    }
}
