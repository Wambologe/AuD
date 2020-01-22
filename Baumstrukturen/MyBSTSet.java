package Baumstrukturen;

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

	private TreeNode<E> root;
	
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
	public boolean containsIt(E key) {
		return lookupIt(this.root, key) != null;
	}

	private TreeNode<E> lookupIt(TreeNode<E> t, E key) {
		if (t == null) {
			return null;
		}
		TreeNode<E> curr = t;
		int cmp = -1;
		while (curr != null && cmp != 0) {
			cmp = key.compareTo(curr.key);
			if (cmp < 0) {
				curr = curr.left;
			} else if (cmp > 0) {
				curr = curr.right;
			}
		}
		return curr;
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
	public E minimumIt() {
		TreeNode<E> min = minimumIt(this.root);
		return min == null ? null : min.key;
	}
	
	public TreeNode<E> minimumIt(TreeNode<E> t) {
		if (t == null) {
			return null;
		} 
		TreeNode<E> curr = t;
		while (curr.left != null) {
			curr = curr.left;
		}
		return curr;
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
	public E maximumIt() {
		TreeNode<E> max = maximumIt(this.root);
		return max == null ? null : max.key;
	}

	private TreeNode<E> maximumIt(TreeNode<E> t) {
		if (t == null) {
			return null;
		} 
		TreeNode<E> curr = t;
		while (curr.right != null) {
			curr = curr.right;
		}
		return curr;
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
	public MyBSTSet<E> insertIt(E key) {
		this.root = insertIt(this.root, key);
		return this;
	}

	private TreeNode<E> insertIt(TreeNode<E> t, E k) {
		if (t == null) {
			return new TreeNode<E>(k, null, null);
		}
		TreeNode<E> curr = t;
		TreeNode<E> parent = null;
		int cmp = -1;
		while (curr != null && cmp != 0) {
			parent = curr;
			cmp = k.compareTo(curr.key);
			if (cmp < 0) {
				curr = curr.left;
			} else if (cmp > 0) {
				curr = curr.right;
			}
		}
		if (cmp < 0) {
			parent.left = new TreeNode<E>(k, null, null);
		} else if (cmp > 0) {
			parent.right = new TreeNode<E>(k, null, null);
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

	@Override
	public MyBSTSet<E> removeIt(E key) {
		this.root = deleteIt(this.root, key);
		return this;
	}

	private TreeNode<E> deleteIt(TreeNode<E> root, E key) {
		if (root == null) {
			return null;
		}
		TreeNode<E> curr = root;
		int cmp = -1;
		while (curr != null && cmp != 0) {
			cmp = key.compareTo(curr.key);
			if (cmp < 0) {
				curr = curr.left;
			} else if (cmp > 0) {
				curr = curr.right;
			}
		}
		if (cmp == 0) {
			if (curr.left == null) {
				curr = curr.right;
			} else if (curr.right == null) {
				curr = curr.left;
			} else {
				TreeNode<E> parent = curr;
				curr = minimumIt(curr.right);
				parent.key = curr.key;
				
			}
		}
		return root;
	}
}
