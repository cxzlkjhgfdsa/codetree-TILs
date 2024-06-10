import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Integer i : arr){
            pq.add(i);
        }   

        int ans = 0;

        while(pq.size()>1){

            int a = pq.poll();
            int b = pq.poll();

            ans += a + b;

            pq.add(a+b);

        }

        System.out.println(ans);

    }
}