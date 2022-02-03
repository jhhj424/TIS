package leetcode;

public class _0110BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int depthL = depth(root.left);
        int depthR = depth(root.right);

        return Math.abs(depthL - depthR) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int depthL = depth(node.left);
        int depthR = depth(node.right);

        return Math.max(depthL, depthR) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
