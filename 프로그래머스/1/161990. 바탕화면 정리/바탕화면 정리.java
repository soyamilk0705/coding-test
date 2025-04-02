import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = Integer.MAX_VALUE, luy = Integer.MAX_VALUE;
        int rdx = 0, rdy = 0;
        
        for(int i=0; i<wallpaper.length; i++){
            String[] temp = wallpaper[i].split("");
            
            for(int j=0; j<temp.length; j++){
                if(temp[j].equals("#")){
                    lux = Math.min(i, lux);
                    luy = Math.min(j, luy);
                    rdx = Math.max(i, rdx);
                    rdy = Math.max(j, rdy);
                    
                }
            }
        }
        
        int[] answer = {lux, luy, rdx+1, rdy+1};
        return answer;
    }
}