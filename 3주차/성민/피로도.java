import java.util.*;
class Solution {
    static boolean[] visited;
    static int answer;
    public int solution(int k, int[][] dun) {
        answer = 0;
        visited = new boolean[dun.length];
        dfs(k, dun, 0);
        
        return answer;
    }
    
    public void dfs(int k, int[][] dun, int cnt) {
        
        for (int i = 0; i < dun.length; i++) {
            if (k >= dun[i][0] && !visited[i]) {
                visited[i] = true;
                dfs(k - dun[i][1], dun, cnt+1);
                visited[i] = false;
            }
        }
        // System.out.println(Arrays.toString(visited));
        answer = Math.max(cnt, answer);
    }
}