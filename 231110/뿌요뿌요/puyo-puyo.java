import java.util.*;
import java.io.*;

public class Main {

    static int ans, max;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int n = Integer.parseInt(br.readLine());

        int[][] blocks = new int[n][n];

        ans = 0;
        max = 0;

        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                blocks[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(blocks[i][j] > 0){
                    int k = bfs(i , j, blocks, n);
                    max = Math.max(max, k);
                    if(k >= 4)
                        ans++;

                }
            }
        }
        System.out.println(ans + " " + max);
        
    }

    private static int bfs(int x, int y, int[][] blocks, int n){
        
        int cnt = 0;
        int k = blocks[x][y];
        blocks[x][y] = 0;
        Queue<Pos> que = new ArrayDeque<>();
        que.add(new Pos(x, y));

        while(!que.isEmpty()){

            Pos p = que.poll();
            cnt++;

            for(int i = 0; i < 4; i++){
                int cx = p.x+dx[i];
                int cy = p.y+dy[i];

                if(cx < 0 || cx >= n || cy < 0 || cy >= n || blocks[cx][cy] != k)
                    continue;

                que.add(new Pos(cx, cy));
                blocks[cx][cy] = 0;
            }
        }

        return cnt;


    }

    static class Pos {
        int x, y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}