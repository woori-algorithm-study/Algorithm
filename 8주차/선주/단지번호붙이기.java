import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//2667: 14204KB 144ms
public class Main {

    public static int N;
    public static int[][] land;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());// 지도의 크기
        land = new int[N][N];

        for(int i=0; i<N; i++){
            String line = bf.readLine();
            for(int j =0; j<N; j++){
                land[i][j] = line.charAt(j)-48;
            }
        }

        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                //System.out.print(land[y][x]);
                if(land[y][x] == 0) continue; // 이미 방문했거나, 집이 없는 곳이라면 탐색 안함.
                list.add(bfs(new Block(y,x)));
            }
            //System.out.println();
        }


        System.out.println(list.size());// 총 단지수 출력
        Collections.sort(list);
        for(Integer l : list){
            System.out.println(l);// 단지 내 집의 수를 오름차순으로 출력
        }
    }
    //사방으로 이웃한 집만 방문하는 bfs (단지를 하나만 탐색)
    public static int bfs(Block start) {
        int cnt = 0;
        Queue<Block> q = new LinkedList<>();
        q.offer(start);
        land[start.y][start.x] = 0;//방문
        while(!q.isEmpty()){
            Block b = q.poll();
            cnt++;
            for(int i = 0; i<4; i++){
                int ny = b.y+dy[i];
                int nx = b.x+dx[i];

                if(ny<0 || nx<0 || ny>=N || nx>=N){continue;} //배열 범위 바깥 처리

                if(land[ny][nx] == 1){ // 집 있고, 방문하지 않은 칸이면
                    Block bb = new Block(ny, nx);
                    q.offer(bb);
                    land[ny][nx] = 0;//방문
                }

            }
        }
        return cnt;
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
