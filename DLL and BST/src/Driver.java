/**
 * @author Harry Goodwin
 * 2557827g
 * 17/03/2021
 */
public class Driver {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BST s = new BST();
		BST t = new BST();
		
		//************************************************************************
		//*******Change depending on sets, values data type***********************
		//int removalBST = 48;
		String removalBST = "drive";
		//int removalDLL = 48;
		String removalDLL = "drive";
		//************************************************************************
		//************************************************************************
		
		System.out.println("Binary search trees\n");
				
		//String BST insertion
		s.add("drive");
		s.add("word");
		s.add("dupe");
		s.add("green");
		s.add("test");

				
		t.add("grey");
		t.add("glasgow");
		t.add("word");
		t.add("table");
		t.add("chair");
		t.add("5225");

		
		//integer BST insertion
		/*
		
		s.add(567);
		s.add(1);
		s.add(45);
		t.add(435);
		s.add(45);
		s.add(342);
		t.add(4);
		
		t.add(74);
		t.add(1);
		t.add(435);
		t.add(32);
		t.add(74);
		t.add(4);
		
		**/

		
		System.out.println("Tree S in order traversal");
		s.printInOrder(s.root);
		System.out.println("Tree s size: "+s.setSize());
		
		System.out.println("\nIs Element "+removalBST+" present: "+ s.isElement(removalBST));
		System.out.println("Remove "+removalBST);
		s.remove(removalBST);
		System.out.println("Is Element "+removalBST+" present: "+ s.isElement(removalBST)+"\n");
		
		System.out.println("Tree S in order traversal post removal");
		s.printInOrder(s.root);
		
		
		System.out.println("\n");
		
		System.out.println("Tree T in order traversal");
		t.printInOrder(t.root);
		System.out.println("Tree t size: "+t.setSize());
		
		System.out.println("\n\n");		
		
		//UNION TESTS
		System.out.println("Union of trees S and T: ");
		BST union = s.union(s, t);
		union.printInOrder(union.root);
		
		System.out.println("\n");
			
		//INTERSECTION TESTS
		System.out.println("Intersection of trees S and T: ");
		BST intersection = s.intersection(s, t);
		intersection.printInOrder(intersection.root);
		
		System.out.println("\n");
		
		//DIFFERENCE TESTS
		System.out.println("Difference of trees S and T: ");
	    BST difference = s.difference(s, t);	
	    
		difference.printInOrder(difference.root);

		System.out.println("\n");
		
		//SUBSET TESTS
		System.out.println("is S a subset of T: ");
		System.out.println(s.subset(s, t));
		
		System.out.println("\n");
		
		
		System.out.println("\n");
		
		System.out.println("========================================================\n\n");
		System.out.println("Doubly Linked Lists\n");
		
		DLL d = new DLL();
		DLL l = new DLL();
		
		//String DLL insertion
		d.add("drive");
		d.add("word");
		d.add("green");
		d.add("dupe");
		d.add("test");

				
		l.add("grey");
		l.add("drive");	
		l.add("glasgow");
		l.add("table");
		l.add("chair");
		l.add("word");
		l.add("5225");
		/*

		//Integer DLL insertion
		d.add(11);
		d.add(63);
		d.add(91);
		d.add(3);
		d.add(48);
		d.add(56);
			
		l.add(23);
		l.add(11);
		l.add(63);
		l.add(22);
		l.add(21);
		l.add(48);
		l.add(56);

		 **/
		System.out.println("DLL d: ");
		d.printList(d.head);
		System.out.println("DLL size: "+d.setSize());
		System.out.println("\n");


		System.out.println("\nIs Element "+removalDLL+" present: "+ d.isElement(removalDLL));
		System.out.println("Remove "+removalDLL);
		d.remove(removalDLL);
		System.out.println("Is Element "+removalDLL+" present: "+ d.isElement(removalDLL)+"\n");
		
		System.out.println("DLL d post removal: ");
		d.printList(d.head);
		System.out.println("DLL size: "+d.setSize());
		System.out.println("\n");
		
		
		
		System.out.println("DLL l: ");
		l.printList(l.head);
		System.out.println("DLL size: "+l.setSize());
		System.out.println("\n");
		
		System.out.println("Union of d and l: ");
		d.printList(d.union(d, l).head);
		System.out.println("DLL size: "+d.union(d, l).setSize());
		System.out.println("\n");
		
		System.out.println("Intersection of d and l: ");
		d.printList(d.intersection(d, l).head);
		System.out.println("DLL size: "+d.intersection(d, l).setSize());
		System.out.println("\n");
		
		System.out.println("Difference of d and l: ");
		d.printList(d.difference(d, l).head);
		System.out.println("DLL size: "+d.difference(d, l).setSize());
		System.out.println("\n");
		
		System.out.println("Is l a subset of d: ");
		System.out.println(d.subset(d,l)+"\n");
		

		System.out.println("========================================================\n");
		
		FileIO file = new FileIO();		
		String doc = "int20k.txt";
		
		int[] A = file.fileRead(doc);		
		int[] random = new int[100];
		
		BST studyRandomBST = new BST();
		DLL studyRandomDll = new DLL();
		BST study20kBST = new BST();
		DLL study20kDLL = new DLL();
		
		
		for(int i=0;i<random.length;i++) {
			random[i] = getRandomNumber();
			studyRandomBST.add(random[i]);
			studyRandomDll.add(random[i]);
			//System.out.println(entry);
		}
		
		for(int i=0;i<A.length;i++) {
			study20kBST.add(A[i]);
			study20kDLL.add(A[i]);
		}
		
		long start1 = System.nanoTime();
		for(int finder : random) {
			studyRandomBST.isElement(finder);
		}
		long duration1 = System.nanoTime()-start1;		
		System.out.println("Average Time taken to search random100 BST: "+duration1/random.length+"ns");
		
		
		long start2 = System.nanoTime();
		for(int finder : A) {
			study20kBST.isElement(finder);
		}
		long duration2 = System.nanoTime()-start2;		
		System.out.println("Average Time taken to search int20k.txt BST: "+duration2/A.length+"ns");
		

		System.out.println("\n===================================\n");
		
		
		long start3 = System.nanoTime();
		for(int finder : random) {
			studyRandomDll.isElement(finder);
		}
		long duration3 = System.nanoTime()-start3;		
		System.out.println("Average Time taken to search random100 DLL: "+duration3/random.length+"ns");
		
		
		long start4 = System.nanoTime();
		for(int finder : A) {
			study20kDLL.isElement(finder);
		}
		long duration4 = System.nanoTime()-start4;		
		System.out.println("Average Time taken to search int20k.txt DLL: "+duration4/A.length+"ns");
		
		System.out.println("\n===================================\n");
		
		
		System.out.println("BST random100 set size: "+studyRandomBST.setSize());
		System.out.println("BST 20k set size: "+study20kBST.setSize());
		System.out.println("DLL random100 set size: "+studyRandomDll.setSize());
		System.out.println("DLL 20k set size: "+study20kDLL.setSize());

		
	}
	
	public static int getRandomNumber() {
	    return (int) ((Math.random() * (49999 - 0)) + 0);
	}
}
