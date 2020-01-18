// Noch unvollständig!
import javax.swing.tree.TreeNode;

public class MyTriesSet implements GenericOrderedSet<String>{
	
	private static class TreeNode {
		private TreeNode[] children;
		private boolean is_present;
		// Oder: private ? value; (für Verzeichnisse)
		private int successor_count;
		
		private TreeNode(int card) {
			this.children = new TreeNode[card];
		}
	}
	
	private char l_ch, u_ch;
	private TreeNode root;
	private int size;
	
	public MyTriesSet(char l_ch, char u_ch) {
		this.l_ch = l_ch;
		this.u_ch = u_ch;
	}
	
	@Override
	public boolean contains(String value) {
		return lookup(this.root, value, 0) != null;
	}
	
	private TreeNode lookup(TreeNode t, String key, int idx) {
		if (t == null) {
			return null;
		}
		
		if (idx == key.length()) {
			return t.is_present ? t : null;
		} else {
			char ch = key.charAt(idx);
			return lookup(t.children[ch-this.l_ch], key, idx+1);
		}
	}
	
	@Override
	public GenericOrderedSet<String> insert(String key) {
		this.root = insert(this.root, key, 0);
		return this;
	}
	
	public TreeNode insert(TreeNode t, String key, int idx) {
		if (t == null) {
			t = new TreeNode(key.charAt(idx));
		}
		
		if (idx == key.length()) {
			t.is_present = true;
		    return t;
		} else {
			char ch = key.charAt(idx);
			return lookup(t.children[ch-this.l_ch], key, idx+1);
		}
	}
	
	@Override
	public GenericOrderedSet<String> remove(String key) {
		this.root = delete(this.root, key, 0);
		return null;
	}
	
	public TreeNode delete(TreeNode t, String key, int idx) {
		if (t == null) {
			return null;
		}
		
		if (idx == key.length()) {
			return t.is_present ? t : null;
		} else {
			char ch = key.charAt(idx);
			return lookup(t.children[ch-this.l_ch], key, idx+1);
		}
	}
	
	
	@Override
	public String maximum() {
		return null;
	}
	@Override
	public String minimum() {
		// TODO Auto-generated method stub
		return null;
	}
}
