import java.util.*;
import java.util.Map.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for(int tc = 0; tc < n; tc++){
            String order = sc.next();

            switch(order){
                case "add":
                    int k = sc.nextInt();
                    int v = sc.nextInt();
                    treeMap.put(k, v);
                    break;
                case "remove":
                    int r = sc.nextInt();
                    treeMap.remove(r);
                    break;
                case "find":
                    int key = sc.nextInt();
                    if(treeMap.containsKey(key))
                        System.out.println(treeMap.get(key));
                    else
                        System.out.println("None");
                    break;
                case "print_list":
                    if(treeMap.size() == 0){
                        System.out.println("None");
                    }else{
                        Iterator<Entry<Integer, Integer>> it = treeMap.entrySet().iterator();

                        while(it.hasNext()){
                            Entry<Integer, Integer> entry = it.next();
                            System.out.print(entry.getValue()+" ");
                        }
                        System.out.println();
                    }
                    
                    break;
            }
        }

    }
}