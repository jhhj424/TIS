package leetcode;

import java.util.Arrays;

public class _0001TwoSum {
    public static void main(String[] args) {
        int[] nums;
        int target;
        nums = new int[]{2, 7, 11, 15};
        target = 9;

        int[] ans = new int[2];

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}
