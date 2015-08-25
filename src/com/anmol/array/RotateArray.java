package com.anmol.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @see http://www.programcreek.com/2015/03/rotate-array-in-java/
 * @author Anmol M
 *
 */
public class RotateArray {
	
	public int[] rotate(int array[], int k) {
		int length = array.length;
		int[] newArray = new int[length];
		for(int i=0; i<length; i++) {
			int index = i+k;
			if(index>=length)
				index = index-length;
			newArray[index] = array[i];
		}
		return newArray;
	}
	
	public void printArray(int array[]) {
		System.out.println("{");
		for(int i : array) {
			System.out.print(i + " ");
		}
		System.out.print("}");
	}
	
	public int[] rotateBubbleSort(int[] arr, int order) {
		if (arr == null || order < 0) {
		    throw new IllegalArgumentException("Illegal argument!");
		}
	 
		for (int i = 0; i < order; i++) {
			for (int j = arr.length - 1; j > 0; j--) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
		}
		return arr;
	}
	
	@Test
	public void testArray() {
		RotateArray ra = new RotateArray();
		int[] array = new int[]{1,2,3,4,5,6,7};
		Assert.assertArrayEquals(new int[]{5,6,7,1,2,3,4},ra.rotate(array, 3));
		Assert.assertArrayEquals(new int[]{5,6,7,1,2,3,4},ra.rotateBubbleSort(array, 3));
	}

}
