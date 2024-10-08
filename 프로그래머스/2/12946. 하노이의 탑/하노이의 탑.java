import java.util.*;

class Solution {
    private static List<int[]> ansList;
    
    public int[][] solution(int n) {
        ansList = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        
        int[][] answer = new int[ansList.size()][];
        
        for(int i=0; i<ansList.size(); i++){
            answer[i] = ansList.get(i);
        }
        
        return answer;
    }
    
    public void hanoi(int n, int start, int end, int mid){
        if(n==1){
            ansList.add(new int[]{start, end});
        } else{
            hanoi(n-1, start, mid, end); // 1번 기둥의 n-1개를 2으로 이동
            ansList.add(new int[]{start, end}); // 가장 큰 n을 3으로 이동
            hanoi(n-1, mid, end, start); // 2번 기둥의 n-1개를 3으로 이동
        }
    }
}