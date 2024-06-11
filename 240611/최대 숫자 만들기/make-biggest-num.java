import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Num> pq = new PriorityQueue<>();

        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            pq.add(new Num(sc.next()));
        }

        String ans = "";

        while(!pq.isEmpty()){
            if(pq.size() >= 2){

                String a = pq.poll().num;
                String b = pq.poll().num;

                long x = Long.parseLong(a+b);
                long y = Long.parseLong(b+a);

                if(x > y){
                    ans += a+b;
                }else{
                    ans += b+a;
                }

            }else{
                ans += pq.poll().num;
            }
        }

        System.out.println(ans);


    }

    private static class Num implements Comparable<Num>{
        String num;
        public Num(String num){
            this.num = num;
        }

        @Override
        public int compareTo(Num n){
            int minSize = Math.min(this.num.length(), n.num.length());

            for(int i = 0; i < minSize; i++){
                if(this.num.charAt(i) == n.num.charAt(i))
                    continue;
                return n.num.charAt(i) - this.num.charAt(i);
            }
            return this.num.length() - n.num.length();
        }
    }
}