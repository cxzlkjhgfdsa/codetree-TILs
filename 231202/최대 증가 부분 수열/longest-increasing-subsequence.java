import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] dp = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        dp[0] = 1;


        for(int i = 1; i < n; i++){

            int max = 0;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    max = Math.max(max, dp[j]);
                }
            }

            dp[i] = max + 1;
        }

        int ans = 0;

        for(int i : dp){
            ans = Math.max(ans, i);
        }

        System.out.println(ans);


    }
}