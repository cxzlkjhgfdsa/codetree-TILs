import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }


        int answer = 0;

        Queue<Pos> que = new ArrayDeque<>();
        que.add(new Pos(0, 0));
        visited[0][0] = true;

        while(!que.isEmpty()){

            Pos p = que.poll();

            if(p.x == n - 1 && p.y == m - 1)
                answer = 1;

            for(int i = 0; i < 4; i++){
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(cx < 0 || cx >= n || cy < 0 || cy >= m || visited[cx][cy] || map[cx][cy] == 0)
                    continue;
                que.add(new Pos(cx, cy));
                visited[cx][cy] = true;

            }


        }

        System.out.println(answer);

    }
}

class Pos{
    int x, y;
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}