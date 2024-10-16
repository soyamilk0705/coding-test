class Solution {
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    static void dfs(int[] numbers, int target, int n, int total){
        if(n == numbers.length){
            if(total == target){
                answer++;
            }
            return;
        }
        
      
        dfs(numbers, target, n + 1, total + numbers[n]);
        dfs(numbers, target, n + 1, total - numbers[n]);
   
        
        
    }
}