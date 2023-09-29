import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int idx=0;
        int sum=0;
        Queue <Integer> q= new LinkedList<>();
        for(int i=0; i<bridge_length; i++) q.offer(0);
        while(idx < truck_weights.length){
            sum-=q.poll();
            if(sum+truck_weights[idx]<=weight){
                sum+=truck_weights[idx];
                q.offer(truck_weights[idx++]);   
            }else{
                q.offer(0);
            }
            answer++;
        }

        while(!q.isEmpty()){
             answer++;
            q.poll();
        }
        return answer;
    }
}