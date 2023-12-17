import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            set.add(sc.nextInt());
        }

        int m = sc.nextInt();

        for(int i = 0; i < m; i++){
            boolean b = set.contains(sc.nextInt());

            if(b){
                System.out.print(1+" ");
            }else{
                System.out.print(0+" ");
            }
        }
    }
}