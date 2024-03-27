import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1149 {
    //14528KB 136ms
    private static int[][] costs;
    private static int[][] dp; // [n번째 집]이 [무슨색]으로 칠해졌을 때 드는 최소 비용

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int N = Integer.parseInt(br.readLine());
        costs = new int[N + 1][3];
        // cost[i][0] = i번째 집을 빨강으로 칠할 때 드는 비용
        // cost[i][1] = i번째 집을 초록으로 칠할 때 드는 비용
        // cost[i][2] = i번째 집을 파랑으로 칠할 때 드는 비용

        dp = new int[N+1][3];
        // dp[j][0] = 이전 집이 빨강으로 칠해졌을 때 j번째 집을 칠하는데 드는 최소 비용
        // dp[j][1] = 이전 집이 초록으로 칠해졌을 때 j번째 집을 칠하는데 드는 최소 비용
        // dp[j][2] = 이전 집이 파랑으로 칠해졌을 때 j번째 집을 칠하는데 드는 최소 비용
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            costs[i][0] = Integer.parseInt(st.nextToken());
            costs[i][1] = Integer.parseInt(st.nextToken());
            costs[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            if(i == 1){
                dp[1][0] = costs[1][0]; // 1번째 집 빨강으로 칠함
                dp[1][1] = costs[1][1]; // 1번째 집 초록으로 칠함
                dp[1][2] = costs[1][2]; // 1번째 집 파랑으로 칠함
            }/* else if (i == 2) {
                dp[2][0] = Math.min(dp[1][1], dp[1][2]) +  costs[2][0]; // 2번째 집 빨강으로 칠함 = 전 집이 초록으로 칠하거나 파랑으로 칠했음.
                dp[2][1] = Math.min(dp[1][0], dp[1][2]) +  costs[2][1]; // 2번째 집 초록으로 칠함 = 전 집이 빨강으로 칠하거나 파랑으로 칠했음.
                dp[2][2] = Math.min(dp[1][0], dp[1][1]) +  costs[2][2]; // 2번째 집 파랑으로 칠함 = 전 집이 빨강으로 칠하거나 초록으로 칠했음.
            }*/else{
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) +  costs[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) +  costs[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) +  costs[i][2];
            }
        }
        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
    }
}
