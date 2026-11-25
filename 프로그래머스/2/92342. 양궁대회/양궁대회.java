import java.util.*;

class Solution {
    static int maxDiff;
    static int[] answer = {-1};
    
    public int[] solution(int n, int[] info) {
        int[] lion = new int[11];
        
        dfs(n, info, 0, lion);
        
        return answer;
    }
    
    public void dfs(int remain, int[] info, int idx, int[] lion){
        if(idx == 11){
            lion[10] = remain;
            
            int lionScore = 0;
            int apeachScore = 0;
            
            for(int i=0; i<11; i++){
                if(info[i] == 0 && lion[i] == 0){
                    continue;
                } 
                
                if(info[i] < lion[i]){
                    lionScore += 10-i;
                } else{
                    apeachScore += 10-i;
                }
                
            }
            
            int diff = lionScore - apeachScore;
            
            if(diff > 0 && diff >= maxDiff){
                if(diff > maxDiff || isBetter(lion)){
                    maxDiff = diff;   
                    answer = Arrays.copyOf(lion, lion.length);
                }
            }
            
            return;
        }
        
        if(remain > info[idx]){
            lion[idx] = info[idx] + 1;
            dfs(remain - lion[idx], info, idx+1, lion);
            lion[idx] = 0;
        }
        
        dfs(remain, info, idx+1, lion);
    }
    
    public boolean isBetter(int[] lion){
        for(int i=10; i>=0; i--){
            if(lion[i] != answer[i]){
                return lion[i] > answer[i];
            }
        }
        
        return false;
    }
}