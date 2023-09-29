import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q=new LinkedList<>();
        int sum =0;
        int time=0;
        for(int truck:truck_weights){
            while(true){
                if(q.isEmpty()){
                    q.offer(truck);
                    sum+=truck;
                    time++;
                    break;
                }else if(q.size()==bridge_length){
                    sum-=q.poll();
                }else{
                    if(sum+truck<=weight){
                        q.offer(truck);
                        sum+=truck;
                        time++;
                        break;
                    }else{
                        q.offer(0);
                        time++;
                    }
                }
            }
            
        }

        return time+bridge_length;
    }
}