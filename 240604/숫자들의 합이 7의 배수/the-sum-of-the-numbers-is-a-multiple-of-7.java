import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[N+1];
        int[][] idx = new int[7][2];
        for(int i = 0; i < 7; i++){
            idx[i][0] = Integer.MAX_VALUE;
        }

        for(int i = 1; i <= N; i++){
            
            int k = sc.nextInt();

            dp[i] = (dp[i-1] + k)%7;

            idx[dp[i]][0] = Math.min(idx[dp[i]][0], i);
            idx[dp[i]][1] = Math.max(idx[dp[i]][1], i);
        }

        int ans = 0;

        for(int i = 0; i < 7; i++){
            ans = Math.max(ans, idx[i][1] - idx[i][0]);
        }
        System.out.println(ans);
    }
}