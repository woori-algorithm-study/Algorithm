import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ11725 {
    static int N;
    static int[] parents;
    static ArrayList<Integer> tree[];
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        parents = new int[N+1];

        tree = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        visited = new boolean[N+1];

        // set tree
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        parents[1] =1;
        dfs(1);

        for (int i = 2; i < N+1; i++) {
            bw.append(parents[i] + "").append("\n");
        }

        bw.flush();
        bw.close();
    }

    public static void dfs(int x) throws Exception{

        for (int i : tree[x]){
            if (parents[i] == 0) {
                parents[i] = x; // i의 부모는 x
                dfs(i);
            }
        }
    }
}
