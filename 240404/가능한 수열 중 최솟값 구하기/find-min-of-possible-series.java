import java.util.*;

public class Main {

    static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        nums = new int[n];
        nums[0] = 4;

        minPerm(n, 1);
    }

    private static void minPerm(int n, int cnt){
        if(cnt / 2 >= 2){
            int idx = cnt / 2;
            for(int i = 2; i <= idx; i++){
                boolean check = true;
                for(int j = 0; j < i; j++){
                     if(cnt == 8){
                        //System.out.print(nums[cnt-j-1] +" "+nums[cnt-j-i-1]+" ");
                    }
                    if(nums[cnt-j-1] != nums[cnt-j-i-1])
                        check = false;
                }
                //System.out.println();
                if(check)
                    return;
                }
            
        }
        
        if(n == cnt){
            for(Integer i : nums){
                System.out.print(i);
            }
            System.exit(0);
        }

        for(int i = 4; i <= 6; i++){
            if(nums[cnt-1] == i)
                continue;
            nums[cnt] = i;
            minPerm(n ,cnt+1);
        }

    }
}