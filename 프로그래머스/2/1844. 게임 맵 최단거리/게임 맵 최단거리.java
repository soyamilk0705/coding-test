import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static class Robot {
        int x;
        int y;
        int cnt;
        
        public Robot(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        if(n == 1 && m == 1){
            return 1;
        }
        
        Queue<Robot> queue = new LinkedList<>();
        queue.offer(new Robot(0, 0, 1));
        
        while(!queue.isEmpty()){
            Robot robot = queue.poll();
            
            for(int i=0; i<4; i++){
                int lx = robot.x + dx[i];
                int ly = robot.y + dy[i];
                
                if(lx >= 0 && ly >= 0 && lx < n && ly < m && !visited[lx][ly] && maps[lx][ly] == 1){
                    
                    if(lx == n-1 && ly == m-1){
                        return robot.cnt+1; 
                    } else{
                        visited[lx][ly] = true;
                        queue.offer(new Robot(lx, ly, robot.cnt+1));
                    }
                }
            }
        }
        
        return -1;
    }
}