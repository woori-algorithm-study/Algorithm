import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ4963 {
    // 15776KB	168ms
    private static int w;
    private static int h;
    private static int[][] map;
    private static final int[] dx = {0, 0, -1, 1, -1, 1, -1, 1}; // 상하좌우 및 대각선 방향
    private static final int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1}; // 상하좌우 및 대각선 방향

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line;
        while (!(line = bf.readLine()).equals("0 0")) {
            st = new StringTokenizer(line);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void bfs(int x, int y) {
        Deque<Integer> q = new ArrayDeque<>();
        map[x][y] = 0; // 방문한 곳 표시
        q.addLast(x);
        q.addLast(y);
        while (!q.isEmpty()) {
            int cx = q.pollFirst();
            int cy = q.pollFirst();
            for (int i = 0; i < 8; i++) { // 상하좌우 및 대각선 방향으로 이동
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                // 배열 범위를 벗어나거나, 땅이 아니라면 스킵
                if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] != 1) continue;
                    map[nx][ny] = 0; // 방문한 곳 표시
                    q.addLast(nx);
                    q.addLast(ny);
            }
        }
    }
}
