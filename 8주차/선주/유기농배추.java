import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int T;
    public static int N;
    public static int M;
    public static int K;
    public static int[][] land;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());// 테스트 케이스
        for(int t =0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            M = Integer.parseInt(st.nextToken());// 가로 길이
            N = Integer.parseInt(st.nextToken());// 세로 길이
            K = Integer.parseInt(st.nextToken()); // 배추 개수

            land = new int[N][M];
            for (int i = 0; i < K; i++) {// 배추 심기
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                land[y][x] = 1;
            }

            //입력 확인용
            //System.out.println("-----------");
            int answer = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    //System.out.print(land[y][x]);
                    if (land[y][x] == 1) {
                        // 이미 방문했거나, 배추 없는 곳이라면 탐색 안함.
                        bfs(new Block(y, x));
                        answer++;
                    }
                }
                //System.out.println();
            }
            System.out.println(answer);
        }
    }
    //사방으로 이웃한 배추들만 방문하는 bfs
    public static void bfs(Block start) {
        Queue<Block> q = new LinkedList<>();
        q.offer(start);
        land[start.y][start.x] = 0;//방문
        while(!q.isEmpty()){
            Block b = q.poll();
            for(int i = 0; i<4; i++){
                int ny = b.y+dy[i];
                int nx = b.x+dx[i];

                if(ny<0 || nx<0 || ny>=N || nx>=M){continue;} //배열 범위 바깥 처리

                if(land[ny][nx] == 1){ // 배추 있고, 방문하지 않은 칸이면
                    Block bb = new Block(ny, nx);
                    q.offer(bb);
                    land[ny][nx] = 0;//방문
                }

            }
        }
    }


    public static class Block{
        int x;
        int y;
        Block(int y, int x){
            this.x=x;
            this.y=y;
        }
    }
}
