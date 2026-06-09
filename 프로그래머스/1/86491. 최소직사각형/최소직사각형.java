class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int weight = 0;
        int height = 0;
        
        
        for(int i=0; i<sizes.length; i++){
            
            if(sizes[i][0] < sizes[i][1]){
                weight = Math.max(weight, sizes[i][1]);
                height = Math.max(height, sizes[i][0]);
            } else {
                weight = Math.max(weight, sizes[i][0]);
                height = Math.max(height, sizes[i][1]);
            }
            
        }
        
        
        return weight * height;
    }
}