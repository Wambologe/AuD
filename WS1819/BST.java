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

        void addRE(int key) {
            this.root = insertRE(this.root, null, key);
        }
        static TreeNode insertRE(TreeNode t, TreeNode p, int k) {
            if (t == null) {
                return new TreeNode(k, p, null, null);
            } else if (k < t.key) {
                t.left = insertRE(t.left, t, k);
            } else if (k > t.key) {
                t.right = insertRE(t.right, t, k);
            }
            return t;
        }

        void addIT(int key) {
            this.root = insertRE(this.root, null, key);
        }
        static TreeNode insertIT(TreeNode t, TreeNode p, int key) {
            if (t == null) {
                return new TreeNode(key, p, null, null);
            } else {
                TreeNode curr = t;
                TreeNode par = curr;
                while (curr != null && curr.key != key) {
                    par = curr;
                    if (curr.key > key) {
                        curr = curr.left;
                    } else {
                        curr = curr.right;
                    }
                }
                if (curr == null) {
                    curr = new TreeNode(key, par, null, null);
                    if (par.key > key) {
                        par.left = curr;
                    } else {
                        par.right = curr;
                    }
                }
                return t;
            }
        }

        static TreeNode lookupIT(TreeNode t, int key) {
            while (t != null && t.key != key) {
                if (key < t.key) {
                    t = t.left;
                } else {
                    t = t.right;
                }
            }
            return t;
        }

        static TreeNode lookupRE(TreeNode t, int key) {
            if (t == null) {
                return t;
            } else if (t.key > key) {
                return lookupRE(t.left, key);
            } else {
                return lookupRE(t.right, key);
            }
        }

        static TreeNode minimumIT(TreeNode t) {
            while (t != null && t.left != null) {
                t = t.left;
            }
            return t;
        }

        static TreeNode minimumRE(TreeNode t) {
            if(t == null) {
                return null;
            } else if (t.left != null) {
                return minimumRE(t.left);            
            } else {
                return t;
            }
        }


        static TreeNode successorIT(TreeNode t) {
            if (t == null) {
                return null;
            } else if (t.right != null) {
                return minimumIT(t.right);
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

        static TreeNode successorRE(TreeNode t, int key) {
            if (t.key > key) {
                return t;
            } else if (t.right != null && t.right.key > key) {
                return minimumRE(t.right);
            } else if (t.parent != null) {
                return successorRE(t.parent, key);
            } else {
                return null;
            }
        }
    }
}