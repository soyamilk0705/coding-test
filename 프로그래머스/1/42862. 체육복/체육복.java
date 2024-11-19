import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        HashSet<Integer> reserveList = new HashSet<>();
        HashSet<Integer> lostList = new HashSet<>();
        
        for(int res : reserve){
            reserveList.add(res);
        }
        
        for(int lo : lost){
            if(reserveList.contains(lo)){
                reserveList.remove(lo);
                answer++;
            } else{
                lostList.add(lo);
            }
        }
        
        for(int lostNum : lostList){
            if(reserveList.contains(lostNum - 1)){
                reserveList.remove(lostNum - 1);
                answer++;
            } else if(reserveList.contains(lostNum + 1)){
                reserveList.remove(lostNum + 1);
                answer++;
            }
            
        }
        

        return answer;
    }
}