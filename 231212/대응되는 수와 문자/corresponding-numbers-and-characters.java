import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<String, String> map = new HashMap<>();


        for(int i = 1; i <= n; i++){

            String s = sc.next();

            map.put(s, i+"");
            map.put(i+"", s);
        }

        for(int i = 0; i < m; i++){
            String find = sc.next();
            System.out.println(map.get(find));
        }

    }
}