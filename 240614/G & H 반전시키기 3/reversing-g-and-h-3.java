import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] start = sc.next().split("");
        String[] end = sc.next().split("");

        int ans = 0;
        int idx = 0;

        for(int i = n-1; i >=0; i--){
            idx++;
            
            if(!start[i].equals(end[i]) || idx == 4){
                ans++;
                idx = 0;
                change(start, i);
            }

        }

        System.out.println(ans);

    }

    private static void change(String[] str, int idx){
        for(int i = idx; i >=0; i--){
            if(str[i].equals("G")){
                str[i] = "H";
            }else{
                str[i] = "G";
            }
        }
    }
}