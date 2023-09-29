import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++) pq.offer(scoville[i]);
        while(true){
            if(pq.size()<2){
                if(pq.peek()<K) {
                    answer = -1;
                    break;
                } else break;
            }else{
                if(pq.peek()<K){
                    int first = pq.poll();
                    int second = pq.poll();
                    int newK = first + (second*2);
                    pq.offer(newK);
                    answer++;
                }else break;
            }
        }
        return answer;
    }
}