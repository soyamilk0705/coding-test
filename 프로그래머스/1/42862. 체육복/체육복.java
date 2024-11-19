import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        List<Integer> reserveList = new ArrayList<>();
        for(int res : reserve){
            reserveList.add(res);
        }
        Collections.sort(reserveList);
        
        List<Integer> lostList = new ArrayList<>();
        
        for(int num : lost){
            if(reserveList.contains(num)){
                reserveList.remove(reserveList.indexOf(num));
                answer++;
            } else{
                lostList.add(num);
            }
        }
        
        Collections.sort(lostList);
        
        for(int i=0; i<lostList.size(); i++){
            int lostNum = lostList.get(i);
            int minusLost = lostNum - 1;
            int plusLost = lostNum + 1;
            
            if(reserveList.contains(minusLost)){
                reserveList.remove(reserveList.indexOf(minusLost));
                answer++;
            } else if(reserveList.contains(plusLost)){
                reserveList.remove(reserveList.indexOf(plusLost));
                answer++;
            }
            
        }
        

        return answer;
    }
}