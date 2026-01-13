import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 색의 개수 N
        int N = Integer.parseInt(br.readLine());

        // 선택할 개수 K
        int K = Integer.parseInt(br.readLine());
        int dp[][] = new int[N+1][N+1];

        for(int i=0; i<=N; i++){
            dp[i][0] = 1;
        }
        for(int i=1; i<=N; i++){
            dp[i][1]= i;
        }
        for(int i=3; i<=N; i++){
            for(int j=2; j<=K; j++){
                dp[i][j] = (dp[i-1][j] + dp[i-2][j-1])%1000000003;
            }
        }
        long result = (dp[N-1][K] + dp[N-3][K-1]) % 1000000003;
        System.out.println(result);
    }
}
