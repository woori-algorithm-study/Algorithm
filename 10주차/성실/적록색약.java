import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static String[][] grid;
    static int r = 0;
    static int g = 0;
    static int rg = 0;
    static int b = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new String[N][N];

        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                grid[i][j] = str[j];
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {

                if (grid[i][j].equals("R")) {
                    checkR(i, j);
                    r++;
                }

                else if(grid[i][j].equals("G")) {
                    checkG(i, j);
                    g++;
                }

                else if(grid[i][j].equals("B")) {
                    checkB(i, j);
                    b++;
                }

            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(grid[i][j].equals("Z")) {
                    checkRG(i, j);
                    rg++;
                }
            }
        }

        int result1 = r + g + b;
        int result2 = rg + b;

        System.out.println(result1 + " " + result2);

    }

    static void checkR(int x, int y) {
        grid[x][y] = "Z";

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if(grid[nx][ny].equals("R")) checkR(nx, ny);
            }
        }
    }

    static void checkG(int x, int y) {
        grid[x][y] = "Z";

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if(grid[nx][ny].equals("G")) checkG(nx, ny);
            }
        }
    }

    static void checkB(int x, int y) {
        grid[x][y] = "C";

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if(grid[nx][ny].equals("B")) checkB(nx, ny);
            }
        }
    }

    static void checkRG(int x, int y) {
        grid[x][y] = "Y";

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if(grid[nx][ny].equals("Z")) checkRG(nx, ny);
            }
        }
    }

}
