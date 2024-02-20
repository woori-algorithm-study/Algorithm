// 14388 KB	136 

package week8.sungmin;

import java.util.*;
import java.io.*;
public class BOJ2667 {
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer, N, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        // System.out.println(Arrays.deepToString(map));
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                    cnt = 1;
                    bfs(i, j);
                    answer++;
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        System.out.println(answer);
        for (int x : list) {
            System.out.println(x);
        }

    }

    public static void bfs(int v, int m) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(v, m));
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (map[nx][ny] == 1) {
                        map[nx][ny] = 0;
                        cnt++;
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
            this. y = y;
        }
    }
}
