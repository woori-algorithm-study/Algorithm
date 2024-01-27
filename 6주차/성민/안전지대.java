// 1. 2중for문을 돌며 폭탄(1)을 찾는다.
// 2. 폭탄을 발견하면 bfs탐색을 돌며 cnt++
// 2-1. bfs탐색(상, 하, 좌, 우, 대각선4개)을 돌며 2로 주변을 채우고 초기값을 기준으로 반복
// 3. 전체 넓이 - cnt
import java.util.*;
class Solution {
    static int[] dx = {-1, 1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
    static int cnt = 0;
    public int solution(int[][] board) {
        int answer = 0;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    bfs(i, j, board);
                }
            }
        }
        // System.out.println(cnt);
        // System.out.println(Arrays.deepToString(board));
        answer = (board.length * board[0].length) - cnt;
        // System.out.println("ss: " + board.length * board[0].length);
        return answer;
    }
    
    public void bfs(int v, int m, int[][] board) {
        Queue<Node> q = new LinkedList<>();
        board[v][m] = 2;
        cnt++;
        q.offer(new Node(v, m));
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length) {
                    if (board[nx][ny] == 0) {
                        board[nx][ny] = 2;
                        cnt++;
                        q.offer(new Node(v, m));
                    }
                }
            }
        }
    }
    
    class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}