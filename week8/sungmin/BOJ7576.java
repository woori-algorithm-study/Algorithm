// 102788KB	636ms

package week8.sungmin;

import java.io.*;
import java.util.*;
public class BOJ7576 {
    static StringTokenizer st;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M, answer;
    static Deque<Node> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    q.offerLast(new Node(i, j));
                }
            }
        }
        bfs();
        // System.out.println(Arrays.deepToString(map));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                } else if (answer < map[i][j]){
                    answer = map[i][j];
                }
            }
        }
        System.out.println(answer-1);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Node node = q.pollFirst();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = map[x][y] + 1;
                        q.offerLast(new Node(nx, ny));
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
