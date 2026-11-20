import java.util.*;

class Solution {
    int maxDiff = 0;
    int[] answer = {-1};
    
    public int[] solution(int n, int[] info) {
        int[] lion = new int[11];
        
        dfs(0, n, lion, info);
        
        return answer;
        
    }
    
    public void dfs(int idx, int remain, int[] lion, int[] info){
        if(idx == 11){
            lion[10] = remain;
            
            int apeachScore = 0;
            int lionScore = 0;
            
            for(int i=0; i<11; i++){
                if(info[i] == 0 && lion[i] == 0){
                    continue;
                }
                
                if(info[i] >= lion[i]){
                    apeachScore += 10 - i;
                } else{
                    lionScore += 10 - i;
                }
            }
            
            int diff = lionScore - apeachScore;
            
            if(diff > 0 && diff >= maxDiff){
                if(diff > maxDiff || isBetter(lion)){
                    maxDiff = diff;
                    answer = lion.clone();
                }
            }
            
            return;
        }
        
        if(remain > info[idx]){
            lion[idx] = info[idx] + 1;
            dfs(idx+1, remain - lion[idx], lion, info);
            lion[idx] = 0;
        }
        
        dfs(idx+1, remain, lion, info);
        
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