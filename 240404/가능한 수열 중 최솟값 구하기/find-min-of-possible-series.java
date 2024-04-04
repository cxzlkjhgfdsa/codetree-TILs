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
        
        if(n == cnt){
            for(Integer i : nums){
                System.out.print(i);
            }
            System.exit(0);
        }

        for(int i = 4; i <= 6; i++){
            if(nums[cnt-1] == i)
                continue;
            if(cnt -3 >= 0){
                if(nums[cnt - 1] == nums[cnt - 3]){
                    if(nums[cnt-2] == i)
                        continue;
                }
            }

            if(cnt - 5 >= 0){
                if(nums[cnt-5] == nums[cnt -2] && nums[cnt-4] == nums[cnt-1])
                    if(nums[cnt-3] == i)
                        continue;
            }
            nums[cnt] = i;
            minPerm(n ,cnt+1);
        }

    }
}