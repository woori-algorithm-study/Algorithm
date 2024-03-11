package week11.sungmin;

import java.io.*;
import java.util.*;

public class BOJ11725 {
   static ArrayList<Integer> link[];
   static int[] count;
   static int N, answer;
   public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = new int[N+1];

        link = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            link[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            link[x].add(y);
            link[y].add(x);
        }

        System.out.println(Arrays.toString(link));
        count[1] = 1;
        dfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(count[i]);
        }
    }

    public static void dfs(int v) {
        for (int i : link[v]) {
            if (count[i] == 0) {
                count[i] = v;
                System.out.println("i: " + i + " " + Arrays.toString(count));
                dfs(i);
            }
        }
    }
}
