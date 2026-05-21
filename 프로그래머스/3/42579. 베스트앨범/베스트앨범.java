import java.util.*;

class Solution {
    class Record {
        int idx;
        int plays;
        
        public Record(int idx, int plays){
            this.idx = idx;
            this.plays = plays;
        }
        
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<Record>> recordMap = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            
            List<Record> records;
            if(recordMap.containsKey(genres[i])){
                records = recordMap.get(genres[i]);
            } else{
                records = new ArrayList<>();
            }
            records.add(new Record(i, plays[i]));
            recordMap.put(genres[i], records);
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        
        for(Map.Entry<String, Integer> entry : list){
            String key = entry.getKey();
            List<Record> records = recordMap.get(key);
            
            Collections.sort(records, (o1, o2) -> {
                if(o2.plays == o1.plays){
                    return o1.idx - o2.idx;
                }
                return o2.plays - o1.plays;
            });
            
            for(int i=0; i<Math.min(2, records.size()); i++){
                answer.add(records.get(i).idx);
            }
            
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}