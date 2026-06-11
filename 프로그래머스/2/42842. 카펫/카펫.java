class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        for(int i=1; i<=total; i++){
            if(total % i != 0){
                continue;
            }
            
            int height = total / i;
            
            if((height-2) * (i-2) == yellow){
                return new int[]{height, i};
            }
        }
        
        
        return new int[]{0, 0};
    }
}