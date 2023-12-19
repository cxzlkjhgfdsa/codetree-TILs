import java.util.*;

public class Main {

    static int n, m, ans;
    static int[][] area;
    static int[] nums, secNums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        ans = -1;

        area = new int[n][m];
        nums = new int[2];
        secNums = new int[2];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                area[i][j] = sc.nextInt();
            }
        }

        combi(0, 0);

        System.out.println(ans);

    }
    
    static void makeSquare(int[] nums, int cnt, int start){
        if(cnt == 2){
            
            boolean isPlus = true;
            int count = 0;

            for(int i = nums[0]; i <=nums[1]; i++){
                for(int j = secNums[0]; j <= secNums[1]; j++){
                    if(area[i][j] <= 0)
                        isPlus = false;
                    count++;
                }
            }

            if(isPlus){
                ans = Math.max(count, ans);
            }
            return;
        }
        
        for(int i = start; i < m; i++){
            secNums[cnt] = i;
            makeSquare(nums, cnt+1, i);
        }
    }

    static void combi(int cnt, int start){
        if(cnt == 2){
            makeSquare(nums , 0, 0);
            return;
        }
        
        for(int i = start; i < n; i++){
            nums[cnt] = i;
            combi(cnt+1, i);
        }
    }
}