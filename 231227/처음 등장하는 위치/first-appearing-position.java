import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SortedMap<Integer, Integer> map = new TreeMap<>();

        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){

            int num = sc.nextInt();

            if(map.get(num) == null){
                map.put(num, i);
            }
        }

        
        map.keySet().forEach(key ->{
            System.out.println(key+" "+map.get(key));
        });

    }
}