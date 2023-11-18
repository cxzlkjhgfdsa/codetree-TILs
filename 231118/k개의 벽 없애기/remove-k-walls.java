import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};  

    static int[] nums;
    static int[][] map;
    static int n , k, ans, r1, c1, r2, c2;    
    static List<Pos> walls;                                                                                                                                                                                                                                                                                                                                                                                                                   
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        ans = 100000;

        map = new int[n][n];
        nums = new int[k];
        walls = new ArrayList<>();

        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] == 1){
                    walls.add(new Pos(i, j, 0));
                }
            } 
        }

        input = br.readLine().split(" ");
        r1 = Integer.parseInt(input[0])-1;
        c1 = Integer.parseInt(input[1])-1;

        input = br.readLine().split(" ");
        r2 = Integer.parseInt(input[0])-1;
        c2 = Integer.parseInt(input[1])-1;

        combi(0, 0);

        if(ans == 100000)
            ans = -1;

        System.out.println(ans);
    }

    private static int cal(int[] nums){
        
        int[][] copyMap = copy();

        for(int i : nums){
            Pos p =  walls.get(i);
            copyMap[p.x][p.y] = 0;
        }

        Queue<Pos> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        visited[r1][c1] = true;
        que.add(new Pos(r1, c1, 0));

        while(!que.isEmpty()){

            Pos p = que.poll();

            if(p.x == r2 && p.y == c2){
                return p.cnt;
            }

            for(int i = 0; i < 4; i++){
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(cx < 0 || cx >= n || cy < 0 || cy >= n || visited[cx][cy] || copyMap[cx][cy] == 1)
                    continue;
                que.add(new Pos(cx, cy, p.cnt + 1));
                visited[cx][cy] = true;
            }
        }

        return 100000;
    }

    private static void combi(int cnt, int start){

        if(cnt == k){

            ans = Math.min(ans, cal(nums));
            return;

        }
        
        for(int i = start; i < walls.size(); i++){
            nums[cnt] = i;
            combi(cnt + 1, i + 1);
        }
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
    int x, y, cnt;
    public Pos(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}