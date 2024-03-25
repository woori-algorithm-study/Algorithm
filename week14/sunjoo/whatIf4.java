import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class whatIf4 { // 만약 1,2,3,4를 이용해서 숫자 N이 되도록하는 문제라면? (4가 추가되었다.)
    private static int T, N;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            dp = new int[N+1];

            for (int j = 1; j <= N; j++) {
                if(j==1){
                    dp[j] = 1; // 1
                }else if (j==2) {
                    dp[j] = 2; // 1+1 , 1+1
                }else if (j==3) {
                    dp[j] = 4; // 111 12 21 3
                } else if (j==4) {
                    dp[j] = 8; // 1111 112 121 211 22 31 13 4
                } else{
                    dp[j] = dp[j-1] + dp[j-2] + dp[j-3] + dp[j-4];
                }
            }
            System.out.println(dp[N]);
        }
    }
}
