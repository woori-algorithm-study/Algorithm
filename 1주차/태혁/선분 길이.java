import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] line = new int[201];
        
        Arrays.sort(lines, (o1, o2) -> {
    return o1[0]-o2[0];
});
        
        for(int i = 0; i < lines.length; i++){
            for(int j = lines[i][0]+100; j <= lines[i][1]+100;j++)
                line[j]++;
        }
        for(int i = 0; i < 200; i++){
            if(lines[0][1] == lines[1][0] && lines[1][1] == lines[2][0])
                return answer;
            if(line[i]>1 && line[i+1]>1)
                answer++;
        }
        return answer;
    }
}
