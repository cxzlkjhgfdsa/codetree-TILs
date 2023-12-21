import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            int k = sc.nextInt();

            if(k == 0){
                if(pq.size() == 0)
                    System.out.println(0);
                else
                    System.out.println(pq.poll());
            }else{
                pq.add(k);
            }
        }
    }
}