import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[][] dp;
    
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int n = triangle.length;
        dp = new int[n][n];
        
        for(int j=0; j<triangle[n-1].length; j++){
            dp[n-1][j] = triangle[n-1][j];
        }    
    
        
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<triangle[i].length; j++){
                dp[i][j] = triangle[i][j]
                    + Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        
        
        return dp[0][0];
    }
    
}