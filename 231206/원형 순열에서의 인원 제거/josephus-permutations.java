import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> que = new ArrayDeque<>();

        for(int i = 1; i <=N; i++){
            que.add(i);
        }

        while(!que.isEmpty()){

            for(int i = 0; i < K - 1; i++){
                que.add(que.poll());
            }

            System.out.print(que.poll()+" ");

        }
    }
}