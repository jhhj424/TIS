package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/permutations/
*/
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int depth = 0;
        permutation(nums, depth, answer);
        return answer;
    }

    private void permutation(int[] nums, int depth, List<List<Integer>> answer) {
        if (depth == nums.length - 1) {
            List<Integer> temp = new ArrayList<>();
            for (int item : nums) {
                temp.add(item);
            }
            answer.add(temp);
            return;
        }
        for (int i = depth; i < nums.length; i++) {
            swap(nums, depth, i);
            permutation(nums, depth + 1, answer);
            swap(nums, depth, i);
        }
    }

    private void swap(int[] nums, int depth, int i) {
        int temp = nums[depth];
        nums[depth] = nums[i];
        nums[i] = temp;
    }
}
