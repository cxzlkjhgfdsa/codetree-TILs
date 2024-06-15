import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        List<Line>[] graph = new ArrayList[n+1];

        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            input = br.readLine().split(" ");

            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int dis = Integer.parseInt(input[2]);

            graph[s].add(new Line(s, e, dis));
            graph[e].add(new Line(e, s, dis));

        }

        input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        int [] dp = new int[n+1];
        int [] path = new int[n+1];
        Arrays.fill(dp, 1000000000);
        dp[start] = 0;
        Queue<Integer> que = new ArrayDeque<>();
        
        que.add(start);

        while(!que.isEmpty()){

            int cur = que.poll();

            for(Line l : graph[cur]){

                if(dp[l.e] > dp[cur] + l.dis){
                    dp[l.e] = dp[cur] + l.dis;
                    que.add(l.e);
                    path[l.e] = cur;
                }

            }

        }
        
       // System.out.println(Arrays.toString(path));
        // int x = end;
        // ArrayList<Integer> vertices = new ArrayList<>();
        // vertices.add(x);
        // while(x != start){
        //     x = path[x];
        //     vertices.add(x);
        // }
        System.out.println(dp[end]);
        // for(int i = vertices.size() - 1; i >= 0; i--){
        //     System.out.print(vertices.get(i)+" ");
        // }

    }

    private static class Line{
        int s, e, dis;
        public Line(int s, int e, int dis){
            this.s = s;
            this.e = e;
            this.dis = dis;
        }
    }


}