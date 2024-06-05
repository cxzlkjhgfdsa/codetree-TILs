import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int ans  = 0;

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int start = 0;
        int end = 0;

        int sum = arr[0];

        while(start <= end && end < n){

            if(sum == m){
                ans++;
            }

            if(sum > m){
                sum -= arr[start];
                start++;
            }else{
                end++;
                if(end < n)
                    sum += arr[end];
                
            }

        }

        System.out.println(ans);

    }
}