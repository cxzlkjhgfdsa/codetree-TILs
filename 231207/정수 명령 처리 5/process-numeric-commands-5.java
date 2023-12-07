import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String order = sc.next();

            switch(order){
                case "push_back":
                    int num = sc.nextInt();
                    list.add(num);
                    break;
                case "pop_back":
                    list.remove(list.size()-1);
                    break;
                case "size":
                    System.out.println(list.size());
                    break;
                case "get":
                    int k = sc.nextInt();
                    System.out.println(list.get(k-1));
                    break;
            }
        }
    }
}