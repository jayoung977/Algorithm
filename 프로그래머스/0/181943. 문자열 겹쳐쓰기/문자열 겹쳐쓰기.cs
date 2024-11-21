using System;

public class Solution {
    public string solution(string my_string, string overwrite_string, int s) {
        string answer = "";
        int Length = overwrite_string.Length;
        answer+=my_string.Substring(0,s);
        answer+=overwrite_string;
        answer+=my_string.Substring(s+Length);
        return answer;
    }
}