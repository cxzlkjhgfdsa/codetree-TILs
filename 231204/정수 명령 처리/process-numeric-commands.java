import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            String s = sc.next();
            
            switch(s){
                case "push":
                    int num = sc.nextInt();
                    stack.add(num);
                    break;
                case "pop":
                    System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(stack.isEmpty()){
                        System.out.println(1);
                    }else{
                         System.out.println(0);
                    }
                    break;
                case "top":
                    System.out.println(stack.peek());
                    break;
            }
            

        }
    }
}