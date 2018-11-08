package test.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import algorithms.Sorter;

public class SortingTest {
	
	@Test
	public void quickSortTest() {
		Integer[] array = {5,2,7,8,4,9};
		Integer[] sortedArray = {2, 4, 5, 7, 8, 9};
		new Sorter<Integer>().quickSortStable(array);
		assertEquals(Arrays.asList(sortedArray), Arrays.asList(array));
	}
}
