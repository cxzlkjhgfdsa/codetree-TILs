import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        TreeSet<Integer> ts = new TreeSet<>();

        double sum = 0;

        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();

            if(tm.get(nums[i]) != null){
                tm.put(nums[i], tm.get(nums[i]) + 1);
            }else{
                tm.put(nums[i] , 1);
            }

            ts.add(nums[i]);
            sum+=nums[i];

        }

        double max = 0;



        for(int k = 1; k <=n-2; k++){

            int cur = nums[k-1];
            
            sum = sum - cur;

            if(tm.get(cur) != 1){
                tm.put(cur , tm.get(cur) - 1);
            }else{
                ts.remove(cur);
            }

            double test = sum - ts.first();

            test = test / (n-k-1);

            


            max = Math.max(test, max);
        }

        System.out.printf("%.2f" ,  max);


    }
}