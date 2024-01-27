import java.util.*;
class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int oil[][];
    static boolean[][] visited;
    static int idx = 1;
    static int cnt;

    public int solution(int[][] land) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        oil = new int[land.length][land[0].length];
        visited = new boolean[land.length][land[0].length];
        
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, land);
                    map.put(idx, cnt);
                    idx++;
                }
                cnt = 1;
            }
            
        }
        System.out.println(Arrays.deepToString(oil));
        System.out.println(map);
        for (int i = 0; i < land[0].length; i++) {
            Set<Integer> set = new HashSet<>();
            int sum = 0;
            for (int j = 0; j < land.length; j++) {
                if (land[j][i] == 1 && !set.contains(oil[j][i])) {
                    set.add(oil[j][i]);
                    sum += map.get(oil[j][i]);
                }
            }
            answer = Math.max(answer, sum);
            System.out.println(set);
        }
        
        return answer;
    }
    
    // y: 행, x: 열
    public void bfs(int v, int m, int[][] land) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(v, m));
        visited[v][m] = true;
        oil[v][m] = idx;
        cnt = 1;
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                
                if (nx >= 0 && ny >= 0 && nx < land.length && ny < land[0].length) {
                    if (land[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        oil[nx][ny] = idx;
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