package WS1819;

public class BST {
    private static class TreeNode {
        private int key;
        private TreeNode left, right;
        private TreeNode parent;

        private TreeNode(int key, TreeNode parent, TreeNode left, TreeNode right){
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        private TreeNode root = null;

        void add(int key) {
            this.root = insert(this.root, null, key);
        }

        static TreeNode insert(TreeNode t, TreeNode p, int k) {
            if (t == null) {
                return new TreeNode(k, p, null, null);
            } else if (k < t.key) {
                t.left = insert(t.left, t, k);
            } else if (k > t.key) {
                t.right = insert(t.right, t, k);
            }
            return t;
        }

        static TreeNode lookup(TreeNode t, int key) {
            while (t != null && t.key != key) {
                if (key < t.key) {
                    t = t.left;
                } else {
                    t = t.right;
                }
            }
            return t;
        }

        static TreeNode minimum(TreeNode t) {
            while (t != null && t.left != null) {
                t = t.left;
            }
            return t;
        }

        static TreeNode successor(TreeNode t) {
            if (t == null) {
                return null;
            } else if (t.right != null) {
                return minimum(t.right);
            }
            int k = t.key;
            while (t.parent != null) {
                t = t.parent;
            }
            if (t.key > k) {
                return t;
            } else {
                return null;
            }            
        }
    }
}