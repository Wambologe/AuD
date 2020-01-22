package Baumstrukturen;

public class MyRBSet<E extends Comparable<E>> 
	implements GenericOrderedSet<E> {
	
	private static class TreeNode<T> {
		private T key;
		private boolean red;
		private TreeNode<T> left;
		private TreeNode<T> right;
		
		private TreeNode(T key, boolean red, TreeNode<T> left, TreeNode<T> right) {
			this.key = key;
			this.red = red;
			this.left = left;
			this.right = right;
		}
	}
	
	private TreeNode<E> root;
	
    /**/
    
    @Override
	public E minimum() {
		TreeNode<E> min = minimum(this.root);
		return min == null ? null : min.key;
    }

    private TreeNode<E> minimum(TreeNode<E> t) {
		if (t == null) {
			return null;
		} else if (t.left == null) {
			return t;
		} else {
			return minimum(t.left);
		}
	}
    
    @Override
	public E maximum() {
		TreeNode<E> max = maximum(this.root);
		return max == null ? null : max.key;
	}
	
	private TreeNode<E> maximum(TreeNode<E> t) {
		if (t == null) {
			return null;
		} else if (t.right == null) {
			return t;
		} else {
			return maximum(t.right);
		}
	}

    @Override
	public boolean contains(E key) {
		return lookup(this.root, key) != null;
	}

	private TreeNode<E> lookup(TreeNode<E> t, E key) {
		if (t == null) {
			return null;
		}
		int cmp = key.compareTo(t.key);
		if (cmp < 0) {
			return lookup(t.left, key);
		} else if (cmp > 0) {
			return lookup(t.right, key);
		} else {
			return t;
		}
	}
    
	private boolean isRed(TreeNode<E> t) {
		return t != null && t.red;
	}
	
	private TreeNode<E> rotateLeft(TreeNode<E> t) {
		TreeNode<E> r = t.right;
		
		t.right = r.left;
		r.left = t;
		
		r.red = t.red;
		t.red = true;
		
		return r;
	}
	
	private TreeNode<E> flip(TreeNode<E> t) {
		t.red = true;
		t.left.red = false;
		t.right.red = false;
		
		return t;
	}
	
	private TreeNode<E> rotateRight(TreeNode<E> t) {
		TreeNode<E> l = t.left;
		
		t.left = l.right;
		l.right = t;
		
		l.red = t.red;
		t.red = true;
		
		return l;
	}
    
    @Override
	public MyRBSet<E> insert(E key) {
		this.root = insert(this.root, key);
		this.root.red = false;
		return this;
	}

	private TreeNode<E> insert(TreeNode<E> t, E key) {
		if (t == null) {
			return new TreeNode<E>(key, true, null, null);
		}
		
		int cmp = key.compareTo(t.key);
		
		if (cmp < 0) {
			t.left = insert(t.left, key);
		} else if (cmp > 0) {
			t.right = insert(t.right, key);
		} else {
			return t;
		}
		
		if (isRed(t.right) && !isRed(t.left)) {
			t = rotateLeft(t);
		} 
		if (isRed(t.left) && isRed(t.left.left)) {
			t = rotateRight(t);
		}
		if (isRed(t.left) && isRed(t.right)) {
			t = flip(t);
		}
		
		return t;
	}

    //Implementierung zu kompliziert
    @Override
    public GenericOrderedSet<E> remove(E key) {
        return null;
    }
}