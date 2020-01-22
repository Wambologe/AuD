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

	// private TreeNode<E> minimumIterative(TreeNode<E> t) {
	// 	// TreeNode curr = null;
	// }
		
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

	@Override
	public MyBSTSet<E> insertIterative(E key) {
		this.root = insertIterative(this.root, key);
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

	// https://www.techiedelight.com/insertion-in-bst/
	// todo: TESTEN!
	private TreeNode<E> insertIterative(TreeNode<E> t, E k) {
		TreeNode<E> parent = null;
		TreeNode<E> curr = t;
		int cmp = -1;

		if (curr == null)
			return new TreeNode<E>(k, null, null);
		
		while (curr != null && cmp != 0) {
			// geht auch
			// parent = curr; 
			cmp = k.compareTo(curr.key);
			if (cmp < 0) {
				parent = curr;
				curr = curr.left;
			} else if (cmp > 0) {
				parent = curr;
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

	@Override
	public MyBSTSet<E> removeIterative(E key) {
		this.root = deleteIterative(this.root, key);
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

	
	// todo: noch nicht fertig und mit parent hier arbeiten!
	private TreeNode<E> deleteIterative(TreeNode<E> root, E key) {
		TreeNode<E> parent = null;
		TreeNode<E> curr = root;
		TreeNode<E> minFoundTree = null;
		boolean bothEmpty = false;
		int cmp = 0;

		while (curr != null) {
			cmp = key.compareTo(curr.key);
			if (curr.key == key && curr.left == null && curr.right == null) {
				curr = null;
			} else if (curr.key == key && curr.left != null && curr.right == null) {
				curr = curr.left;
			} else if (curr.key == key && curr.left == null && curr.right != null) {
				curr = curr.right;
			} else if (curr.key == key && curr.left != null && curr.right != null) {
				minFoundTree = minimum(root.right);
				curr.key = minFoundTree.key;
				curr = minFoundTree;

			} else if (cmp < 0) {
				parent = curr;
				curr = curr.left;
			} else if (cmp > 0) {
				parent = curr;
				curr = curr.right;
			}
		}

		return root;
	}



	
	// private void traverse_inorder(TreeNode<E> t) {
	// 	if(t == null) {
	// 		return;
	// 	} else {
	// 		traverse_inorder(t.left);
	// 		System.out.println(t.key);
	// 		traverse_inorder(t.right);
	// 	}
	// }
}
