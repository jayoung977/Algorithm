using System;

public class Solution {
    public int solution(int a, int b) {
        String sa = a.ToString();
        String sb = b.ToString();
        int ab = int.Parse(sa+sb);
        int ba = int.Parse(sb+sa);
        int answer = ab>ba? ab:ba;
        return answer;
    }
}