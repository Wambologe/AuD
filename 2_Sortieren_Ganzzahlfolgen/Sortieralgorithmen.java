import java.util.Arrays;

public class Sortieralgorithmen {
	//Selection Sort (Seite 18)
	public static int[] selection_sort(int[] f) {
		// für jeden Index i von 0 bis n-2:
		for (int to = 0; to < f.length - 1; to++) {
			int min_idx = to;
			int min_key = f[to];
			// suche den Index j des kleinsten Elementes von Index i bis n-1
			for (int from = to + 1; from < f.length; from++) {
				if (f[from] < min_key) {
					min_idx = from;
					min_key = f[from];
				}
			}
			// tausche f[i] gegen f[j]
			f[min_idx] = f[to];
			f[to] = min_key;
		}
		return f;
	}
	
	//Insertion Sort
	public static int[] insertion_sort(int[] f) {
		// für jeden Index i von 1 bis N-1: 
		for (int from = 1; from < f.length; from++) {
			int to = from - 1;
			int key = f[from];
			// laufe mit dem Index j ab Index i nach links bis zum Einfügeindex
			while (f[to] > key && to > -1) {
				// schiebe dabei jedes Element f[j] größer als f[i] um eine
				// Indexposition nach rechts
				f[to+1] = f[to];
				to--;
			}
			// wird ein Element f[j] kleiner als f[i] oder der Anfang der Folge
			// erreicht, so füge f[i] am nachfolgenden Index j+1 ein
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
			if (l_cursor > lu_idx) { //wenn linkes array bereits einsortiert ist, mit rechtem auff�llen
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
