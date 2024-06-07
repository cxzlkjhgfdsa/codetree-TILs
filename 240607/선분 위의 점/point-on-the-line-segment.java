import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < n; i++){
            map.put(arr[i], i+1);
        }

        for(int i = 0; i < m; i++){

            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            int lowValue = map.lowerKey(start) == null ? 0 : map.get(map.lowerKey(start));
            int highValue = map.floorKey(end) == null ? 0 : map.get(map.floorKey(end));

            sb.append(highValue - lowValue).append("\n");

        }

        System.out.println(sb);

    }
}