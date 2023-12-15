import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> set = new HashSet<>();

        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            String order = sc.next();
            int k = sc.nextInt();

            switch(order){
                case "add":
                    set.add(k);
                    break;
                case "remove":
                    set.remove(k);
                    break;
                case "find":
                    System.out.println(set.contains(k));
                    break;
                    
            }

        }
    }
}