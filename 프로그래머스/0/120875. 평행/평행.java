import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        if(parallel(dots[0], dots[1], dots[2], dots[3])){
            return 1;
        }
        
        if(parallel(dots[0], dots[2], dots[1], dots[3])){
            return 1;
        }
        
        if(parallel(dots[0], dots[3], dots[1], dots[2])){
            return 1;
        }
        
        return 0;
    }
    
    boolean parallel(int[] p1, int[] p2, int[] p3, int[] p4){
        int x1 = p1[0];
        int y1 = p1[1];
        int x2 = p2[0];
        int y2 = p2[1];
        int x3 = p3[0];
        int y3 = p3[1];
        int x4 = p4[0];
        int y4 = p4[1];
        
        return (y2 - y1) * (x4 - x3) == (y4 - y3) * (x2 - x1);
    }
}