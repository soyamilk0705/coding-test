class Solution {
    boolean solution(String s) {
        int pCnt = 0;
        int yCnt = 0;
        
        for(char c : s.toCharArray()){
            if(Character.toLowerCase(c) == 'p'){
                pCnt++;
            } else if(Character.toLowerCase(c) == 'y') {
                yCnt++;
            }
        }
        
        
        return pCnt == yCnt ? true : false;
    }
}