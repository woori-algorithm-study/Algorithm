import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int index = 0;
        while (index < T) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n+1];

            for (int i = 1; i < n+1; i++) {
                if (i == 1) {
                    dp[i] = 1;
                } else if (i == 2) {
                    dp[i] = 2;
                } else if (i == 3) {
                    dp[i] = 4;
                } else {
                    dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
                }
            }

            System.out.println(dp[n]);
            index++;
        }
    }
}
