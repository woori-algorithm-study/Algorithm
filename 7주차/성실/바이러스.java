import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int computer;
    static int con;
    static int[][] network;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computer = Integer.parseInt(br.readLine());
        con = Integer.parseInt(br.readLine());
        network = new int[con+1][2];
        visited = new boolean[computer+1];

        for(int i = 1; i < con+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            network[i][0] = Integer.parseInt(st.nextToken());
            network[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(1);

        for(int i = 2; i < computer+1; i++) { // 1 제외하고 세기
            if(visited[i]) count++;
        }
        System.out.println(count);

    }

    static void dfs(int x) {
        visited[x] = true;
        for(int i = 1; i < con+1; i++) {
            if(network[i][0] == x) {
                int nx = network[i][1];
                if(!visited[nx]) dfs(nx);
            } else if(network[i][1] == x) {
                int nx = network[i][0];
                if(!visited[nx]) dfs(nx);
            }
        }

    }
}
