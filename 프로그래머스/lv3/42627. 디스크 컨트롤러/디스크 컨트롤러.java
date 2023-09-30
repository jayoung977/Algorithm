import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs,(o1,o2)->o1[0]-o2[0]); //오름차순 정렬 
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        int idx=0;
        int cnt=0;
        int total=0;
        int end=0;

        while(cnt<jobs.length){
            while(idx<jobs.length && jobs[idx][0]<=end){
                pq.offer(jobs[idx++]);
            }
            if(pq.isEmpty()) end = jobs[idx][0]; //end= 현재작업소요시간 
            else{
                int[] cur = pq.poll();
                total += cur[1]+end-cur[0];
                end+=cur[1];
                cnt++;
            }
        }
        
        return total/jobs.length;
    }
}