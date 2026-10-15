class Solution {
    static int zeroCnt = 0;
    static int oneCnt = 0;
    
    public int[] solution(int[][] arr) {
        zeroCnt = 0;
        oneCnt = 0;
        
        recur(arr, 0, 0, arr.length);
        
        return new int[]{zeroCnt, oneCnt};
    }
    
    public void recur(int[][] arr, int x, int y, int n){
        int value = arr[x][y];
        
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(arr[i][j] != value){
                    int half = n / 2;
                    
                    recur(arr, x, y, half);
                    recur(arr, x, y+half, half);
                    recur(arr, x+half, y, half);
                    recur(arr, x+half, y+half, half);
                    return;
                }
            }
        }
        
        if(value == 0){
            zeroCnt++;
        } else{
            oneCnt++;
        }
    }
}