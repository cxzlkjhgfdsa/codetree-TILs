import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split("");
        int min = 100;

        for(int i = 0; i < input.length; i++){
            min = Math.min(min, Encoding(input));
            shift(input);
        }

        System.out.println(min);

    }

    private static void shift(String[] input){

        String tmp = input[input.length -1];

        for(int i = input.length - 1; i > 0; i--){
            input[i] = input[i-1];
        }
        input[0] = tmp;
    }

    private static int Encoding(String[] input){
        StringBuffer sb = new StringBuffer();

        int idx = 1;
        int cnt = 1;
        sb.append(input[0]);

        while(idx < input.length){
            
            if(input[idx].equals(input[idx-1])){
                cnt++;
            }else{
                sb.append(cnt);
                cnt = 1;
                sb.append(input[idx]);
            }
            idx++;

        }
        sb.append(cnt);

        //System.out.println(sb.toString());

        return sb.length();
    }
}