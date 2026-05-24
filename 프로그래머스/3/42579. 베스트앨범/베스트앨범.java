import java.util.*;

class Solution {
    class Music {
        int idx;
        int cnt;
        
        public Music(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> totalMap = new HashMap<>();
        Map<String, List<Music>> musicMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
            musicMap.computeIfAbsent(genres[i], k -> new ArrayList<>())
                .add(new Music(i, plays[i]));
        }
        
        List<String> genresSort = new ArrayList<>(totalMap.keySet());
        genresSort.sort((a, b) -> totalMap.get(b) - totalMap.get(a));
        
        for(String genre : genresSort){
            List<Music> musics = musicMap.get(genre);
            musics.sort((a, b) -> b.cnt - a.cnt);
            
            for(int i=0; i<Math.min(2, musics.size()); i++){
                
                answer.add(musics.get(i).idx);
            }
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}