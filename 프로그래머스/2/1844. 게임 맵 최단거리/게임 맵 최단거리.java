import java.util.*;

class Solution {
    public class Robot{
        int x;
        int y;
        int cnt;
        
        public Robot(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        visited = new boolean[n][m];
        visited[0][0] = true;
      
        if(n == 1 && m == 1){
            return 1;
        }
        
        Robot robot = new Robot(0, 0, 1); 
        Queue<Robot> queue = new LinkedList<>();
        queue.offer(robot);
        
        while(!queue.isEmpty()){
            Robot r = queue.poll();
            
            for(int i=0; i<4; i++){
                int tx = dx[i] + r.x;
                int ty = dy[i] + r.y;
                
                if(tx > -1 && tx < n && ty > -1 && ty < m && !visited[tx][ty] && maps[tx][ty] == 1){
                    if(tx == n - 1 && ty == m - 1){
                        return r.cnt+1;
                    } else{
                        visited[tx][ty] = true;
                        queue.offer(new Robot(tx, ty, r.cnt+1));
                    }
                }
            }
        }
        
        
        return -1;
    }
}