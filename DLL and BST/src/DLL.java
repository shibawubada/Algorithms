/**
 * @author Harry Goodwin
 * 2557827g
 * 17/03/2021
 */

public class DLL<Type extends Comparable<? super Type>>{ 

	private static class Node<Type>{
		Type x;  
		Node<Type> previous;  
		Node<Type> next;  

		public Node(Type x) {  
			this.x = x;  
		} 
	}
	Node<Type> head, tail = null;  

	/**
	 * @param x - data input for node
	 * 
	 * checks if tree contains element, set property
	 * and then proceeds if head is null, simple add 
	 * to head, else insert newNode as tail.next, at 
	 * the end of the list.  both variants require 
	 * realignment of next and previous nodes.
	 */
	public void add(Type x) {

		if(isElement(x)) {
			return;
		}

		Node<Type> newNode = new Node<Type>(x);  

		if(head == null) {  
			head = tail = newNode;  
			head.previous = null;  
			tail.next = null;  
		}  
		else {  
			tail.next = newNode;  
			newNode.previous = tail;  
			tail = newNode;  
			tail.next = null;  

		}
	}

	/**
	 * 
	 * @param x - data to check
	 * @return - boolean result
	 * 
	 * method checks if element exists 
	 */
	public boolean isElement(Type x) {

		Node<Type> tracker = head;  

		if(head == null) {  
			return false;  
		}  
		while(tracker != null) {  
			if(tracker.x.equals(x)) {  
				return true;
			}  
			tracker = tracker.next;   
		}
		return false;
	}

	/**
	 * 
	 * @param x - data to check
	 * 
	 * method takes param x and then searches for it
	 * if found x is removed and linked list
	 * structure is adjusted accordingly
	 */
	public void remove(Type x) {

		Node<Type> tracker = head;  

		while(tracker != null) {  
			if(tracker.x.equals(x)) {  

				if(tracker.equals(head)) {
					head=tracker.next;
				}
				
				if(tracker.next != null) {
					tracker.next.previous = tracker.previous;
				}

				if(tracker.previous!=null) {
					tracker.previous.next = tracker.next;
				}

			}  
			tracker = tracker.next;   
		}
	}

	/**
	 * if set has no head it is empty
	 * @return
	 */
	public boolean setEmpty() {

		return head==null;

	}

	/**
	 * iterate through entire list while counting
	 * @return - counter
	 */
	public int setSize() {

		Node<Type> tracker = head;  
		int count=0;

		while(tracker != null) {  

			tracker = tracker.next;   
			count++;
		}
		return count;
	}

	/**
	 * 
	 * @param s - set s
	 * @param t - set t
	 * @return - union set
	 * 
	 * iterate through set s adding every element to
	 * union set, then iterate through t adding every 
	 * element to the union set, whilst checking 
	 * isElement so we don't get duplicates
	 */
	public DLL<Type> union(DLL<Type> s, DLL<Type> t) {

		DLL<Type> union = new DLL<Type>();

		Node<Type> headS = s.head;
		Node<Type> headT = t.head;

		while(headS != null) {
			union.add(headS.x);
			headS = headS.next;
		}

		while(headT != null) {
			if(!isElement(headT.x)) {
				union.add(headT.x);
			}
			headT = headT.next;
		}
		return union;

	}

	/**
	 * 
	 * @param s - set s
	 * @param t - set t
	 * @return - intersection set
	 * 
	 * check every element of list t for weather it is
	 * inElement of list s if both lists share an element
	 * that element is added to intersection set
	 */
	public DLL<Type> intersection(DLL<Type> s, DLL<Type> t) {

		DLL<Type> intersection = new DLL<Type>();

		Node<Type> headT = t.head;

		while(headT != null) {
			if(isElement(headT.x)) {
				intersection.add(headT.x);
			}
			headT = headT.next;
		}

		return intersection;

	}

	/**
	 * 
	 * @param s - set s
	 * @param t - set t
	 * @return - difference set
	 * 
	 * iterate through both sets, if set s does not contain
	 * head t then element can be added to difference the same
	 * is then applied to headT
	 */
	public DLL<Type> difference(DLL<Type> s, DLL<Type> t) {

		DLL<Type> difference = new DLL<Type>();
		DLL<Type> intersection = intersection(s,t);

		Node<Type> headS = s.head;
		Node<Type> headT = t.head;
		
		while(headT != null) {
			if(!intersection.isElement(headT.x)) {
				difference.add(headT.x);
			}
			headT = headT.next;
		}
		
		while(headS != null) {
			if(!intersection.isElement(headS.x)) {
				difference.add(headS.x);
			}
			headS = headS.next;
		}

		return difference;
	}

	/**
	 * 
	 * @param s - set s
	 * @param t - set t
	 * @return - boolean
	 * 
	 * while iterating through set t, set s is
	 * checked for if headT is present.  if element is
	 * present we may continue.  if it is not return false,
	 * Because this violates subset principle.
	 */
	public boolean subset(DLL<Type> s, DLL<Type> t) {

		Node<Type> headT = t.head;

		while(headT != null) {

			if(!isElement(headT.x)) {
				return false;
			}
			headT = headT.next;
		}

		return true;
	}

	public void printList(Node<Type> node) {

		while(node != null) {
			System.out.println(node.x);

			node=node.next;
		}
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
