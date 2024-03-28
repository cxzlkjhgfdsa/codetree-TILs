import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int N = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]) - 1;
        int y = Integer.parseInt(input[1]) - 1;
        int dir = 0;  // 0 우 , 1 하, 2 좌 , 3 상

        String[][] map = new String[N][N];
        int[][] visited = new int[N][N];

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().split("");
        }

        int cnt = 0;

        while(true){

            if(visited[x][y]>=4){
                cnt = -1;
                break;
            }

            visited[x][y]++;

            if(dir == 0){
                if(y + 1== N){
                    cnt++;
                    break;
                }

                if(map[x][y+1].equals("#")){
                    dir = 3;
                    continue;
                }

                if(map[x+1][y+1].equals("#")){
                    y++;
                    cnt++;
                }else{
                    x++;
                    y++;
                    dir = 1;
                    cnt+=2;
                }
            }else if(dir == 1){
                if(x+1 == N){
                    cnt++;
                    break;
                }

                if(map[x+1][y].equals("#")){
                    dir = 0;
                    continue;
                }

                if(map[x+1][y-1].equals("#")){
                    x++;
                    cnt++;
                }else{
                    x++;
                    y--;
                    dir = 2;
                    cnt+=2;
                }

            }else if(dir == 2){
                if(y - 1 == -1){
                    cnt++;
                    break;
                }

                if(map[x][y-1].equals("#")){
                    dir = 1;
                    continue;
                }

                if(map[x-1][y-1].equals("#")){
                    y--;
                    cnt++;
                }else{
                    x--;
                    y--;
                    dir = 3;
                    cnt+=2;
                }
            }else if(dir == 3){
                if(x - 1 == -1){
                    cnt++;
                    break;
                }

                if(map[x-1][y].equals("#")){
                    dir = 2;
                    continue;
                }

                if(map[x-1][y+1].equals("#")){
                    x--;
                    cnt++;
                }else{
                    x--;
                    y++;
                    dir = 0;
                    cnt+=2;
                }
            }
        }

        System.out.println(cnt);
    }
}