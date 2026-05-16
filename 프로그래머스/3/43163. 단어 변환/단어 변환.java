class Solution {
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    
    public void dfs(int result, String begin, String target, String[] words){
        if(begin.equals(target)){
            answer = Math.min(answer, result);
        }
        
        for(int i=0; i<words.length; i++){
            if(!visited[i]) {
                int cnt = 0;
                
                for(int j=0; j<words[i].length(); j++){
                    if(words[i].charAt(j) == begin.charAt(j)){
                        cnt++;
                    }
                }
                
                if(cnt == begin.length() - 1){
                    visited[i] = true;
                    dfs(result+1, words[i], target, words);
                    visited[i] = false;
                }
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(0, begin, target, words);
        
        if(answer == Integer.MAX_VALUE){
            return 0;
        }
        
        return answer;
    }
}