import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = Integer.MAX_VALUE, luy = Integer.MAX_VALUE;
        int rdx = 0, rdy = 0;
        
        for(int i=0; i<wallpaper.length; i++){
            String[] temp = wallpaper[i].split("");
            
            
            for(int j=0; j<temp.length; j++){
                if(temp[j].equals("#")){
                    if(i < lux){
                        lux = i;
                    }
                    
                    if(j < luy){
                        luy = j;
                    }
                    
                    if((i+1) > rdx){
                        rdx = i+1;
                    }
                    
                    if((j+1) > rdy){
                        rdy = j+1;
                    }
                }
            }
        }
        
        int[] answer = {lux, luy, rdx, rdy};
        return answer;
    }
}