
public class Test {

	public Test() {
		
	}
	
	public boolean TestSortingAlgorithms(int testA[]) {
		
		for (int i = 0; i < testA.length - 1; i++) {
		    if (testA[i] > testA[i+1]) {
		        return false;
		    }
		}
		
		return true;
	}
	
	public long timeSortingAlgorithms(long start) {
		
		return System.nanoTime()-start;

	}
}
