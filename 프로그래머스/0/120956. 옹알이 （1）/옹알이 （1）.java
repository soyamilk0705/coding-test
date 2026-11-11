class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String babb : babbling){
            babb = babb.replace("aya", " ");
            babb = babb.replace("ye", " ");
            babb = babb.replace("woo", " ");
            babb = babb.replace("ma", " ");
            
            if(babb.trim().isEmpty()){
                answer++;
            }
        }
        
        
        return answer;
    }
}