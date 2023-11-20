import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        boolean[] visited = new boolean[1000001];

        Queue<Num> que = new ArrayDeque<>();
        que.add(new Num(N, 0));

        while(!que.isEmpty()){

            Num num = que.poll();

            if(num.n == 1){
                System.out.println(num.cnt);
                break;
            }

            int an = num.n - 1;
            if(!visited[an]){
                que.add(new Num(an , num.cnt+1));
            }

            int bn = num.n + 1;
            if(!visited[bn]){
                que.add(new Num(bn, num.cnt+1));
            }

            if(num.n % 2 == 0){
                int cn = num.n/2;
                if(!visited[cn])
                    que.add(new Num(cn, num.cnt+1));
            }

            if(num.n % 3 == 0){
                int dn = num.n/3;
                if(!visited[dn])
                    que.add(new Num(dn, num.cnt+1));
            }

        }
    }
}

class Num{
    int n , cnt;
    public Num(int n, int cnt){
        this.n = n;
        this.cnt = cnt;
    }
}