import java.util.Arrays;

public class Sortieralgorithmen {
	//Selection Sort
	public static int[] selection_sort(int[] f) {
		for (int to = 0; to < f.length - 1; to++) {
			int min_idx = to;
			int min_key = f[to];
			for (int from = to + 1; from < f.length; from++) {
				if (f[from] < min_key) {
					min_idx = from;
					min_key = f[from];
				}
			}
			f[min_idx] = f[to];
			f[to] = min_key;
		}
		return f;
	}
	
	//Insertion Sort
	public static int[] insertion_sort(int[] f) {
		for (int from = 1; from < f.length; from++) {
			int to = from - 1;
			int key = f[from];
			while (f[to] > key && to > -1) {
				f[to+1] = f[to];
				to--;
			}
			f[to+1] = key;
		}		
		return f;
	}
	
	//Merge Sort
	public static int[] merge_sort(int[] seq) {
		return merge_sort(seq, 0, seq.length-1);
	}	
		//l lower; u:upper index
	private static int[] merge_sort(int[] seq, int l_idx, int u_idx) {
		if (u_idx > l_idx) { //solange ein array aus mehr als einer zahl besteht
			int m_idx = l_idx + (u_idx - l_idx) / 2; //mittlerer index
			merge_sort(seq, l_idx, m_idx); //aufteilung von array in zwei teile (lower bis middle)
			merge_sort(seq, m_idx+1, u_idx); //middle bis up
			merge(seq, l_idx, m_idx, m_idx+1, u_idx);//nach sortierung der einzelnen teile merge
		}
		return seq;
	}	
	private static int[] merge(int[] seq, int ll_idx, int lu_idx, int rl_idx, int ru_idx) {
		int[] tmp = Arrays.copyOf(seq, seq.length);
		int l_cursor = ll_idx;
		int r_cursor = rl_idx;
		for (int i = ll_idx; i <= ru_idx; i++) {
			if (l_cursor > lu_idx) { //wenn linkes array bereits einsortiert ist, mit rechtem auffüllen
				seq[i] = tmp[r_cursor++];
			} else if (r_cursor > ru_idx) { //wenn rechtes array bereits einsortiert ist ...
				seq[i] = tmp[l_cursor++];
			} else if (tmp[l_cursor] < tmp[r_cursor]) { //vergleich links mit rechts
				seq[i] = tmp[l_cursor++];
			} else {
				seq[i] = tmp[r_cursor++];
			}
		}
		return seq;
	}
}
