import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int widthMax = 0;
        int heightMax = 0;
        
        for(int i=0; i<sizes.length; i++){
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            widthMax = Math.max(widthMax, w);
            heightMax = Math.max(heightMax, h);
            
        }
        
        return widthMax * heightMax;
    }
}