import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
        int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};

        int n = Integer.parseInt(br.readLine());

        input = br.readLine().split(" ");
        int r1 = Integer.parseInt(input[0])-1;
        int c1 = Integer.parseInt(input[1])-1;
        int r2 = Integer.parseInt(input[2])-1;
        int c2 = Integer.parseInt(input[3])-1;

        int ans = -1;

        Queue<Pos> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        que.add(new Pos(r1, c1, 0));
        visited[r1][c1] = true;

        while(!que.isEmpty()){
            Pos p = que.poll();

            if(p.x == r2  && p.y == c2){
                ans = p.dis;
                break;
            }

            for(int i = 0; i < 8; i++){
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(cx < 0 || cx >= n || cy < 0 || cy >= n || visited[cx][cy])
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