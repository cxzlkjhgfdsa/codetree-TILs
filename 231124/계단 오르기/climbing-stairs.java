import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n+2];

        dp[2] = 1;
        dp[3] = 1;
        if(n >= 4){

            for(int i = 4; i <= n; i++){
                dp[i] += dp[i-2];
                dp[i] += dp[i-3];
                dp[i] = dp[i] % 10007;
            }
        }
        
        System.out.println(dp[n]);
    }
}