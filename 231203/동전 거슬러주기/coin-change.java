import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] coins = new int[N];
        int[] dp = new int[20001];

        Arrays.fill(dp, 10000);

        for(int i = 0; i < N; i++){
            coins[i]  = sc.nextInt();
        }

        dp[0] = 0;

        for(int i = 0; i <= 10000; i++){
            for(int j : coins){
                dp[i+j] = Math.min(dp[i+j] , dp[i] + 1);
            }
        }

        if(dp[M] == 10000){
            System.out.println(-1);
        }else{
            System.out.println(dp[M]);
        }


    }
}