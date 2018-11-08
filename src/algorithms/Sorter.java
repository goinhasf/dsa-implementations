package algorithms;

import java.util.List;

public class Sorter<E extends Comparable<E>>{

	
	private void sort(E[] array, DivideAndConquer<E> algorithm) {
		algorithm.sort(array);
		
	}


	private void sort(List<E> array, DivideAndConquer<E> algorithm) {
		algorithm.sort(array);

	}
	
	public void quickSortStable(E[] array) {
		new QuickSort<E>().stableSort(array);
		
	}
	
	public void quickSort(E[] array) {
		new QuickSort<E>().sort(array);
		
	}


	public void mergeSort(E[] array) {
		sort(array, new MergeSort<E>());
		
	}


	public void quickSort(List<E> array) {
		sort(array, new QuickSort<E>());
		
	}


	public void mergeSort(List<E> array) {
		sort(array, new MergeSort<E>());
		
	}


	
	
	
}
