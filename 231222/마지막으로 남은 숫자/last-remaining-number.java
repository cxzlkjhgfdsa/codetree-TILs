import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            pq.add(sc.nextInt());
        }

        while(pq.size() != 1){

            int num = pq.poll() - pq.poll();

            if(num > 0){
                pq.add(num);
            }

            if(pq.size() == 0)
                break;

        }


        if(pq.size() > 0){
            System.out.println(pq.poll());
        }else{
            System.out.println(-1);
        }



    }
}