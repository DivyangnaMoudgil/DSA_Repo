import java.util.*;

public class lc_102 {
static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public static List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> q = new ArrayDeque<>();
    List<List<Integer>> res = new ArrayList<>();

    if (root == null) {
        return res;
    }

    q.offer(root);

    while (!q.isEmpty()) {
        List<Integer> lvl = new ArrayList<>();
        int n = q.size();

        while (n != 0) {
            TreeNode current = q.poll();

            // Store the value of the current node
            lvl.add(current.val);

            if (current.left != null) {
                q.offer(current.left);
            }

            if (current.right != null) {
                q.offer(current.right);
            }

            n--;
        }

        res.add(lvl);
    }

    return res;
}

public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    System.out.println(levelOrder(root));
}
}
