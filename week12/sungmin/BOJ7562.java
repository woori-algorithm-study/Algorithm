package week12.sungmin;

import java.io.*;
import java.util.*;

public class BOJ7562 {
    static int dx[] = {1, 2, 2, 1, -1, -2, -2, -1};
    static int dy[] = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[][] map;
    static int T, I, answer;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());
            map = new int[I][I];

            //시작 좌표
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;

            //목표 좌표
            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            map[x2][y2] = -1;

            // System.out.println(Arrays.deepToString(map));

            bfs(x, y); // default = 0, 방문체크 = 1, 2찾기

            System.out.println(map[x2][y2]);
        }
    }

    static void bfs(int v, int m) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.offerLast(new Node(v, m));

        while (!dq.isEmpty()) {
            Node node = dq.pollFirst();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < I && ny < I) {
                    if (map[nx][ny] == -1) {
                        map[nx][ny] = map[x][y];
                        return;
                    } else if (map[nx][ny] == 0) {
                        map[nx][ny] = map[x][y] + 1;
                        dq.offerLast(new Node(nx, ny));
                    }
                }
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
