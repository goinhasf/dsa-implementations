package test.binaryheap;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ds.BinaryHeap;

public class BinaryHeapTest {
	
	@Test(expected=NullPointerException.class)
	public void testEmpty() {
		BinaryHeap<Integer> heap = new BinaryHeap<>(10);
		heap.deleteRoot();
	}
	
	@Test
	public void testHeapInit() {
		BinaryHeap<Integer> heap = new BinaryHeap<>(10);
		heap.insert(1);
		assertEquals((Integer) 1, heap.root());
	}
	
	@Test
	public void testHeapInsertionOrder() {
		BinaryHeap<Integer> heap = new BinaryHeap<>(10);
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.insert(5);
		heap.insert(6);
		heap.insert(7);
		System.out.println(heap.toString());
		assertEquals((Integer) 7, heap.root());
		heap.deleteRoot();
		System.out.println(heap.toString());
		assertEquals((Integer) 6, heap.root());
		heap.deleteRoot();
		System.out.println(heap.toString());
		heap.deleteRoot();
		System.out.println(heap.toString());
		heap.deleteRoot();
		System.out.println(heap.toString());
	}
	
	
	
}
