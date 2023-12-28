import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        StringBuilder sb = new StringBuilder();

        input = br.readLine().split("");

        Map<String, Integer> map = new LinkedHashMap<>();

        for(String s : input){
            if(map.get(s) == null){
                map.put(s, 1);
            }else{
                map.put(s, map.get(s) + 1);
            }
        }

        String answer = "None";

        for (Map.Entry entry : map.entrySet()) {
            if((int)entry.getValue() == 1){
                answer = (String)entry.getKey();
                break;
            }
        }

        System.out.println(answer);


    }
}