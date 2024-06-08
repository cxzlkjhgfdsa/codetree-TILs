import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Long> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        long [] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        for(Long i : arr){
            pq.add(i);
            if(pq.size() < 3){
                sb.append(-1).append("\n");
            }else{
                long a = pq.poll();
                long b = pq.poll();
                long c = pq.poll();

                sb.append(a*b*c).append("\n");
                pq.add(a);
                pq.add(b);
                pq.add(c);
            }

        }

        System.out.println(sb);

    }
}