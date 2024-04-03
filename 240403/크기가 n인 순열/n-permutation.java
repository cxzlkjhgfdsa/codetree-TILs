import java.util.*;

public class Main {

    static int [] nums;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        nums = new int[n];
        visited = new boolean[n+1];

        perm(n, 0);
        
    }

    private static void perm(int n, int cnt){

        if(cnt == n){

            for(Integer i : nums){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }


        for(int i = 1; i <= n; i++){
            
            if(visited[i])
                continue;
            visited[i] = true;
            nums[cnt] = i;

            perm(n, cnt+1);
            visited[i] = false;
        }
    }
}