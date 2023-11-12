import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringBuilder sb = new StringBuilder();
         String[] input;

         input = br.readLine().split(" ");

         int n = Integer.parseInt(input[0]);
         int k = Integer.parseInt(input[1]);

         int[] dx = {-1, 0, 1, 0};
         int[] dy = {0, 1, 0, -1};

         int[][] map = new int[n][n];
         boolean[][] visited = new boolean[n][n];

         for(int i = 0; i< n; i++){
            input  = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int cnt = 0;
        
        for(int tc = 0; tc < k; tc++){
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]) -1;
            int y = Integer.parseInt(input[1]) -1;

            if(visited[x][y])
                continue;


            Queue<Pos> que = new ArrayDeque<>();
            visited[x][y] = true;
            que.add(new Pos(x, y));

            while(!que.isEmpty()){
                
                Pos p = que.poll();


                cnt++;

                for(int i = 0; i < 4; i++){
                    int cx = p.x + dx[i];
                    int cy = p.y + dy[i];

                    if(cx < 0 || cx >= n || cy < 0 || cy >= n || visited[cx][cy] || map[cx][cy] == 1)
                        continue;
                    que.add(new Pos(cx, cy));
                    visited[cx][cy] = true;

                }

            }

            

        }

        System.out.println(cnt);

    }
}

class Pos{
    int x, y;
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}