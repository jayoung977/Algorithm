import java.util.*;
class Solution {
    public List solution(int[] progresses, int[] speeds) {
        Stack <Integer> stack = new Stack<>();
        int init =(int) Math.ceil((100.0-progresses[0])/speeds[0]);
        stack.push(init);
        // System.out.println(stack);
        System.out.println(init);
        int max_day = init;
        List<Integer> answer = new ArrayList<>();
        for(int i=1;i<progresses.length;i++){
            int day =(int) Math.ceil((100.0-progresses[i])/speeds[i]);
            System.out.println(day);
            if(day<=max_day){
                stack.push(day);
            }else{
                answer.add(stack.size());
                stack.clear();
                stack.push(day);
                max_day = stack.peek();
                
            }
        }
        answer.add(stack.size());


        
        
        return answer;
    }
}