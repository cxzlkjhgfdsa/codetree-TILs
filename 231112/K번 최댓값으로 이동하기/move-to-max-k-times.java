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
        int k = Integer.parseInt(input[1]);

        int[][] map = new int[n][n];

        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]) - 1;
        int c = Integer.parseInt(input[1]) - 1;

        for(int tc = 0; tc < k; tc++){
            
            Queue<Pos> que = new ArrayDeque<>();
            boolean[][] visited = new boolean[n][n];
            que.add(new Pos(r, c));
            visited[r][c] = true;

            int max = 0;
            int maxR = n;
            int maxC = n;

            while(!que.isEmpty()){
                
                Pos p = que.poll();

                //System.out.println(tc + " : (" + p.x + " , " + p.y + ") = " + map[p.x][p.y] + " ??? " + max);
            
                if(map[p.x][p.y] >= max && (p.x !=  r || p.y != c)){

                    //System.out.println(tc + " : (" + p.x + " , " + p.y + ") = " + map[p.x][p.y] + " ??? " + max);
                    
                    if(map[p.x][p.y] == max){
                        if(p.x <= maxR){
                            
                            if(p.x == maxR){
                                if(p.y <= maxC){
                                    maxR = p.x;
                                    maxC = p.y;
                                }
                            }else{
                                maxR = p.x;
                                maxC = p.y;
                            }
                        }
                    }else{
                        
                        max = map[p.x][p.y];
                        maxR = p.x;
                        maxC = p.y;
                        
                    }
                }

                for(int i = 0; i < 4; i++){
                    int cx = p.x+dx[i];
                    int cy = p.y+dy[i];

                    if(cx < 0 || cx >= n || cy < 0 || cy>=n || visited[cx][cy] || map[cx][cy] >= map[r][c] )
                        continue;
                    
                    que.add(new Pos(cx, cy));
                    visited[cx][cy] = true;
                }
            }

            if(max == 0)
                break;
            
            r = maxR;
            c = maxC;

            //System.out.println(tc + " : " + r + " , " + c);

        }
        
        System.out.println((r+1) + " " + (c+1));
        
    }
}

class Pos{
    int x, y;
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}