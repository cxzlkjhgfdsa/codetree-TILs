import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;

        int max = 0;

        while(start <= end && end < n){

            if(map.get(arr[end]) == null || map.get(arr[end]) < k){
                max = Math.max(max, end - start + 1);
                if(map.get(arr[end]) == null){
                    map.put(arr[end], 1);
                }else{
                    map.put(arr[end], map.get(arr[end]) + 1);
                }
                end++;
            }else{
                map.put(arr[start], map.get(arr[start])-1);
                start++;
            }

            

        }

        System.out.println(max);

    }
}