import java.util.*;
import java.util.Map.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, Integer> map = new TreeMap<>();
    
       int n = sc.nextInt();

       for(int tc = 0; tc < n; tc++){
            String str = sc.next();
            if(map.containsKey(str)){
                map.put(str , map.get(str)+1);
            }else{
                map.put(str , 1);
            }
       }

        Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
        while(it.hasNext()) {
            Entry<String, Integer> entry = it.next();
            int num = entry.getValue();

            double ans = num*1.0/n*100;

            System.out.print(entry.getKey()+" ");
            System.out.print(String.format("%.4f", ans));
            System.out.println();
        }


    }
}