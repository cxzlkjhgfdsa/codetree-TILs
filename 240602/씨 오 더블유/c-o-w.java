import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String[] str = sc.next().split("");

        long [] dpL = new long[N+2];
        long [] dpR = new long[N+2];

        for(int i = 1; i <= N; i++){
            if(str[i-1].equals("C"))
                dpL[i] = dpL[i-1] + 1;
            else
                dpL[i] = dpL[i-1];
        }

        for(int i = N; i >= 1; i--){
            if(str[i-1].equals("W")){
                dpR[i] = dpR[i+1] + 1;
            }else{
                dpR[i] = dpR[i+1];
            }
        }

        long cnt = 0;

        // System.out.println(Arrays.toString(dpL));
        // System.out.println(Arrays.toString(dpR));

        for(int i = 1; i < N - 1; i++){
            if(str[i].equals("O")){
                cnt += (dpL[i] * dpR[i]);
            }
        }

        System.out.println(cnt);
        
    }
}