/*
 * Harry Goodwin
 * quick insertion sort
 * 11/02/2021
 */
public class QuickInsertionSort {

	/**
	 * 
	 * @param A: Array to be sorted
	 * @param left: left most index
	 * @param right: right most index
	 * 
	 */
	public void quickSort(int A[], int left, int right) {

		int part=0;

		if(left<right) {

			if((right - left)<Driver.k) {

			}
			else {
				part = partition(A, left, right);
				quickSort(A, left, part-1);
				quickSort(A, part+1, right);
			}
		}
	}

	/**
	 * 
	 * @param A: Array to be sorted
	 * @param left: left most index
	 * @param right: right most index
	 * 
	 */
	public int partition(int A[], int left, int right) {

		int pivot = A[right];
		int i = left-1;

		for (int j=left;j<right;j++) {
			if(A[j] <= pivot) {
				i++;

				swap(A, i, j);						
			}
		}
		swap(A, i+1, right);

		return i+1;

	}

	/**
	 * 
	 * @param A: Array to be insertion sorted
	 * @return
	 */
	public int[] insertSort(int[] A) {

		int i=0;
		int n=A.length;

		for (int j=1; j< n;j++) {
			int key = A[j];
			i=j-1;
			while (i>=0 && A[i]>key) {
				A[i+1] = A[i];
				i = i-1;
				A[i+1] = key;
			}
		}

		return A;
	}

	/**
	 * 
	 * @param A: Array with elements to be swapped
	 * @param i: first swap index
	 * @param r: second swap index
	 */
	public static void swap(int A[], int i, int r) {

		int temp = A[i];
		A[i] = A[r];
		A[r] = temp;
	}
}
