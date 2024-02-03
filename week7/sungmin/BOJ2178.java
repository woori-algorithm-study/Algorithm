package week7.sungmin;

import java.util.*;
import java.io.*;
public class BOJ2178 {
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < M; j++) {
                int x = s.charAt(j) - '0';

                map[i][j] = x;
            }
        }
        // System.out.println(Arrays.deepToString(map));
        bfs(0, 0);
        
        // System.out.println(Arrays.deepToString(map));
        System.out.println(map[N-1][M-1]);

    }

    public static void bfs(int a, int b) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(a, b));
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx==0 && ny ==0) continue;

                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 1) {
                        map[nx][ny] += map[x][y];
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
