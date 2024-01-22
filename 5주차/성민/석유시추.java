import java.util.*;
class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 0;
    static int cnt;
    public int solution(int[][] land) {
        
        for (int i = 0; i < land[0].length; i++) { // 열
            boolean[][] visited = new boolean[land.length][land[0].length];
            for (int j = 0; j < land.length; j++) { // 행
                if (land[j][i] == 1 && visited[j][i] == false) {
                    // System.out.println("j " + j + " i " + i);
                    bfs(land, visited, j, i);
                    cnt++;
                    // System.out.println("cnt " + cnt);
                    // System.out.println(Arrays.deepToString(visited));
                }
            }
            answer = Math.max(answer, cnt);
            // System.out.println("다음 열!");
            cnt = 0;
        }    
        return answer;
    }
    
    public void bfs(int[][] land, boolean[][] visited, int v, int m) {
        Queue<Node> q = new LinkedList<>();
        
        visited[v][m] = true;
        q.offer(new Node(v, m));
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < land.length && ny < land[0].length) {
                    if (!visited[nx][ny] && land[nx][ny] == 1) {
                        visited[nx][ny] = true;
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