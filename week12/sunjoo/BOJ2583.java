import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ2583 {
    //	14396KB	140ms
    private static int M;
    private static int N;
    private static int K;
    private static int[][] paper;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken()); //세로
        N = Integer.parseInt(st.nextToken()); // 가로
        K = Integer.parseInt(st.nextToken()); // 모눈종이 위 직사각형의 개수
        paper = new int[M][N];
        int count = 0;
        for (int i = 0; i < K; i++) {

            st = new StringTokenizer(bf.readLine());

            int xs = Integer.parseInt(st.nextToken());
            int ys = Integer.parseInt(st.nextToken());

            int xe = Integer.parseInt(st.nextToken());
            int ye = Integer.parseInt(st.nextToken());

            for (int j = ys; j < ye; j++) {
                for (int k = xs; k < xe; k++) {
                    paper[j][k] = 1;
                }
            }//직사각형 채우기

        }

        List<Integer> list = new ArrayList<>(); // 각 영역의 넓이
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(paper[i][j] == 0){
                    list.add(bfs(i,j));
                    count++; // 각 영역의 개수
                }
            }
        }
        
        Collections.sort(list);
        
        System.out.println(count);
        for (Integer range: list) {
            System.out.print(range+" ");
        }

}

    private static int bfs(int x, int y) {
        int cnt = 1;
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(x);
        q.addLast(y);
        paper[x][y] = 1;
        while(!q.isEmpty()){
            int cx = q.pollFirst();
            int cy = q.pollFirst();
            for(int i = 0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(ny<0 || nx<0 || ny>=N || nx >=M || paper[nx][ny] != 0){continue;}
                    paper[nx][ny] = 1;
                    q.addLast(nx);
                    q.addLast(ny);
                    cnt++;
                }
            }
        return cnt;
    }

}
