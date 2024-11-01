import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int j = commands[i][0] - 1;
            int k = commands[i][1];
            int[] arr = Arrays.copyOfRange(array, j, k);
            quickSort(arr, 0, arr.length-1);
            answer[i] = arr[commands[i][2] - 1];
            
        }
        
        return answer;
    }
    
    public static void quickSort(int[] arr, int start, int end){
        if(start < end){
            int pivotIndex = partition(arr, start, end);
            
            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
    }
    
    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int i = start - 1;
        
        for(int j=start; j<end; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
       
        swap(arr, i+1, end);
        return i+1;
    }
    
     private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}