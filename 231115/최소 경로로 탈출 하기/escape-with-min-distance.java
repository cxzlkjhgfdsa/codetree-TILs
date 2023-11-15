import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        Queue<Pos> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        que.add(new Pos(0, 0, 0));
        visited[0][0] = true;

        int ans = -1;

        while(!que.isEmpty()){
            
            Pos p = que.poll();

            if(p.x == n-1 && p.y == m - 1){
                ans = p.dis;
                break;
            }

            for(int i = 0; i < 4; i++){
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(cx < 0 || cx >= n || cy < 0 || cy >=m || visited[cx][cy] || map[cx][cy] == 0)
                    continue;
                que.add(new Pos(cx, cy, p.dis+1));
                visited[cx][cy] = true;
            }

        }


        System.out.println(ans);

    }
}

class Pos{
    int x, y, dis;
    public Pos(int x, int y, int dis){
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}