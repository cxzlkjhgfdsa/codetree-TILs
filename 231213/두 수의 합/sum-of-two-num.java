import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Map<Long, Long> map = new HashMap<>();

        int ans = 0;

        for(int i = 0; i < n; i++){
            long x = (long)sc.nextInt();

            if(map.get(x) != null){
                ans+= map.get(x);
            }

            long l = (long)(k - x);
            if(map.get(l) != null){
                map.put(l, map.get(l)+1);
            }else{
                map.put(l, 1L);
            }
            
        }

        
        System.out.println(ans);
    
    }
}