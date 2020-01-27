package SS19;

public class BST {
    private static class TreeNode {
        private int rank, val;
        private TreeNode left, right;

        private TreeNode(int rank, int val, TreeNode left, TreeNode right) {
            /* */
        }
    }
    private TreeNode root = null;
    
    static int length(TreeNode t) {
        if (t == null) {
            return 0;
        } else {
            return t.rank + length(t.right);
        }        
    }

    void add(int idx, int value) {
        this.root = insert(this.root, idx, value);
    }
    static TreeNode insert(TreeNode t, int idx, int val) {
        if (t == null) {
            return new TreeNode(1, val, null, null);
        } else if (idx < t.rank) {
            t.rank += 1;
            t.left = insert(t.left, idx, val);
        } else {
            t.right = insert(t.right, idx-t.rank, val);
        }
        return t;
    }

    static TreeNode get(TreeNode t, int idx) {
        while (idx != t.rank-1) {
            if (idx < t.rank-1) {
                t = t.left;
            } else {
                idx -= t.rank;
                t = t.right;
            }
        }
        return t;
    }

    static TreeNode getRe(TreeNode t, int idx) {
        if (idx < t.rank-1) {
            return getRe(t.left, idx);
        } else if (idx != t.rank-1) {
            return get(t.right, idx-t.rank);
        } else {
            return t;
        }
    }
}