import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        
        dp.add(new HashSet<>());
        
        for(int i=1; i<=8; i++){
            dp.add(new HashSet<>());
            
            int cnt = 0;
            for(int j=0; j<i; j++){
                cnt = cnt * 10 + N;
            }
            dp.get(i).add(cnt);
            
            
            for(int j=1; j<i; j++){
                for(int n1 : dp.get(j)){
                    for(int n2 : dp.get(i-j)){
                        dp.get(i).add(n1 + n2);
                        dp.get(i).add(n1 - n2);
                        dp.get(i).add(n1 * n2);
                        
                        if(n2 != 0){
                            dp.get(i).add(n1 / n2);
                        }
                    }
                }
            }
            
            if(dp.get(i).contains(number)){
                return i;
            }
            
            
        }
        
        
        return -1;
    }
}