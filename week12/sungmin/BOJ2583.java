package week12.sungmin;

// 	14664KB	140ms

import java.io.*;
import java.util.*;

public class BOJ2583 {
    static StringTokenizer st;
    static int M, N, K, answer;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //행
        N = Integer.parseInt(st.nextToken()); //열
        K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        List<Integer> list = new ArrayList<>();

        for (int t = 0; t < K; t++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    map[i][j] = 1;
                }
            }
        }
        // System.out.println(Arrays.deepToString(map));
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    bfs(i, j);
                    list.add(answer);
                    answer = 0;
                }
            }
        }
        
        list.sort((o1, o2) -> o1 - o2);
        for (int x : list) {
            bw.append(x+"").append(" ");
        }
        System.out.println(list.size());
        bw.flush();
        bw.close();
    }

    public static void bfs(int v, int m) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.offerLast(new Node(v, m));
        map[v][m] = 1;
        answer = 1;

        while (!dq.isEmpty()) {
            Node node = dq.pollFirst();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        answer++;
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
