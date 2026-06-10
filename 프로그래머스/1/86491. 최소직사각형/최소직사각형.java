import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int weight = 0;
        int height = 0;
        
        for(int[] card : sizes){
            int w = Math.max(card[0], card[1]);
            int h = Math.min(card[0], card[1]);
            
            weight = Math.max(weight, w);
            height = Math.max(height, h);
        }
        
        return weight * height;
    }
}