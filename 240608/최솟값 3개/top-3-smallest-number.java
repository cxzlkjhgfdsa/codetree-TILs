import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(Integer i : arr){
            pq.add(i);
            if(pq.size() < 3){
                sb.append(-1).append("\n");
            }else{
                int a = pq.poll();
                int b = pq.poll();
                int c = pq.poll();

                sb.append(a*b*c).append("\n");
                pq.add(a);
                pq.add(b);
                pq.add(c);
            }

        }

        System.out.println(sb);

    }
}