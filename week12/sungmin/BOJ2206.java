package week12.sungmin;
// 108996KB	732ms

import java.io.*;
import java.util.*;
public class BOJ2206 {
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];
        //visited[N][M][0] 은 벽을 부수지 않고 탐색하는 경우
        //visited[N][M][1] 은 벽을 하나 부수고 탐색한 경우
        
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        
        if (N == 1 && M == 1) {
            System.out.println(1);
            System.exit(0);
        }

        bfs();
        if (answer > 0) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
    //길인경우
        //아직 벽을 부순적 없다 -> visited[N][M][0] = true 로 방문처리 + Queue 에 offer
        //이미 벽을 부순 경우   -> visited[N][M][1] = true 로 방문처리 + Queue 에 offer
    
    //벽을 부순적 없는 상태에서 벽을 만날 경우만 체크
    //벽인경우
        //아직 벽을 부순적 없는 경우 -> 벽을 부수고 -> visited[N][M][1] = true 로 방문처리 + Queue 에 offer
        //이미 벽을 부순 경우 -> 아무것도 할 수 없으므로 통과

    public static void bfs() {
        Deque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(0, 0, 0, 1));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node node = q.pollFirst();
            int x = node.x;
            int y = node.y;
            int z = node.z;
            int dist = node.dist;

            if (x == N-1 && y == M-1) {
                answer = dist;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {

                    if (map[nx][ny] == 0) { //길인 경우
                        if (!visited[nx][ny][z]) { //벽은 부순적 있든 없든 이동하고 방문처리
                            visited[nx][ny][z] = true;
                            q.offerLast(new Node(nx, ny, z, dist+1));
                        }
                        
                    } else { //벽인경우
                        if (z == 0) {
                            if (!visited[nx][ny][z]) { //아직 벽을 부순적 없을 때만 돌아야 함
                                visited[nx][ny][z] = true;
                                q.offerLast(new Node(nx, ny, 1, dist+1)); //벽을 부쉈으니 z = 1(벽을 부순 상태)로 변경
                            }
                        }
                    }
                }

            }

        }
    }

    public static class Node {
        int x;
        int y;
        int z;
        int dist;

        public Node (int x, int y, int z, int dist) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.dist = dist;
        }
    }
}