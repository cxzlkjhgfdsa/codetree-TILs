import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        StringBuilder sb = new StringBuilder();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int h = Integer.parseInt(input[1]);
        int m = Integer.parseInt(input[2]);

        List<People> peoples = new ArrayList<>();
        int[][] map = new int[n][n];
        int[][] ans = new int[n][n];

        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] == 2){
                    peoples.add(new People(i, j, 0));
                }
            }
        }

        for(People p : peoples){
            boolean[][] visited = new boolean[n][n];
            Queue<People> que = new ArrayDeque<>();
            que.add(p);
            visited[p.x][p.y] = true;

            int min = -1;

            while(!que.isEmpty()){
                People po = que.poll();

                if(map[po.x][po.y] == 3){
                    min = po.cnt;
                    break;
                }

                for(int i = 0; i < 4; i++){
                    int cx = po.x + dx[i];
                    int cy = po.y + dy[i];

                    if(cx < 0 || cx >= n || cy < 0 || cy >= n || visited[cx][cy] || map[cx][cy] == 1)
                        continue;
                    que.add(new People(cx, cy, po.cnt + 1));
                    visited[cx][cy] = true;
                }
            }

            ans[p.x][p.y] = min;


        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}


class People{
    int x, y, cnt;
    public People(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}