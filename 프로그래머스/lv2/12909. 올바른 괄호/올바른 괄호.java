import java.util.*;
class Solution {
    boolean solution(String data) {
        boolean answer = true;
        // System.out.println(data.length());


        if(data.charAt(0) == ')') return false;
        if(data.charAt(data.length()-1)  == '(') return false;

        Stack <Character> stack = new Stack <> ();
        if(data.charAt(0)  == ')') return false;
        if(data.charAt(data.length()-1)  == '(') return false;

         // System.out.println(stack);
        
        for(int i=0; i<data.length(); i++){
            if(stack.size()>data.length()-i+1) return false;
            if(data.charAt(i) == '('){
                stack.push('(');
            }else {
                if(stack.size()==0) return false;
                else  stack.pop();         
            }
        }
        
        if(stack.size()>0){
            return false;
        }
        

        return true;
    }
}