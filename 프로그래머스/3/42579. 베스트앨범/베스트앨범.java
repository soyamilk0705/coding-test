import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        ArrayList<String> mapToGenres = new ArrayList<>();
        
        for(String item : map.keySet()){
            mapToGenres.add(item);
        }
        mapToGenres.sort(((o1, o2) -> map.get(o2) - map.get(o1)));
        
        for(String item : mapToGenres){
            ArrayList<music> musics = new ArrayList<>();
            for(int i=0; i<genres.length; i++){
                if(item.equals(genres[i])){
                    musics.add(new music(i, plays[i]));
                }
            }
            
            musics.sort(new Comparator<music>(){
                @Override
                public int compare(music o1, music o2){
                    if(o1.play == o2.play){
                        return o1.idx - o2.idx;
                    }
                    return o2.play - o1.play;
                }
            });
            
            answer.add(musics.get(0).idx);
            
            if(musics.size() != 1){
                answer.add(musics.get(1).idx);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    public static class music{
        int idx;
        int play;
        
        public music(int idx, int play){
            this.idx = idx;
            this.play = play;
        }
        
    }
}