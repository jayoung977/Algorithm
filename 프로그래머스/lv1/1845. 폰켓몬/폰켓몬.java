import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int max = nums.length/2;
        //중복 제거하기
        HashSet<Integer> numSet = new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        }
        //중복을 제거한 셋의 크기가 max보다 크면 max를 , 작으면 numSet의 size를 리턴
        if(numSet.size() > max){
            return max;
        }else{
            return numSet.size();
        }
    }
}