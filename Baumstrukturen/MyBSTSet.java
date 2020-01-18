public class MyBSTSet<E  extends Comparable<E>> implements GenericOrderedSet<E> {
	
	private static class TreeNode<T> {
		private T key;
		private TreeNode<T> left;
		private TreeNode<T> right;
		
		private TreeNode(T key, TreeNode<T> left, TreeNode<T> right) {
			this.key = key;
			this.left = left;
			this.right = right;
		}
	}
	//TODO: "T cannot be resolved to a type
	private TreeNode<T> root;
	
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
	
	@Override
	public E minimum() {
		TreeNode<E> min = minimum(this.root);
		return min == null ? null : min.key;
	}
	
	private TreeNode<E> minimum(TreeNode<E> t) {
		if(t == null) {
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
	public MyBSTSet<E> insert(E key) {
		this.root = insert(this.root, key);
		return this;
	}
	
	private TreeNode<E> insert(TreeNode<E> t, E k) {
		if (t == null) {
			return new TreeNode<E>(k, null, null);
		} 
		int cmp = k.compareTo(t.key);
		if (cmp < 0) {
			t.left = insert(t.left, k);
		} else if (cmp > 0) {
			t.right = insert(t.right, k);		
		}
		return t;
	}
	
	@Override
	public MyBSTSet<E> remove(E key) {
		this.root = delete(this.root, key);
		return this;
	}

	private TreeNode<E> delete(TreeNode<E> root, E key) {
		if (root == null) {
			return null;
		}
		int cmp = key.compareTo(root.key);
		if (cmp < 0) {
			root.left = delete(root.left, key);
		} else if (cmp > 0) {
			root.right = delete(root.right, key);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			root.key = minimum(root.right).key;
			root.right = delete(root.right, root.key);
		}
		return root;
	}
	
	private void traverse_inorder(TreeNode<E> t) {
		if(t == null) {
			return;
		} else {
			traverse_inorder(t.left);
			System.out.println(t.key);
			traverse_inorder(t.right);
		}
	}
}