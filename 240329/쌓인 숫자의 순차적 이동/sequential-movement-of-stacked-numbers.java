import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Block[][] map = new Block[n][n];
        Map<Integer, int[]> mapped = new HashMap<>();

        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = new Block(Integer.parseInt(input[j]));
                int[] pos = {i, j};
                mapped.put(map[i][j].max, pos);
            }
        }

        input = br.readLine().split(" ");

        for(int i = 0; i < m; i++){

            int cur = Integer.parseInt(input[i]);

            int[] pos = mapped.get(cur);

            int x = pos[0];
            int y = pos[1];

            int max = 0;

            for(int j = 0; j < 8; j++){
                int cx = x + dx[j];
                int cy = y + dy[j];

                if(cx < 0 || cx >=n || cy < 0 || cy >= n)
                    continue;
                max = Math.max(max, map[cx][cy].max);

            }
            if(max == 0)
                continue;

            int[] maxPos = mapped.get(max);

            int mx = maxPos[0];
            int my = maxPos[1];;

            if(map[mx][my].max < cur){
                map[mx][my].max = cur;
            }


            int idx = map[x][y].list.indexOf((Object) cur);

            int size = map[x][y].list.size();

            for(int j = idx; j < size; j++){
                int next = map[x][y].list.get(idx);
                mapped.put(next, maxPos);
                map[mx][my].list.add(next);
                map[x][y].list.remove((Object) next);
            }
            map[x][y].max = 0;
            for(Integer num : map[x][y].list){
                map[x][y].max = Math.max(map[x][y].max, num);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j].list.size() == 0){
                    System.out.println("None");
                }else{
                    for(int k = map[i][j].list.size()- 1; k >= 0; k--){
                        System.out.print(map[i][j].list.get(k)+ " ");
                    }
                    System.out.println();
                }

            }
        }
    }

    private static class Block{
        List<Integer> list;
        int max;
        public Block(int max){
            this.list = new ArrayList<>();
            this.list.add(max);
            this.max = max;
        }
    }

}