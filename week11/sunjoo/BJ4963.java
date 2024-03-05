/*
2 2
0 1
1 0

-----------
0 2 
1 0 

0 2 
2 0 

왜 bfs가 대각선까지 탐색 안하고 종료?
*/
package codingTest.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    private static int w;
    private static int h;
     static int[][] map;
    private static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1}; //상하좌우
    private static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1}; // 좌상 우상 좌하 우하

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line;
        while(!(line = bf.readLine()).equals("0 0")){
            st =  new StringTokenizer(line);
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
                    if(map[i][j] == 1){
                        bfs(i, j);
                        cnt++;
                        System.out.println();
                        for (int k = 0; k < h; k++) {
                            for (int l = 0; l < w; l++) {
                                System.out.print(map[k][l] + " ");
                            }
                            System.out.println();
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void bfs(int y, int x) {
        Deque<Integer> q = new ArrayDeque<>();
        map[y][x]++;
        q.addLast(y);
        q.addLast(x);
        while(!q.isEmpty()){
            int cx = q.pollFirst();
            int cy = q.pollFirst();
            for(int i = 0; i<8; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(ny<0 || nx<0 || ny>=h || nx >=w){continue;}
                if(map[ny][nx] == 1){
                    System.out.println("ny = " + ny);
                    System.out.println("nx = " + nx);
                    map[ny][nx]++;
                    q.addLast(ny);
                    q.addLast(nx);

                }
            }
        }
    }
}
