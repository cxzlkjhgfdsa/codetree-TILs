import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] map = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        dp[0][n-1] = map[0][n-1];

        for(int i = 0 ; i < n; i++){
            for(int j = n-1; j >= 0; j--){
                if(j - 1 >= 0){
                    if(dp[i][j-1] == 0){
                        dp[i][j-1] = dp[i][j] + map[i][j-1];
                    }else{
                        dp[i][j-1] = Math.min(dp[i][j-1], dp[i][j] + map[i][j-1]);
                    }
                }
                if(i + 1 < n){
                    if(dp[i+1][j] == 0){
                        dp[i+1][j] = dp[i][j] + map[i+1][j];
                    }else{
                        dp[i+1][j] = Math.min(dp[i+1][j] , dp[i][j] + map[i+1][j]);
                    }
                }
            }
        }

        System.out.println(dp[n-1][0]);

        

    }
}