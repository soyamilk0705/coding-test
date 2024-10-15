class Solution {
    static int answer = 0;
    
    public int solution(int M, int N) {
        int size = M*N;
        recursion(size);
        
        return answer;
    }
    
    static void recursion(int size){
        if(size != 1){
            answer++;
            recursion(size-1);
        }
        
        
    }
}