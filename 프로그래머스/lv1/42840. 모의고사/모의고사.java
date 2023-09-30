import java.util.*;
class Solution {
    public  ArrayList<Integer> solution(int[] answers) {
        String first = "12345"; //5n
        String second = "21232425"; //8n
        String third = "3311224455"; //10n
        int [] answer = new int[3];
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0; i<answers.length; i++){
            int f = (i+1)%5==0? 4:(i+1)%5-1;
            int s = (i+1)%8==0? 7:(i+1)%8-1;
            int t = (i+1)%10==0? 9:(i+1)%10-1;
            // System.out.println("f: "+f+", s: "+s+", t: "+t);
            // System.out.println("first.charAt(f): "+first.charAt(f)+", second.charAt(s): "+ second.charAt(s)+",  third.charAt(t): "+third.charAt(t));
            
            if(answers[i] == first.charAt(f)-'0'){
                answer[0]++;
                // System.out.println(answers[i]);
            }
            if(answers[i] == second.charAt(s)-'0'){
                answer[1]++;
                // System.out.println(answers[i]);
            }
            if(answers[i] == third.charAt(t)-'0'){
                answer[2]++;
                // System.out.println(answers[i]);
            }
        }
        int max = Math.max(answer[0],answer[1]);
        max = Math.max(answer[2],max);
        for(int i=0; i<answer.length; i++){
            if(answer[i]==max){
                temp.add(i+1);
            }
        }
        Collections.sort(temp);
        System.out.println(temp);
        
        // Collections.sort(answer);
        
        
        
        
        return temp;
    }
}