using System;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        bool isEven = true;
        if (n%2!=0)
            isEven=false;
            
        for (int i=1;i<=n; i++)
            if(isEven&&i%2==0)
                answer+=i*i;
            else if(!isEven&&i%2!=0)
                answer+=i;
            
            
            
        return answer;
    }
}