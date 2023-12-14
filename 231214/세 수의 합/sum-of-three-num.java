import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Long> list = new ArrayList<>();
        Map<Long, Integer> map = new HashMap<>();

        list.add((long)(k - sc.nextInt()));

        int ans = 0;

        for(int i = 1; i < n; i++){
            int x = sc.nextInt();

            if(map.get((long)x) != null){
                ans+= map.get((long)x);
            }

            for(Long next : list){
                
                long l = next - x;

                if(map.get(l) == null){
                    map.put(l, 1);
                }else{
                    map.put(l, map.get(l) + 1);
                }
            }

            list.add((long)(k - x));
        }      

        System.out.println(ans);


    }
}