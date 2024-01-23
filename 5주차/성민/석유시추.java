import java.util.*;
class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 0;
    static int idx = 2;
    static int cnt;
    
    public int solution(int[][] land) {
        
        for (int i = 0; i < land[0].length; i++) { // 열
            idx++;
            for (int j = 0; j < land.length; j++) { // 행
                if (land[j][i] < idx && land[j][i] > 0) {
                    bfs(land, j, i, idx);
                    cnt++;
                }
            }
            
            answer = Math.max(answer, cnt);
            cnt = 0;
        }    
        return answer;
    }
    
    public void bfs(int[][] land, int v, int m, int idx) {
        Queue<Node> q = new LinkedList<>();
        land[v][m] = idx;
        
        q.offer(new Node(v, m));
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < land.length && ny < land[0].length) {
                    if (land[nx][ny] < idx && land[nx][ny] > 0) {
                        land[nx][ny] = idx;
                        cnt++;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }
    }
    
    public class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}