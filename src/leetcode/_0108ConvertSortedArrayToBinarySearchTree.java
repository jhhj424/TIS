package leetcode;

public class _0108ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        int mid = (i + j) / 2;
        TreeNode res = new TreeNode(nums[mid]);
        if (i == j) {
            return res;
        }
        res.left = sortedArrayToBST(nums, i, mid - 1);
        res.right = sortedArrayToBST(nums, mid + 1, j);
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
