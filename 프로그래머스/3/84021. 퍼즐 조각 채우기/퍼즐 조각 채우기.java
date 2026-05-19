import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    List<List<Point>> boards = new ArrayList<>();
    List<List<Point>> tables = new ArrayList<>();
    static boolean[][] visitedBoard;
    static boolean[][] visitedTable;
    
    public class Point {
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public void findBoard(List<Point> points, int rootX, int rootY, int x, int y, int[][] game_board, int n){
        for(int k=0; k<4; k++){
            int lx = x + dx[k];
            int ly = y + dy[k];

            if(lx >= 0 && lx < n && ly >= 0 && ly < n && !visitedBoard[lx][ly] && game_board[lx][ly] == 0){
                visitedBoard[lx][ly] = true;
                points.add(new Point(lx - rootX, ly - rootY));
                findBoard(points, rootX, rootY, lx, ly, game_board, n);
            }
        }   
    }
    
    
    public void findTable(List<Point> points, int rootX, int rootY, int x, int y, int[][] table, int n){
        for(int k=0; k<4; k++){
            int lx = x + dx[k];
            int ly = y + dy[k];

            if(lx >= 0 && lx < n && ly >= 0 && ly < n && !visitedTable[lx][ly] && table[lx][ly] == 1){
                visitedTable[lx][ly] = true;
                points.add(new Point(lx - rootX, ly - rootY));
                findTable(points, rootX, rootY, lx, ly, table, n);
            }
        }
        
    }
    
    public List<Point> rotate(List<Point> points){
        List<Point> rotated = new ArrayList<>();
        
        for(Point p : points){
            rotated.add(new Point(p.y, -p.x));
        }
        
        return normalize(rotated);
    }
    
    public List<Point> normalize(List<Point> points){
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        for(Point p : points){
            minX = Math.min(minX, p.x);
            minY = Math.min(minY, p.y);
        }
        
        List<Point> normalized = new ArrayList<>();
        
        for(Point p : points){
            normalized.add(new Point(p.x - minX, p.y - minY));
        }
        
        Collections.sort(normalized, (a, b) -> {
            if(a.x == b.x){
                return a.y - b.y;
            }
            return a.x - b.x;
        });
        return normalized;
    }
    
    public boolean isSame(List<Point> a, List<Point> b){
        if(a.size() != b.size()){
            return false;
        }
        
        for(int i=0; i<a.size(); i++){
            if(a.get(i).x != b.get(i).x ||
              a.get(i).y != b.get(i).y){
                return false;
            }
        }
        
        return true;
    }
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        int n = game_board.length;
        visitedBoard = new boolean[n][n];
        visitedTable = new boolean[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visitedBoard[i][j] && game_board[i][j] == 0){
                    List<Point> points = new ArrayList<>();
                    points.add(new Point(0, 0));
                    visitedBoard[i][j] = true;
                    
                    findBoard(points, i, j, i, j, game_board, n);
                    
                    boards.add(normalize(points));
                }
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visitedTable[i][j] && table[i][j] == 1){
                    List<Point> points = new ArrayList<>();
                    points.add(new Point(0, 0));
                    visitedTable[i][j] = true;
                    
                    findTable(points, i, j, i, j, table, n);
                    
                    tables.add(normalize(points));
                }
            }
        }
        
        boolean[] used = new boolean[tables.size()];
        
        for(List<Point> board : boards) {
            for(int i=0; i<tables.size(); i++){
                if(used[i]){
                    continue;
                }
                
                List<Point> puzzle = tables.get(i);
                
                boolean matched = false;
                
                for(int r=0; r<4; r++){
                    if(isSame(board, puzzle)){
                        answer += board.size();
                        used[i] = true;
                        matched = true;
                        break;
                    }
                    
                    puzzle = rotate(puzzle);
                }
                
                if(matched){
                    break;
                }
            }
        }
             
        return answer;
    }
}