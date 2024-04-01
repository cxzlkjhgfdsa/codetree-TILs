import java.util.*;

public class Main {

    static List<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        comb(n, m, 0, 1);
    }

    private static void comb(int n, int m, int cnt, int start){
        if(cnt == m){
            for(Integer i : list){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }


        for(int i = start; i <= n; i++){
            list.add(i);
            comb(n, m, cnt+1, i+1);
            list.remove(list.size() - 1);
        }
    }
}