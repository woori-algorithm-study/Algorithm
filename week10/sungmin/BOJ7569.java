package week10.sungmin;

// 92944KB	684ms

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class BOJ7569 {
    static StringTokenizer st;
    static int[][][] map;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int M, N, H, answer;
    static Deque<Node> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];
        q = new ArrayDeque<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        // System.out.println(Arrays.deepToString(map));

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 1) {
                        q.offerLast(new Node(i, j, k));
                    }
                }
            }
        }

        bfs();

        // System.out.println(Arrays.deepToString(map));

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    } else if (map[i][j][k] > answer) {
                        answer = map[i][j][k];
                    }
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
            int z = node.z;
    
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < H && ny < N && nz < M) {
                    if (map[nx][ny][nz] == 0) {
                        map[nx][ny][nz] = map[x][y][z] + 1;
                        q.offerLast(new Node(nx, ny, nz));
                    }
                }
            }
        }
    }

    public static class Node {
        int x;
        int y;
        int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
