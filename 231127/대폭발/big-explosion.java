import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int r = Integer.parseInt(input[2]) -1;
        int c = Integer.parseInt(input[3]) -1;

        int[][] map = new int[n][n];

        Queue<Pos> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        que.add(new Pos(r, c, 1));
        visited[r][c] = true;

          
        for(int k = 1; k<=m; k++){
            int size = que.size();
            for(int j = 0; j < size; j++){
                Pos p = que.poll();

                for(int i = 0; i < 4; i++){
                    int cx = (int)(p.x + dx[i]*Math.pow(2, p.t-1));
                    int cy = (int)(p.y + dy[i]*Math.pow(2, p.t-1));

                    if(cx < 0 || cx >= n || cy < 0 || cy >= n || visited[cx][cy])
                        continue;
                    que.add(new Pos(cx, cy, p.t+1));
                    visited[cx][cy] = true;
                }

                p.t++;
                que.add(p);
            }
        }

        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j])
                    cnt++;
            }
        }

        System.out.println(cnt);
        

    }
}

class Pos{
    int x, y, t;
    public Pos(int x, int y, int t){
        this.x = x;
        this.y = y;
        this.t = t;
    }
}