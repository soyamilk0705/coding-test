class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] talk = {"aya", "ye", "woo", "ma"};
        
        for(int i=0; i<babbling.length; i++){
            for(String t : talk){
                if(babbling[i].contains(t)){
                    babbling[i] = babbling[i].replace(t, " ");
                }
            }
        }
        
        for(String b : babbling){
            if(b.trim().equals("")){
                answer++;
            }
        }
        
        
        return answer;
    }
}