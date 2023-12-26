import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        double max = 0;

        for(int k = 1; k <=n-2; k++){
            
            for(int i = k; i < n; i++){
                pq.add(nums[i]);
            }

            pq.poll();

            int size = pq.size();

            double sum = 0;

            while(!pq.isEmpty())
                sum+=pq.poll();
            
            sum = sum / size;

            max = Math.max(sum, max);
        }

        System.out.printf("%.2f" ,  max);


    }
}