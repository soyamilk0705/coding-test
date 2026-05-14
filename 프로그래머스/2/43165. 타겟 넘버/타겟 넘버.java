class Solution {
    static int answer = 0;
    
    public void dfs(int now, int[] numbers, int target, int sum){
        if(now == numbers.length){
            if(target == sum){
                answer++;
            }
            return;
        }
        
        dfs(now+1, numbers, target, sum + numbers[now]);
        dfs(now+1, numbers, target, sum - numbers[now]);
    }
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target, 0);
        
        return answer;
    }
}