import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int start = 0;
        int end = 1;
        int ans = 0;

        while(start < end && end < n && start >= 0){
            
            int sum = arr[start] + arr[end];

            if(sum <= k){
                ans += (start - 0 + 1);
                start++;
                end++;
            }else{
                start--;
            }

        }

        System.out.println(ans);

    }
}