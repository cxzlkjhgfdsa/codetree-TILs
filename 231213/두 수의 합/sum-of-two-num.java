import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();

        int ans = 0;

        for(int i = 0; i < n; i++){
            map.put(i, sc.nextInt());            
        }

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
               
                if(map.get(i) + map.get(j) == k)
                    ans++;
            }
        }

        System.out.println(ans);
    
    }
}