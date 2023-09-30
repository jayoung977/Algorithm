import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int maxh=0;
        int maxw=0;
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0]<sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            maxh=Math.max(sizes[i][0],maxh);
            maxw=Math.max(sizes[i][1],maxw);
            
        }
        
        
        
        // System.out.println(Arrays.deepToString(sizes));
        int answer = maxh*maxw;
        return answer;
    }
}