import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  //7569 : 77068KB	708ms
    private static int N;
    private static int M;
    private static int H;
    private static int[][][] Box;

    private static int[] dx = {0, 0, -1, 1, 0, 0}; //상하좌우(2D) + 위아래(3D)
    private static int[] dy = {-1, 1, 0, 0, 0, 0};
    private static int[] dz = {0, 0, 0, 0, -1, 1};
    private static Deque<Integer> dq;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        // 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
        M = Integer.parseInt(st.nextToken());// 가로
        N = Integer.parseInt(st.nextToken());// 세로
        H = Integer.parseInt(st.nextToken());// 높이
        Box = new int[H][N][M];


        for (int i = 0; i<H; i++) {
            for(int j = 0; j<N; j++){
            st = new StringTokenizer(bf.readLine());
                for (int k = 0; k < M; k++) {
                    int cell = Integer.parseInt(st.nextToken());
                    Box[i][j][k] = cell;
                }
            }
        }
        dq = new ArrayDeque<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (Box[i][j][k] == 1) {
                        dq.addLast(i);
                        dq.addLast(j);
                        dq.addLast(k);
                    }
                }
            }
        }
        bfs();
        int maxDate = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(Box[i][j][k] == 0){
                        System.out.println(-1); return;
                    }
                    if(maxDate< Box[i][j][k]){maxDate = Box[i][j][k];}
                }

            }
        }
        System.out.println(maxDate-1);



    }

    private static void bfs() {

        while (!dq.isEmpty()) {
            int bz = dq.pollFirst();
            int by = dq.pollFirst();
            int bx = dq.pollFirst();
            for (int i = 0; i < 6; i++) {
                int nz = bz + dz[i];
                int ny = by + dy[i];
                int nx = bx + dx[i];

                if (nz < 0 || nx < 0 || ny < 0 || nz >= H|| nx >= M || ny >= N) {continue;}
                if(Box[nz][ny][nx] == 0){
                    Box[nz][ny][nx] = Box[bz][by][bx] + 1;
                    dq.addLast(nz);
                    dq.addLast(ny);
                    dq.addLast(nx);
                }
                
            }
        }
    }
}
