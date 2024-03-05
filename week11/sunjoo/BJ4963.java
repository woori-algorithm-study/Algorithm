/*
5 4
1 0 1 0 0
1 0 0 0 0
1 0 1 0 1
1 0 0 1 0

-----------
2 0 2 0 0 
2 0 0 0 0 
2 0 1 0 1 
2 0 0 1 0 

2 0 2 0 0 
2 0 0 0 0 
2 0 2 0 1 
2 0 0 2 0 

2 0 2 0 0 
2 0 0 0 0 
2 0 2 0 2 
2 0 0 2 0 

왜 이렇게 세 번 따로 bfs 호출돼서 탐색이 될까??
*/
package codingTest.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ4963 {
    private static int w;
    private static int h;
    private static int[][] map;
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
                        for (int a = 0; a< h; a++) {
                            for (int b = 0; b < w; b++) {
                                System.out.print(map[a][b] + " ");
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
                    map[ny][nx]++;
                    q.addLast(y);
                    q.addLast(x);

                }
            }
        }
    }
}

