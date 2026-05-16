class Solution {
    public int dfs (int sum, int now, int[] numbers, int target){
        if(now == numbers.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }
        
        return dfs(sum + numbers[now], now+1, numbers, target)
            + dfs(sum - numbers[now], now+1, numbers, target);
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer = dfs(0, 0, numbers, target);
        
        return answer;
    }
}