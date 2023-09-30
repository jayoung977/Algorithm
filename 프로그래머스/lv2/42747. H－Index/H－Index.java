import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for(int i=0; i<citations.length; i++){
            // System.out.println("i: "+i+", citations[i]: "+citations[i]);
            int sum=0;
            for(int j=0; j<citations.length; j++){
                if(citations[i]<=citations[j]){
                    sum++;
                }
            }
            // System.out.println("sum: "+sum);
            if(sum<=citations[i]){
                answer = Math.max(sum,answer);
                // System.out.println("answer: "+answer);
            }
        }
        
        return answer;
    }
}