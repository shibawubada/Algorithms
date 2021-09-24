
/*
 * Harry Goodwin
 * Median of three 
 * quick sort
 * 11/02/2021
 */
public class MedianOfThree {

	public MedianOfThree() {

	}

	/**
	 * 
	 * @param A: Array to be sorted
	 * @param left: left most index
	 * @param right: right most index
	 * 
	 */
	public void sort(int A[], int left, int right) {

		if(left>= right) {
			return;
		}

		else if(left<right) {

			int pivot = medianOfThreePivot(A,left,right);

			sort(A, left, pivot-1);
			sort(A, pivot+1, right);


		}
	}

	/**
	 * 
	 * @param A: Array to be sorted
	 * @param left: left most index
	 * @param right: right most index
	 * 
	 * finding middle element of three points and then
	 * replacing them in order
	 */
	public int medianOfThreePivot(int A[], int left, int right) {

		int mid = right/2;

		int[] medianArr = { A[left], A[mid], A[right] };

		int median = insertSort(medianArr)[1];

		int temp = A[right];
		A[right] = median;

		if(median == A[left]) {
			A[left]=temp;
		}

		else if(median == A[mid]){
			A[mid]=temp;
		}

		return partition(A, left, right);
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
