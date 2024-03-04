package week11.sungmin;

// 16092KB	172ms

import java.io.*;
import java.util.*;

public class BOJ4963 {
    static StringTokenizer st;
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
    static int[][] map;
    static int w, h, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken()); // 열
            h = Integer.parseInt(st.nextToken()); // 행
            if (w == 0 && h == 0) break;
            map = new int[h][w];
            answer = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        map[i][j] = 0;
                        bfs(i, j);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    public static void bfs(int v, int m) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.offerLast(new Node(v, m));
        
        while (!dq.isEmpty()) {
            Node node = dq.pollFirst();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                    if (map[nx][ny] == 1) {
                        map[nx][ny] = 0;
                        dq.offerLast(new Node(nx, ny));
                    }
                }
            }
        }
    }

    public static class Node {
        int x;
        int y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
