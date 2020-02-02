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

	/* Liefert das im Vergleich zu key naechstkleinere bzw. –groessere Element
	der Menge bzw. null, wenn ein solches nicht existiert */
	private E lower(TreeNode<E> t, E key) {
		if (t == null) {
			return null;
		} else if (t.key.compareTo(key) >= 0) {
			return lower(t.left, key);
		} else {
			E low = lower(t.right, key);
			if (low == null) {
				return t.key;
			} else {
				return low;
			}
		}
	}

	private E higher(TreeNode<E> t, E key) {
		if (t == null) {
			return null;
		} else if (t.key.compareTo(key) <= 0) {
			return higher(t.right, key);
		} else {
			E hi = higher(t.left, key);
			if (hi == null) {
				return t.key;
			} else {
				return hi;
			}
		}
	}

	/* Liefert das Element key, wenn es in der Menge enthalten ist;
	ansonsten wird das naechstkleinere bzw. -groessere Element der Menge geliefert
	bzw. null, wenn ein solches nicht existiert */
	private E floor(TreeNode<E> t, E key) {
		if (t == null) {
			return null;
		} else if (t.key.compareTo(key) == 0) {
			return t.key;
		} else if (t.key.compareTo(key) > 0) {
			return floor(t.left, key);
		} else {
			E fl = floor(t.right, key);
			if (fl == null) {
				return t.key;
			} else {
				return fl;
			}
		}
	}

	private E ceil(TreeNode<E> t, E key) {
		if (t == null) {
			return null;
		} else if (t.key.compareTo(key) == 0) {
			return t.key;
		} else if (t.key.compareTo(key) < 0) {
			return ceil(t.right, key);
		} else {
			E ce = ceil(t.left, key);
			if (ce == null) {
				return t.key;
			} else {
				return ce;
			}
		}
	}

	//ITERATIVE IMPLEMENTIERUNGEN

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
	
	public MyBSTSet<E> removeIt(E key) {
		this.root = deleteIt(this.root, key);
		return this;
	}

	//funzt nicht
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
