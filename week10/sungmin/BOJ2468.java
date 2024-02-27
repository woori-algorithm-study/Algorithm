package week10.sungmin;

// 	37692KB	344ms

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class BOJ2468 {
    static int N, answer, cnt, max;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (max < map[i][j]) {
                    max = map[i][j];
                }
            }
        }
        // System.out.println(max);
        // System.out.println(Arrays.deepToString(map));

        for (int t = max; t >= 1; t--) {
            visited = new boolean[N][N];
            cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] >= max && !visited[i][j]) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            max--;
            // System.out.println("cnt: " + cnt);
            if (answer < cnt) {
                answer = cnt;
            }
        }

        System.out.println(answer);
    }

    public static void bfs(int v, int m) {
        Deque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(v, m));
        visited[v][m] = true;

        while(!q.isEmpty()) {
            Node node = q.pollFirst();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (map[nx][ny] >= max && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offerLast(new Node(nx, ny));
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
