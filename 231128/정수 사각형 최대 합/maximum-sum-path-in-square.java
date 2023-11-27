import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        dp[0][0] = map[0][0];

        for(int i = 0; i< n; i++){
            for(int j = 0; j < n; j++){
                if(i + 1 < n){
                    dp[i+1][j] = Math.max(dp[i+1][j] , dp[i][j] + map[i+1][j]);
                }

                if(j + 1 < n){
                    dp[i][j+1] = Math.max(dp[i][j+1] , dp[i][j] + map[i][j+1]);
                }
            }
        }


        System.out.println(dp[n-1][n-1]);


    }
}