import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++){

            String s = sc.next();

            switch(s){
                case "push":
                    int k = sc.nextInt();
                    pq.add(k);
                    break;
                case "pop":
                    System.out.println(pq.poll());
                    break;
                case "size":
                    System.out.println(pq.size());
                    break;
                case "empty":
                    if(pq.isEmpty()){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;
                case "top":
                    System.out.println(pq.peek());
                    break;
            }

        }
    }
}