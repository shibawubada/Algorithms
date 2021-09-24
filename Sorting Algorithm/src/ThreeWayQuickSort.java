/*
 * Harry Goodwin
 * Three way quick sort
 * 11/02/2021
 */
public class ThreeWayQuickSort {

	private int left;
	private int right;

	public ThreeWayQuickSort(){
	}

	/**
	 * 
	 * @param A: Array to be sorted
	 * @param left: left most index
	 * @param right: right most index
	 * 
	 * 3 way partitioning to help handle arrays with large amounts
	 * of the same element
	 */
	public void partition(int A[], int left, int right) {

		int i = left;
		int pivot = A[left];

		while(i<=right) {
			if(A[i]<pivot) {
				swap(A,left,i);
				left++;
				i++;
			}
			else if(A[i]>pivot) {
				swap(A,i,right);
				right--;
			}
			else {
				i++;
			}			
		}

		this.left=left;
		this.right=right;

	}

	/**
	 * 
	 * @param A: Array to be sorted
	 * @param left: left most index
	 * @param right: right most index
	 * 
	 */
	public void quicksort(int A[], int left, int right) {

		if(left >= right) {

			return;			
		}

		else {
			
			partition(A,left,right);

			quicksort(A, left, this.left-1);
			quicksort(A, this.right+1, right);

		}
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

