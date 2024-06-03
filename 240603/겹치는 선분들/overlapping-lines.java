import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int curIdx = 0;

        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Point> list = new ArrayList<>();

        for(int i = 0; i < N; i++){

            int dis = sc.nextInt();
            String dir = sc.next();

            if("R".equals(dir)){
                list.add(new Point(curIdx, 1));
                list.add(new Point(curIdx + dis , -1));
                curIdx = curIdx + dis;
            }else{
                list.add(new Point(curIdx, -1));
                list.add(new Point(curIdx-dis, 1));
                curIdx = curIdx - dis;
            }

        }

        Collections.sort(list);

        int sumVal = 0;
        int ans = 0;

        for(int i = 0; i < list.size(); i++){
            //System.out.println(list.get(i).s + " " + list.get(i).v);
            sumVal += list.get(i).v;
            if(sumVal >= K)
                ans++;
        }

        System.out.println(ans);

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