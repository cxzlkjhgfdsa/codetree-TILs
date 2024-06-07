import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        long m = Long.parseLong(br.readLine());

        long [] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long min = Integer.MAX_VALUE;
        long max = 0;

        for(long tc = arr[0]; tc <= arr[1]; tc++){
            
            long find = tc;

            long left = 0;
            long right = m+1;
            long cnt = 0;

            while(left <= right){

                cnt++;
                
                long mid = (left + right)/2;

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