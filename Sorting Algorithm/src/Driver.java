/*
 * Harry Goodwin
 * driver
 * 11/02/2021
 */
public class Driver {

	//doc name for testing
	private static String doc = "int500k.txt";	

	//array size to be insertion sorted for the quick insertion sort
	static int k = 20;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		//initialise classes
		FileIO file = new FileIO();
		QuickSort quickSort = new QuickSort();
		QuickInsertionSort quickInsertSort = new QuickInsertionSort();
		MedianOfThree medianOfThree = new MedianOfThree();
		ThreeWayQuickSort threeWayQuickSort = new ThreeWayQuickSort();
		Test test = new Test();

		//code using the pathological input algorithm in each of the sorts
		/*
		int[] pathological = Driver.quadraticQuickSort(11);

		for(int x : pathological) {
			System.out.print(x+ " ");
		}
		System.out.println();
		medianOfThree.sort(pathological, 0, pathological.length-1);

		for(int x : pathological) {
			System.out.print(x+ " ");			
		}
		System.out.println();
		
		//create bad arrays
		int[] A = Driver.quadraticQuickSort(9999);
		int[] B = Driver.quadraticQuickSort(9999);
		int[] C = Driver.quadraticQuickSort(9999);
		int[] D = Driver.quadraticQuickSort(9999);
		 */

		//read from file
		int[] A = file.fileRead(doc);
		int[] B = file.fileRead(doc);
		int[] C = file.fileRead(doc);
		int[] D = file.fileRead(doc);

		
		//time quick sort
		long start2 = System.currentTimeMillis();
		quickSort.quicksort(B, 0, B.length-1);
		long duration2 = System.currentTimeMillis()-start2;


		//time quick, insert sort
		long start1 = System.currentTimeMillis();
		quickInsertSort.quickSort(A, 0, A.length-1);
		quickInsertSort.insertSort(A);
		long duration1 = System.currentTimeMillis()-start1;


		//time median of three sort
		long start3 = System.currentTimeMillis();
		medianOfThree.sort(C, 0, C.length-1);
		long duration3 = System.currentTimeMillis()-start3;


		//time three way quick sort
		long start4 = System.currentTimeMillis();
		threeWayQuickSort.quicksort(D, 0, D.length-1);
		long duration4 = System.currentTimeMillis()-start4;


		//display
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Time Taken To Sort: "+doc+"\n");


		System.out.println("quickSort: "+duration2+"ms");
		System.out.print(test.TestSortingAlgorithms(B)+"\n\n");


		System.out.println("quickInsertionSort: "+duration1+"ms");
		System.out.print(test.TestSortingAlgorithms(A)+"\n\n");


		System.out.println("medianOfThree: "+duration3+"ms");
		System.out.print(test.TestSortingAlgorithms(C)+"\n\n");


		System.out.println("ThreeWayQuickSort: "+duration4+"ms");
		System.out.print(test.TestSortingAlgorithms(D)+"\n\n");


		//System.out.println("InsertionSort: "+duration5+"ms");
		//System.out.print(test.TestSortingAlgorithms(E)+"\n\n");

		System.out.println("---------------------------------------------------------------------\n");

		System.exit(1);

	}

	/**
	 * 
	 * @param size : array size
	 * @return created array
	 * 
	 * Create array of size that will cause quadratic time complexity
	 */
	public static int[] quadraticQuickSort(int size) {

		int[] quadA = new int[size];

		//if even set final value to the size of quadA
		if(size % 2 != 0 ) {

			quadA[size-1] = size;
			size--;
		}

		int mid = size/2;
		for(int i=0; i<mid ;++i) {

			//defining odd index with iterator index value
			if(i % 2 != 0) {
				quadA[i] = mid+i+(mid%2);
			}
			//defining even index with iterator index value
			else {
				quadA[i]=i+1;
			}
			//then use iterator index value to define passed mid
			quadA[mid+i] = (i+1)*2;
		}	
		return quadA;
	}	
}
