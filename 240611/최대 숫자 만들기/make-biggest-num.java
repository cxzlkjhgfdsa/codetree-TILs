import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        Num[] arr = new Num[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = new Num(sc.next());
        }

        Arrays.sort(arr);

        for(Num k : arr){
            sb.append(k.num);
        }
        

        System.out.println(sb);
  


    }

    private static class Num implements Comparable<Num>{
        String num;
        public Num(String num){
            this.num = num;
        }

        @Override
        public int compareTo(Num n){
            
            Long a = Long.parseLong(this.num + n.num);
            Long b = Long.parseLong(n.num + this.num);

            if(a > b)
                return -1;
            else
                return 1;
        }
    }
}