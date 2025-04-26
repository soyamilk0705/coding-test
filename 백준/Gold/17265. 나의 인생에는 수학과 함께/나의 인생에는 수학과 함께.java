import java.io.*;

public class Main {
    static int max = -99999, min = 99999;
    static int N;
    static char map[][] = new char[5][5];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void DFS(int i, int j, int nowResult, char operator) throws IOException {
        if (i >= N || j >= N) {
            return;
        }
        
        if ((i + j) % 2 == 0) {
            if (operator == '+') {
                nowResult += Character.getNumericValue(map[i][j]);
            }
            if (operator == '-') {
                nowResult -= Character.getNumericValue(map[i][j]);
            }
            if (operator == '*') {
                nowResult *= Character.getNumericValue(map[i][j]);
            }
            if (i == N - 1 && j == N - 1) {
                if (max < nowResult)
                    max = nowResult;
                if (min > nowResult)
                    min = nowResult;
                return;
            }
          
            else {
                DFS(i + 1, j, nowResult, '0');
                DFS(i, j + 1, nowResult, '0');
            }
        } 
        else {
            DFS(i + 1, j, nowResult, map[i][j]);
            DFS(i, j + 1, nowResult, map[i][j]);
        }

    }

    public static void main(String[] args) throws IOException {
         N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = input[j].charAt(0);
            }
        }

        DFS(0, 0, Character.getNumericValue(map[0][0]), '0');

        bw.write(max + " " + min);
        bw.flush();
        bw.close();
    }
}