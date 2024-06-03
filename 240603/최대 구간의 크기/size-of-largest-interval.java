import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Point> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            list.add(new Point(sc.nextInt(), 1));
            list.add(new Point(sc.nextInt(), -1));
        }

        Collections.sort(list);

        int max = 0;
        int sum = 0;
        int sumVal = 0;

        sumVal += list.get(0).v;

        for(int i = 1; i < list.size(); i++){
            sumVal += list.get(i).v;
            sum += list.get(i).s - list.get(i-1).s;

            //System.out.println(sumVal);

            if(sumVal == 0){
                if(i+1 < list.size() && list.get(i+1).s == list.get(i).s){

                }else{
                    max = Math.max(max, sum);
                    sum = 0;
                }
            }
        }

        System.out.println(max);

    }

    private static class Point implements Comparable<Point>{
        int s, v;
        public Point(int s, int v){
            this.s = s;
            this.v = v;
        }

        @Override
        public int compareTo(Point p){
            return this.s - p.s;
        }
    }
}