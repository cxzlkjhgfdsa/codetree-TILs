import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int max = 0;

        int[][] map = new int[N][M];

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(input[j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int k = 1;
        int area = 0;

        for(int h = 1; h <= max; h++){
            
            int[][] copy = copyMap(map, N, M);

            paint(copy, h, N, M);

            int cnt = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){

                    if(copy[i][j] != 0){
                        dfs(copy, i, j, N, M);
                        cnt++;
                    }

                }
            }

            if( cnt > area){
                k = h;
                area = cnt;
            }
            
        }

        System.out.println(k+ " " + area);   
 
    }

    private static void dfs(int [][] copy , int x, int y,  int N, int M ){

        copy[x][y] = 0;

        for(int i = 0; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx < 0 || cx >= N || cy < 0 || cy >= M || copy[cx][cy] == 0)
                continue;

            dfs(copy, cx, cy, N, M);
        }

    }

    private static void paint(int[][] copy, int h, int N, int M){
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(copy[i][j] <= h)
                    copy[i][j] = 0;
            }
        }
    }


    private static int[][] copyMap(int[][] map, int N, int M){
        int[][] copyMap = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                copyMap[i][j] = map[i][j];
            }
        }

        return copyMap;

    }
}