import java.util.*;

public class Main {

    static List<Integer> list;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        max = 0;
        list = new ArrayList<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        comb(n, m, 0, 1);

        System.out.println(max);
    }

    private static void comb(int n, int m, int cnt, int start){
        if(cnt == m){
            int xor = list.get(0);
            for(int i = 1; i < list.size(); i++){
                xor ^= list.get(i);
            }
            max = Math.max(max, xor);
            
        }


        for(int i = start; i <= n; i++){
            list.add(i);
            comb(n, m, cnt+1, i+1);
            list.remove(list.size() - 1);
        }
    }
}