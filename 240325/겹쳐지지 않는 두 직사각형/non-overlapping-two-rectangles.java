import java.util.*;
import java.io.*;

public class Main {

    static int max, n, m;
    static int[][] area;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[];
        
        input = br.readLine().split(" "); // n, m 을 입력받음
        max = -1000000;  // 구해야하는 최대값의 초가값을 충분히 낮게 초기화

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        area = new int[n][m]; // 영역 정보를 저장할 2차원 배열

        for(int i = 0; i < n; i++){  // 영역 정보를 입력받음
            input = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                area[i][j] = Integer.parseInt(input[j]);
            }
        }

        makeFirstRect();
        System.out.println(max);
        
    }
    /*
     * 사각형은 왼쪽위의 점과 오른쪽 아래의 점으로 표현한다
     * 문제 풀이의 아이디어는 bruteforce 로 전부 탐색한 후 겹치는 사각형은 걸러낸 후 최대 값을 구한다
    */
    private static void makeFirstRect(){

        for(int x1 = 0; x1 < n; x1++){
            for(int y1 = 0; y1 < m; y1++){
                for(int x2 = x1; x2 < n; x2++){
                    for(int y2 = y1; y2 < m; y2++){
                        makeSecondRect(x1, y1, x2, y2);
                    }
                }
            }
        }
    }
    /*
     * 두번 째 사각형을 생성한 후 비교하는 메서드를 통해 확인
    */
    private static void makeSecondRect(int rx1, int ry1, int rx2, int ry2){
        for(int x1 = 0; x1 < n; x1++){
            for(int y1 = 0; y1 < m; y1++){
                for(int x2 = x1; x2 < n; x2++){
                    for(int y2 = y1; y2 < m; y2++){
                        checkDuplicate(rx1, ry1, rx2, ry2, x1, y1, x2, y2);
                    }
                }
            }
        }
    }

    private static void checkDuplicate(int ax1, int ay1, int ax2, int ay2, 
    int bx1, int by1, int bx2, int by2){

        boolean[][] visited = new boolean[n][m]; // 겹치는 부분이 있는지 확인할 boolean 2차원 배열
        int sum = 0;

        for(int i = ax1; i <= ax2; i++){
            for(int j = ay1; j <= ay2; j++){
                visited[i][j] = true;
                sum += area[i][j];
            }
        }

        for(int i = bx1; i <= bx2; i++){
            for(int j = by1; j <= by2; j++){
                if(visited[i][j])
                    return;
                sum += area[i][j];
            }
        }

        max = Math.max(max, sum);  // 최대값 갱신

    }
}