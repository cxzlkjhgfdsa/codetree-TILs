import java.util.*;
import java.io.*;

public class Main {

    static int n, m, max;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] combs;
    static List<Pos> stones;
    static Pos[] points;
    static int[][] map;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        m = Integer.parseInt(input[2]);
        points = new Pos[k];
        max = 0;

        map = new int[n][n];
        stones  = new ArrayList<>();
        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] == 1)
                    stones.add(new Pos(i, j));
            }
        }

        combs = new int[m];

        for(int i = 0; i < k; i++){
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]) - 1;
            int y = Integer.parseInt(input[1]) - 1;
            points[i] = new Pos(x, y);
        }

        combi(0, 0);

        System.out.println(max);


    }

    private static void combi(int cnt, int start){
        
        if(cnt == m){
            //System.out.println(Arrays.toString(combs));
            cal(combs);
            return;
        }
        
        for(int i = start; i < stones.size(); i++){
            combs[cnt] = i;
            combi(cnt + 1, i+1);
        }

    }

    private static void cal(int[] arr){

        int[][] copyMap = copy();

        Queue<Pos> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        for(Pos p : points){
            que.add(new Pos(p.x, p.y));
            visited[p.x][p.y] = true;
        }

        for(int i : arr){
            Pos p = stones.get(i);
            copyMap[p.x][p.y] = 0;
        }

        int cnt = 0;

        while(!que.isEmpty()){
            Pos p = que.poll();

            //System.out.println(p.x + " : " + p.y);

            cnt++;

            for(int i = 0; i < 4; i++){
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(cx < 0 || cx >= n || cy < 0 || cy >= n || copyMap[cx][cy] == 1 || visited[cx][cy])
                    continue;
                visited[cx][cy] = true;
                que.add(new Pos(cx, cy));
            }
        }

        max = Math.max(cnt, max);

    }

    private static int[][] copy(){
        int[][] copyMap = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                copyMap[i][j] = map[i][j];
            }
        }

        return copyMap;
    }
}

class Pos{
    int x, y;
    
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}