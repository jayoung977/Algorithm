import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int[] cur = commands[i];
            int[] temp = new int[(cur[1]-cur[0])+1];
            temp = Arrays.copyOfRange(array,cur[0]-1,cur[1]);
            Arrays.sort(temp);
            answer[i] = temp[cur[2]-1];
            // System.out.println(Arrays.toString(temp));
        }
        
        return answer;
    }
}