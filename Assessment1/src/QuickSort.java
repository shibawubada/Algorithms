/*
 * Harry Goodwin
 * quick sort
 * 11/02/2021
 */
public class QuickSort {

	public QuickSort() {

	}

	/**
	 * 
	 * @param A: Array to be sorted
	 * @param left: left most index
	 * @param right: right most index
	 * 
	 */
	public void quicksort(int A[], int left, int right) {

		int part=0;

		if(left<right) {
			
			part = partition(A, left, right);
			quicksort(A, left, part-1);
			quicksort(A, part+1, right);
			
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
	 * @param A: Array with elements to be swapped
	 * @param i: first swap index
	 * @param r: second swap index
	 */
	public void swap(int A[], int i, int r) {
		
		int temp = A[i];
		A[i] = A[r];
		A[r] = temp;
	}
}
