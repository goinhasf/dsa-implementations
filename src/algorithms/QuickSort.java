package algorithms;

import java.lang.reflect.Array;
import java.util.List;

public class QuickSort<E extends Comparable<E>> extends DivideAndConquer<E>{

	
	
	public void stableSort(E[] array) {
		sort(array, 0, array.length-1, true);
	}


	
	public void stableSort(List<E> list) {
		@SuppressWarnings("unchecked")
		E[] array = (E[]) list.toArray();
		sort(array, 0, array.length-1, false);
	}



	@Override
	public void sort(E[] array) {
		sort(array, 0, array.length-1, false);
		
	}
	
	private void sort(E[] array, int left, int right, boolean stable) {
		if (left < right) {
			int pivot = array.length;
			
			if (stable) {
				pivot = partition2(array, left, right);
			} else
				pivot = partition(array, left, right);
			sort(array, left, pivot-1, stable);
			sort(array, pivot+1, right, stable);
		}
	}
	
	private int partition(E[] array, int left, int right) {
		int pivotIndex = array.length/2;
		E pivot = array[pivotIndex];
		swap(pivotIndex, right, array);
		int leftmark = left;
		int rightmark = right - 1;
		
		while(leftmark <= rightmark) {
			while (leftmark <= rightmark && array[leftmark].compareTo(pivot) <= 0) {
				leftmark++;
			}
			while (leftmark <= rightmark && array[rightmark].compareTo(pivot) >= 0) {
				rightmark--;
			}
			if (leftmark < rightmark) {
				swap(leftmark++, rightmark--, array);
			}
		}
		
		swap(leftmark, right, array);
		return leftmark;
		
	}
	
	private int partition2(E[] array, int left, int right) {
		
		@SuppressWarnings("unchecked")
		E[] b = (E[]) Array.newInstance(array.getClass().getComponentType(), right-left+1);
		int pivotindex = array.length/2;
		E pivot = array[pivotindex];
		int acount = left;
		int bcount = 1;
		for (int i = left; i <= right; i++) {
			
			if (i == pivotindex) {
				b[0] = array[i];
			} else if (array[i].compareTo(pivot) < 0 || (array[i].compareTo(pivot) == 0 && i < pivotindex)) {
				array[acount++] = array[i];
			} else {
				b[bcount++] = array[i];
			}
		}
		for (int i = 0; i < bcount; i++) {
			array[acount++] = b[i];
		}
		
		return right-bcount+1;
	}

	private void swap(int a, int b, E[] array) {

		if (a >= array.length || b >= array.length) {
			throw new IllegalArgumentException("Index overflow");
		}

		if (a < 0 || b < 0 || a >= array.length || b >= array.length) {
			throw new IllegalArgumentException("Index Underflow");
		}

		E temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}


	@Override
	public void sort(List<E> list) {
		@SuppressWarnings("unchecked")
		E[] array = (E[]) list.toArray();
		sort(array);
		
	}

}
