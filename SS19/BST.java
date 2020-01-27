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
    
    static int lengthRE(TreeNode t) {
        if (t == null) {
            return 0;
        } else {
            return t.rank + lengthRE(t.right);
        }        
    }

    static int lengthIT(TreeNode t) {
        if (t == null) {
            return 0;
        } else {
            TreeNode curr = t;
            int len = curr.rank;
            while (curr.right != null) {
                curr = curr.right;
                len += curr.rank;
            }
            return len;
        }
    }

    void addRE(int idx, int value) {
        this.root = insertRE(this.root, idx, value);
    }
    static TreeNode insertRE(TreeNode t, int idx, int val) {
        if (t == null) {
            return new TreeNode(1, val, null, null);
        } else if (idx < t.rank) {
            t.rank += 1;
            t.left = insertRE(t.left, idx, val);
        } else {
            t.right = insertRE(t.right, idx-t.rank, val);
        }
        return t;
    }

    void addIT(int idx, int value) {
        this.root = insertIT(this.root, idx, value);
    }
    static TreeNode insertIT(TreeNode t, int idx, int val) {
        if (t == null) {
            return new TreeNode(1, val, null, null);
        } else {
            TreeNode curr = t;
            TreeNode parent = curr;
            while (curr != null) {
                parent = curr;
                if (idx < curr.rank) {
                    curr.rank += 1;
                    curr = curr.left;
                } else {
                    idx -= curr.rank;
                    curr = curr.right;
                }
            }
            if (parent.rank == 1) {
                parent.left = new TreeNode(1, val, null, null);
            } else {
                parent.right = new TreeNode(1, val, null, null);
            }
            return t;
        }
    }

    static TreeNode getIT(TreeNode t, int idx) {
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

    static TreeNode getRE(TreeNode t, int idx) {
        if (idx < t.rank-1) {
            return getRE(t.left, idx);
        } else if (idx != t.rank-1) {
            return getRE(t.right, idx-t.rank);
        } else {
            return t;
        }
    }
}