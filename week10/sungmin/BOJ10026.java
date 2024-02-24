package week10.sungmin;

// 16492KB	164ms

import java.io.IOException;

import java.io.*;
import java.util.*;
public class BOJ10026 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] map2;
    static int N, tmp, answer1, answer2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        map2 = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';

                if (s.charAt(j)-'0' == 34 || s.charAt(j)-'0' == 23) {
                    map2[i][j] = 34;
                } else {
                    map2[i][j] = 18;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    tmp = map[i][j];
                    map[i][j] = 0;
                    bfs(i, j, tmp);
                    answer1++;
                }
                
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map2[i][j] != 0) {
                    tmp = map2[i][j];
                    map2[i][j] = 0;
                    bfs2(i, j, tmp);
                    answer2++;
                }
                
            }
        }

        System.out.println(answer1 + " " + answer2);
    }

    public static void bfs(int v, int m, int tmp) {
        Deque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(v, m));

        while (!q.isEmpty()) {
            Node node = q.pollFirst();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (map[nx][ny] == tmp) {
                        map[nx][ny] = 0;
                        q.offerLast(new Node(nx, ny));
                    }
                }
            }
        }
    }

    public static void bfs2(int v, int m, int tmp) {
        Deque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(v, m));

        while (!q.isEmpty()) {
            Node node = q.pollFirst();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (map2[nx][ny] == tmp) {
                        map2[nx][ny] = 0;
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
