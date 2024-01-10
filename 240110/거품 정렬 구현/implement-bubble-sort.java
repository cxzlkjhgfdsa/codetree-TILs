import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        int[] sort = new int[n];

        for(int i = 0; i < n; i++){
            sort[i] = sc.nextInt();
        }

        boolean sorted = false;

        while(!sorted){

            sorted = true;
            
            for(int i = 0; i < n-1; i++){
                if(sort[i] > sort[i+1]){
                    swap(i, i+1, sort);
                    sorted = false;
                }
            }

        }

        for(int next : sort){
            System.out.print(next+" ");
        }
    }

    public static void swap(int i , int j ,int[] sort){
        int tmp = sort[i];
        sort[i] = sort[j];
        sort[j] = tmp;
    }
}