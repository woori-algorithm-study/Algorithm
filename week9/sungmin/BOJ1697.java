package week9.sungmin;

import java.io.*;
import java.util.*;

public class BOJ1697 {
    static int K, N;
    static int[] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cnt = new int[100001];
        bfs(N);

        System.out.println(cnt[K]);
    }

    static void bfs(int v) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(v);

        while (!dq.isEmpty()) {
            int x = dq.pollFirst(); // 5

            if (x == K) {
                break;
            }

            if (x >= 0 && cnt[x-1] == 0) {
                dq.offerLast(x-1);
                cnt[x-1] = cnt[x] + 1;
            }

            if (x >= 0 && cnt[x+1] == 0) {
                dq.offerLast(x+1);
                cnt[x+1] = cnt[x] + 1;
            }

            if (x >= 0 && cnt[x*2] == 0) {
                dq.offerLast(x*2);
                cnt[x*2] = cnt[x] + 1;
            }
        }
    }
}
