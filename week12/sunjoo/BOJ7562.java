import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ7562{
    // 	40052KB	340ms
    private static int l;
    private static int[][] visited;
    private static int[] dx = {-1, 1, -1, 1, -2, -2, 2, 2};
    private static int[] dy = {-2, -2, 2, 2, -1, 1, -1, 1};
    private static Night to;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t<T; t++){
            st = new StringTokenizer(bf.readLine());
            l = Integer.parseInt(st.nextToken()); // 체스판의 크기
            visited = new int[l][l];
            st = new StringTokenizer(bf.readLine());
            Night now = new Night(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // 현재 나이트가 있는 칸

            st = new StringTokenizer(bf.readLine());
            to = new Night(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // 나이트가 이동하려고 하는 칸
            System.out.println(bfs(now.x, now.y));
        }


    }

    private static int bfs(int x, int y) {
        if(x == to.x && y == to.y)return 0;
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(y);
        q.addLast(x);
        visited[y][x] = 1;
        while(!q.isEmpty()){
            int cy = q.pollFirst();
            int cx = q.pollFirst();
            for(int i = 0; i<8; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(ny<0 || nx<0 || ny>=l || nx >=l || visited[ny][nx] != 0 ){continue;} //방문하지 않았을 때만 이동해야 경로 루프에 빠지지 않고 최단 거리를 찾을 수 있다.
                    visited[ny][nx] = visited[cy][cx]+1;
                    if(ny == to.y && nx == to.x) return visited[ny][nx]-1; //움직이기 시작한 자리부터 (0based)
                    q.addLast(ny);
                    q.addLast(nx);
                }
            }
        return 0;
    }

    private static class Night {
        int x;
        int y;
        public Night(int x, int y) {
            this.x = x;
            this.y=  y;
        }
    }

}
