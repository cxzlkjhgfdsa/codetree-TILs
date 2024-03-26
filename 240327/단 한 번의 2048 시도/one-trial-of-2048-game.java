import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input;

        int map[][] = new int[4][4];

        for(int i = 0; i < 4; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < 4; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        String dir = br.readLine();
        int[][] ans = null;

        switch(dir){
            case "U":
                ans = moveUp(map);
                break;
            case "R":
                ans = moveRight(map);
                break;
            case "D":
                ans = moveDown(map);
                break;
            case "L":
                ans = moveLeft(map);
                break;
        }

        for(int i = 0; i < 4; i++){
            for(int j =0; j < 4; j++){
                bw.write(ans[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();

        
    }

    private static int[][] moveUp(int[][] map){
        Queue<Integer> que = new ArrayDeque<>();

        boolean isMerge = false;
        int[][] temp = new int[4][4];

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(map[j][i] == 0)
                    continue;
                que.add(map[j][i]);               
            }

            int idx = 0;
            while(!que.isEmpty()){

                int cur = que.poll();
                
                if(idx > 0 && cur == temp[idx-1][i] && !isMerge){
                    temp[idx-1][i] *=2;
                    isMerge = true;
                }else{
                    temp[idx][i] = cur;
                    isMerge =  false;
                    idx++;
                }
            }
        }

        return temp;
    }

    private static int[][] moveRight(int[][] map){
        Queue<Integer> que = new ArrayDeque<>();

        boolean isMerge = false;
        int[][] temp = new int[4][4];

        for(int i = 0; i < 4; i++){
            for(int j = 3; j >= 0; j--){
                if(map[i][j] == 0)
                    continue;
                que.add(map[i][j]);               
            }

            int idx = 3;
            while(!que.isEmpty()){

                int cur = que.poll();
                
                if(idx < 3 && cur == temp[i][idx+1] && !isMerge){
                    temp[i][idx+1] *=2;
                    isMerge = true;
                }else{
                    temp[i][idx] = cur;
                    isMerge =  false;
                    idx--;
                }
            }
        }

        return temp;
    }

    private static int[][] moveDown(int[][] map){
        Queue<Integer> que = new ArrayDeque<>();

        boolean isMerge = false;
        int[][] temp = new int[4][4];

        for(int i = 0; i < 4; i++){
            for(int j = 3; j >= 0; j--){
                if(map[j][i] == 0)
                    continue;
                que.add(map[j][i]);               
            }

            int idx = 3;
            while(!que.isEmpty()){

                int cur = que.poll();
                
                if(idx < 3 && cur == temp[idx+1][i] && !isMerge){
                    temp[idx+1][i] *=2;
                    isMerge = true;
                }else{
                    temp[idx][i] = cur;
                    isMerge =  false;
                    idx--;
                }
            }
        }

        return temp;
    }

    private static int[][] moveLeft(int[][] map){
        Queue<Integer> que = new ArrayDeque<>();

        boolean isMerge = false;
        int[][] temp = new int[4][4];

        for(int i = 0; i < 4; i++){
            for(int j = 0; j <4; j++){
                if(map[i][j] == 0)
                    continue;
                que.add(map[i][j]);               
            }

            int idx = 0;
            while(!que.isEmpty()){

                int cur = que.poll();
                
                if(idx > 0 && cur == temp[i][idx-1] && !isMerge){
                    temp[i][idx-1] *=2;
                    isMerge = true;
                }else{
                    temp[i][idx] = cur;
                    isMerge =  false;
                    idx++;
                }
            }
        }

        return temp;
    }
}