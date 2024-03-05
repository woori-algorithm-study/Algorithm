import java.util.Scanner;

public class Main {

    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int result; // 결과
    static int w; // 너비, j
    static  int h; // 높이, i
    static int[][] map; // 지도

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            result = 0;

            w = sc.nextInt();
            h = sc.nextInt();
            map = new int[h][w];

            if (w == 0 & h == 0) break; // 0 0 나오면 종료

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(map[i][j] == 1) {
                        dfs(i, j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }

    }

    static void dfs(int x, int y) {
        map[x][y] = 0;

        for(int i=0; i<8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX>=0 && nextX < h && nextY>=0 && nextY < w) {
                if(map[nextX][nextY] == 1) {
                    dfs(nextX, nextY);
                }
            }
        }

        
    }
}
