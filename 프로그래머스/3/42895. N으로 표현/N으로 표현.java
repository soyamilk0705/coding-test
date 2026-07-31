import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        
        dp.add(new HashSet<>());
        
        for(int i=1; i<=9; i++){
            dp.add(new HashSet<>());
            
            int num = 0;
            for(int j=0; j<i; j++){
                num = num * 10 + N;
            }
            dp.get(i).add(num);
            
            for(int j=1; j<i; j++){
                for(int a : dp.get(j)){
                    for(int b : dp.get(i-j)){
                        dp.get(i).add(a*b);
                        dp.get(i).add(a+b);
                        dp.get(i).add(a-b);
                        
                        if(b != 0){
                            dp.get(i).add(a/b);
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