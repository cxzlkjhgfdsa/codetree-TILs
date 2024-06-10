import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Room> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            pq.add(new Room(sc.nextInt(), sc.nextInt()));
        }

        int ans = 0;
        int curTime = 0;

        while(!pq.isEmpty()){
            
            Room r = pq.poll();

            if(r.s >= curTime){
                ans++;
                curTime = r.e;
            }

        }

        System.out.println(ans);

    }

    private static class Room implements Comparable<Room>{
        int s, e;
        public Room(int s, int e){
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Room r){
            return this.e - r.e;
        }
    }
}