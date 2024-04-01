import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
 
        int n = Integer.parseInt(br.readLine());
        int[] jump = new int[n];
        boolean[] visited = new boolean[n];

        input = br.readLine().split(" ");

        for(int i = 0; i < n; i++){
            jump[i] = Integer.parseInt(input[i]);
        }
        
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(0, 0));

        int ans = -1;

        while(!que.isEmpty()){

            Node node = que.poll();

            if(node.idx == n-1){
                ans = node.cnt;
                break;
            }

            for(int i = 1; i <= jump[node.idx]; i++){
                int cdx = node.idx + i;
                if(cdx >= n || visited[cdx])
                    continue;
                que.add(new Node(cdx, node.cnt+1));
                visited[cdx] = true;
            }

        }

        System.out.println(ans);
    }

    public static class Node{
        int idx, cnt;
        public Node(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}