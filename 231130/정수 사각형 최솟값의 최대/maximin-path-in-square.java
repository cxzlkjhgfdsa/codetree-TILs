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

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = map[i][j];
                }
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.max(Math.min(dp[i][j-1] , map[i][j]), Math.min(dp[i-1][j], map[i][j]));
            }
        }


        System.out.println(dp[n-1][n-1]);

    }
}