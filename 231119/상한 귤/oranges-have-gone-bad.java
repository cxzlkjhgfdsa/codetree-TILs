import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0 ,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);


        int[][] map = new int[n][n];
        int[][] ans = new int[n][n];

        Queue<Pos> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(ans[i] , -1);
        }

        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] == 2){
                    visited[i][j] = true;
                    que.add(new Pos(i, j, 0));
                }else if(map[i][j] == 1){
                    ans[i][j] = -2;
                }
            }
        }

        while(!que.isEmpty()){
            
            Pos p = que.poll();

            ans[p.x][p.y] = p.cnt;

            for(int i = 0; i < 4; i++){
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(cx < 0 || cx >= n || cy < 0 || cy >= n || visited[cx][cy] || map[cx][cy] != 1)
                    continue;

                que.add(new Pos(cx, cy, p.cnt+1));
                visited[cx][cy] = true;
            }

        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }   


    }
}

class Pos{
    int x, y, cnt;
    public Pos(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}