import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        
        dfs("", numbers);
    
        for(int num : set){
            if(isPrime(num)){
                answer++;
            }
        }
        return answer;
    }
    
    
    public void dfs(String c, String numbers){
        if(!c.equals("")){
            set.add(Integer.parseInt(c));
        }
        
        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(c + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
        
    }
    
    public boolean isPrime(int num){
        if(num <= 1){
            return false;
        }
            
        for(int i=2; i*i<=num; i++){
            if(num % i == 0){
                return false;
            }
        }
        
        return true;
    }
}