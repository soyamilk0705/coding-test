import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    static char[] nums;
    
    public int solution(String numbers) {
        nums = numbers.toCharArray();
        visited = new boolean[nums.length];
        
        dfs("");
        
        int answer = 0;
        
        for(int num : set){
            if (isPrime(num)){
                answer++;
            }
        }
        
        return answer;
    }
    
    static void dfs(String current){
        if(!current.isEmpty()){
            set.add(Integer.parseInt(current));
        }
        
        for(int i=0; i<nums.length; i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            dfs(current + nums[i]);
            visited[i] = false;
        }
    }
    
    static boolean isPrime(int num){
        if (num < 2) {
            return false;
        }
        
        for(int i=2; i*i <= num; i++){
            if(num % i == 0){
                return false;
            }
        }
        
        return true;
    }
}