import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[] dp = new long[N+1];

        for(int i = 1; i <= N; i++){
            
            int k = sc.nextInt();

            dp[i] = (dp[i-1] + k)%7;
        }

        int max = 0;

        for(int i = N; i >= 2; i--){
            for(int j = 1; j <= N; j++){
                if(i - j + 1 < max) continue;
                if(dp[i] == dp[j-1])
                    max = Math.max(max, i-j+1);
                
            }
        }

        System.out.println(max);
        
    }
}