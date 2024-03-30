import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int n = Integer.parseInt(br.readLine());

        boolean[] selected = new boolean[1001];
        PriorityQueue<Line> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            pq.add(new Line(a, b, b-a));
        }

        int cnt = 0;

        while(!pq.isEmpty()){
            
            Line l = pq.poll();

            boolean go = true;

            for(int i = l.start; i <= l.end; i++){
                if(selected[i]){
                    go = false;
                    break;
                }
            }

            if(!go)
                continue;

            for(int i = l.start; i <= l.end; i++){
                selected[i] = true;
            }

            cnt++;

        }
        
        System.out.println(cnt);

    }

    private static class Line implements Comparable<Line>{
        int start, end, dis;
        public Line(int start, int end, int dis){
            this.start = start;
            this.end = end;
            this.dis = dis;
        }

        @Override
        public int compareTo(Line o){
            
            if(this.dis == o.dis){
                return this.start - o.start;
            }
            return this.dis - o.dis;
        }
    }
}