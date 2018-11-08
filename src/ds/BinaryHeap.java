package ds;

import java.util.ArrayList;

public class BinaryHeap<T extends Comparable<T>> implements IBinaryHeap<T> {

	// A container for heap elements.
	private ArrayList<T> heap;
	// The index of the last element.
	private int n;
	// Size of the heap
	private final int size;

	public BinaryHeap(int size) {
		this.size = size;
		heap = new ArrayList<>(size);
		n = -1;
	}

	@Override
	public void insert(T p) {
		if (n == size - 1) {
			throw new IndexOutOfBoundsException("Heap full");
		}

		heap.add(++n, p);
		bubbleUp(n);

	}

	private void bubbleUp(int i) {

		if (isRoot(i)) {
			return;
		} else if (heap.get(i).compareTo(heap.get(parent(i))) > 0) {
			swap(parent(i), i);
			bubbleUp(parent(i));
		}

	}

	private void bubbleDown(int i) {
		if (left(i) > n) {
			return;
		}

		else if (right(i) > n) {
			if (heap.get(left(i)).compareTo(heap.get(i)) > 0) {
				swap(left(i), i);
				bubbleDown(left(i));
			} 
		} else {
			if (heap.get(left(i)).compareTo(heap.get(right(i))) > 0 && heap.get(i).compareTo(heap.get(left(i))) < 0) {
				swap(left(i), i);
				bubbleDown(left(i));
			} else if (heap.get(i).compareTo(heap.get(right(i))) < 0) {
				swap(right(i), i);
				bubbleDown(right(i));
			}
		}
	}

	private void swap(int a, int b) {

		if (a >= size || b >= size) {
			throw new IllegalArgumentException("Index overflow");
		}

		if (a < 0 || b < 0 || a >= size || b >= size) {
			throw new IllegalArgumentException("Index Underflow");
		}

		T temp = heap.get(a);
		heap.set(a, heap.get(b));
		heap.set(b, temp);
	}

	@Override
	public T delete(T i) {

		// Inefficient search
		if (!heap.contains(i)) {
			throw new NullPointerException("Empty Heap");
		} else {
			int index = heap.indexOf(i);
			swap(index, n);
			T temp = heap.remove(n--);
			bubbleUp(index);
			bubbleDown(index);
			return temp;
		}

	}

	public T deleteRoot() {
		if (heapEmpty()) {
			throw new NullPointerException("Heap is Empty");
		}
		swap(n, 0);
		T temp = heap.remove(n--);
		bubbleDown(0);
		return temp;
	}

	@Override
	public T root() {

		if (heapEmpty()) {
			throw new NullPointerException("Heap is Empty");
		}

		return heap.get(0);
	}

	private int heapN(int i) {
		return i + 1;
	}

	@Override
	public boolean heapEmpty() {
		return heap.isEmpty();
	}

	private boolean isRoot(int i) {
		return heapN(i) == 1;
	}

	private int parent(int i) {
		return (i / 2) ;
	}
	
	private int left(int i) {
		return 2 * heapN(i) - 1;
	}

	private int right(int i) {
		return 2 * heapN(i);
	}

	@Override
	public String toString() {
		if (heapEmpty()) {
			return "Empty Heap";
		}

		int numOfLevels = (int) logBase2(n + 1) + 1;
		String result = "";
		int i = 0;
		int index = 0;
		
		while (i < numOfLevels) {

			int numOfNodes = (int) Math.pow(2, i);
			
			if (i == numOfLevels-1) {
				
				if (numOfNodes > n/2) {
					numOfNodes = n/2;
				}
			}

			int maxNumOfTabs = (int) (Math.pow(2, numOfLevels- i));
			int startTabsNum = maxNumOfTabs / 2;
			int endTabsNum = maxNumOfTabs - startTabsNum;

			for (int s = 0; s < startTabsNum; s++) {
				result += "\t";
			}
			
			for (int j = 0; j < numOfNodes; j++) {
				
				
				T rootNode = heap.get(index);
				result += "[-" + rootNode.toString() + "-]";
				for (int k = 0; k < (int) Math.pow(2, numOfLevels + 1 - i) / 2; k++) {
					result += "\t";
				}
				
				index++;
				
			}
			
			for (int e = 0; e < endTabsNum; e++) {
				result += "\t";
			}


			i++;

			result += "\n";

		}

		return result;
	}

	private double logBase2(int n) {
		return Math.log10(n) / Math.log10(2);
	}

}
