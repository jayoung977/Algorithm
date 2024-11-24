using System;

public class Solution {
    public int solution(int a, int b) {
        int first = int.Parse(a.ToString()+b.ToString());
        int second = 2*a*b;
        int answer = Math.Max(first,second);
        return answer;
    }
}