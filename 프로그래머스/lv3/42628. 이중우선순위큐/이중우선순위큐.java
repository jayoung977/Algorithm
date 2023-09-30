import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pqA = new PriorityQueue<>((o1,o2)->o1-o2);
        PriorityQueue<Integer> pqD = new PriorityQueue<>((o1,o2)->-(o1-o2));
        for(String s:operations){
            if(s.contains("I ")){
                int num = Integer.parseInt(s.substring(2));
                pqA.offer(num);
                pqD.offer(num);
            }else if(s.equals("D -1")){
                if(pqA.size()==0) continue;
                pqA.poll();
                pqD.clear();
                for(int p:pqA) pqD.offer(p);
                
            }else{
                if(pqD.size()==0) continue;
                pqD.poll();
                pqA.clear();
                for(int p:pqD) pqA.offer(p);
            }
        }
        
         if(pqA.size()==0){
            answer = new int[] {0,0};
             return answer;
        }
        answer  = new int[] {pqD.poll(),pqA.poll()};

        return answer;
    }
}