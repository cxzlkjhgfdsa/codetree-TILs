import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int m = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int tc = arr[0]; tc <= arr[1]; tc++){
            
            int find = tc;

            int left = 0;
            int right = m+1;
            int cnt = 0;

            while(left <= right){

                cnt++;
                
                int mid = (left + right)/2;

                if(mid == find){
                    break;
                }

                if(mid > find){
                    right = mid - 1;
                }else{
                    left= mid + 1;
                }

            }
            
            max = Math.max(max, cnt);
            min = Math.min(min, cnt);
            

        }

        System.out.println(min + " " + max);

    }
}