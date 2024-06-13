import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String start = sc.next();
        String end = sc.next();

        int cnt = 0;
        int ans = 0;

        for(int i = 0; i < n; i++){
            
            if(start.charAt(i) != end.charAt(i)){
                if(cnt == 0){
                    ans++;
                    cnt++;
                }else if(cnt == 4){
                    ans++;
                    cnt = 1;
                }else{
                    cnt++;
                }
            }else{
                cnt = 0;
            }

        }

        System.out.println(ans);
        
    }
}