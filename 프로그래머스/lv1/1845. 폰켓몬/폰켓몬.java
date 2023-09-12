import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int max = nums.length/2;
        int answer = set.size() > max? max:set.size();
        return answer;
    }
}