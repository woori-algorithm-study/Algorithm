import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	// 10026: 17152KB	172ms
    private static int N;
    private static char[][] RGB;
    private static boolean[][] RGB_visited;
    private static boolean[][] YB_visited;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        int RGB_cnt=0;
        int YB_cnt=0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());// 가로, 세로 크기
        RGB = new char[N][N];// 그림
        RGB_visited = new boolean[N][N]; // 적록색약 아닌 사람
        YB_visited = new boolean[N][N]; // 적록색약

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String line = st.nextToken();
            for (int j = 0; j < N; j++) {
                RGB[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!RGB_visited[i][j]){
                    RGBbfs(i,j);
                    RGB_cnt++;
                }
                if(!YB_visited[i][j]){
                    YBbfs(i, j);
                    YB_cnt++;
                }
            }
        }

        System.out.println(RGB_cnt+" "+YB_cnt);

    }

    private static void YBbfs(int y, int x) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addLast(y);
        dq.addLast(x);

        while (!dq.isEmpty()){
            int cy = dq.pollFirst();
            int cx = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int ny = cy+dy[i];
                int nx = cx+dx[i];

                if(nx<0 || ny<0 || nx>=N || ny>=N){continue;}
                if(!YB_visited[ny][nx]) {
                    if (RGB[cy][cx] == 'R' || RGB[cy][cx] == 'G') { // 적록 뭉치
                        if (RGB[ny][nx] == 'R' || RGB[ny][nx] == 'G') {
                            YB_visited[ny][nx] = true;
                            dq.addLast(ny);
                            dq.addLast(nx);
                        }

                    } else if (RGB[ny][nx] == 'B') { // 파랑 뭉치

                        YB_visited[ny][nx] = true;
                        dq.addLast(ny);
                        dq.addLast(nx);
                    }
                }
            }
        }
    }

    private static void RGBbfs(int y, int x) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addLast(y);
        dq.addLast(x);

        while (!dq.isEmpty()){
            int cy = dq.pollFirst();
            int cx = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int ny = cy+dy[i];
                int nx = cx+dx[i];

                if(nx<0 || ny<0 || nx>=N || ny>=N){continue;}
                if(!RGB_visited[ny][nx]) {
                    if (RGB[cy][cx] == 'R') { // 빨강 뭉치
                        if (RGB[ny][nx] == 'R') {
                            RGB_visited[ny][nx] = true;
                            dq.addLast(ny);
                            dq.addLast(nx);
                        }

                    } else if (RGB[cy][cx] == 'G') { // 초록 뭉치
                        if (RGB[ny][nx] == 'G') {
                            RGB_visited[ny][nx] = true;
                            dq.addLast(ny);
                            dq.addLast(nx);
                        }

                    } else { // 파랑 뭉치
                        if (RGB[ny][nx] == 'B') {
                            RGB_visited[ny][nx] = true;
                            dq.addLast(ny);
                            dq.addLast(nx);
                        }
                    }
                }
            }
        }
    }
}
