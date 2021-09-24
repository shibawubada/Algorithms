/**
 * @author Harry Goodwin
 * 2557827g
 * 17/03/2021
 */


public class BST<Type extends Comparable<? super Type>>{

	private static class Node<Type>{

		Type x;

		Node<Type> left;
		Node<Type> right;

		Node(Type x){

			this.x=x;
		}
	}

	Node<Type> root;
	public int size=1;

	@SuppressWarnings("rawtypes")
	static BST union = new BST();
	@SuppressWarnings("rawtypes")
	static BST difference = new BST();
	@SuppressWarnings("rawtypes")
	static BST intersection = new BST();

	public BST() {

	}

	/**
	 * 
	 * @param x - integer x
	 * 
	 * method for adding an integer to the BST, first
	 * a new node is created and then check if tree is empty
	 * as this would make our new node the root.  then 
	 * the set property of duplicates is checked and we
	 * can iterate through the tree to find were the 
	 * new node should be situated.
	 */
	public void add(Type x) {

		Node<Type> newNode = new Node<Type>(x);

		if(setEmpty()) {

			root=newNode;
		}
		else {

			if(isElement(x)) {
				return;
			}

			size++;

			Node<Type> focus = root;

			Node<Type> parent;

			while(true) {

				parent = focus;

				if(x.compareTo(root.x) < 0) {

					focus = focus.left;

					if(focus == null) {

						parent.left=newNode;
						return;

					}
				}
				else {

					focus = focus.right;

					if(focus == null) {

						parent.right=newNode;
						return;

					}
				}
			}
		}
	}

	/**
	 * 
	 * @param node - root of s
	 * @param x - removed node
	 * @return
	 * 
	 * first find node looping through the tree using the bst 
	 * property to assist.
	 * 
	 * then if found and the node has 2 children we traverse and find
	 * its smallest right child and replace it with this, other
	 * deletions are easier if it only has a left or right child
	 * we may just replace it with that.
	 * 
	 * if node is root, we just replace node with its right child and
	 * if no right child exists we use left child
	 */
	public void remove(Type x) {

		Node<Type> node = root;
		Node<Type> parent = null;
		
		if(node == null) {
			return;
		}
		
		while(node.x != x) {

			if(x.compareTo(root.x) < 0) {
				parent = node;
				node = node.left;
			}
			else if(x.compareTo(root.x) > 0) {
				parent = node;
				node = node.right;
			}
		}
		
		//removal of root if node is root
		if(node == root) {
			
			if(node.right != null) {
				root = node.right;
				return;

			}
			else if(node.left != null) {
				root=node.left;
				return;

			}
			else {
				root=null;
				return;
			}
		}
		
		//removal of any other node
		if(node.left==null && node.right==null) {
			parent.left=null;
			parent.right=null;
			node=null;
		}
		else if(node.left==null && node.right != null) {
			parent.right = node.right;
			
		}
		else if (node.right==null && node.left != null) {
			parent.left = node.left;
		}
		else if(node.right != null && node.left != null){
			Node<Type> tracker = node;

			while(tracker.left != null) {
				tracker=tracker.left;
				
			}
			node.x=tracker.x;
			tracker=null;
		}
		size--;
	}

	


	/**
	 * 
	 * @param x
	 * @return
	 * 
	 * iterate through nodes traversing the BST finds all 
	 * the nodes then comparing these with integer x
	 */
	public boolean isElement(Type x) {

		Node<Type> node = root;
		
		if(root == null) {
			return false;
		}
		
		while(!node.x.equals(x)) {

			if(x.compareTo(root.x) < 0) {

				node = node.left;
			}
			else if(x.compareTo(root.x) > 0) {

				node = node.right;
			}
			else {

				return true;
			}

			if (node == null) {
				return false;
			}
		}
		return true;
	}


	/**
	 * 
	 * @return
	 * 
	 * if the BST has no root it is empty
	 */
	public boolean setEmpty() {

		return root == null;

	}

	/**
	 * 
	 * @return size
	 * 
	 * abstraction of setSize method
	 */
	public int setSize() {

		return size;
	}

	/**
	 * 
	 * @param s - DST s
	 * @param t - DST t
	 * @return new BST
	 * 
	 * abstraction of union method
	 */
	@SuppressWarnings("unchecked")
	public BST<Type> union(BST<Type> s, BST<Type> t) {

		postOrderUnion(s,t,root);
		postOrderUnion(t,s,t.root);

		return union;

	}


	/**
	 * 
	 * @param s - DST s
	 * @param t - DST t
	 * @param node - node root s
	 * @return t and s union as t
	 * 
	 * using post order traversal i go through tree s, adding
	 * to t as we go.  
	 */
	@SuppressWarnings("unchecked")
	private void postOrderUnion(BST<Type> s, BST<Type> t, Node<Type> node) {

		if(node != null) {

			postOrderUnion(s,t,node.left);
			postOrderUnion(s,t,node.right);

			union.add(node.x);

		}	
	}

	/**
	 * 
	 * @param s - DST s
	 * @param t - DST t
	 * @return new BST
	 * 
	 * abstraction of intersection method
	 */
	public BST<Type> intersection(BST<Type> s, BST<Type> t) {

		return postOrderIntersection(s,t,root);
	}


	/**
	 * 
	 * @param s - DST s
	 * @param t - DST t
	 * @param node - node root s
	 * @return intersection
	 * 
	 * use post order traversal again of s, then checking if each 
	 * element found exists in t and if so adding it to a new BST
	 * intersection
	 */
	@SuppressWarnings("unchecked")
	private BST<Type> postOrderIntersection(BST<Type> s, BST<Type> t, Node<Type> node) {

		if(node != null) {

			postOrderIntersection(s,t,node.left);
			postOrderIntersection(s,t,node.right);

			if(t.isElement(node.x)) {

				intersection.add(node.x);
			}
		}	

		return intersection;
	}

	/**
	 * 
	 * @param s - DST s
	 * @param t - DST t
	 * @return new BST
	 * 
	 * abstraction of difference method
	 */
	@SuppressWarnings("unchecked")
	public BST<Type> difference(BST<Type> s, BST<Type> t) {

		postOrderDifference(s,t,s.root);
		postOrderDifference(t,s,t.root);

		return difference;
	}

	/**
	 * 
	 * @param s - DST s
	 * @param t - DST t
	 * @return
	 * 
	 * does not work post order traversal, must do this twice
	 * once to compare this with other tree and then again
	 * to compare other tree with this.
	 * 
	 * difference is our difference BST although for some
	 * reason i cant return it
	 */
	@SuppressWarnings("unchecked")
	private BST<Type> postOrderDifference(BST<Type> s, BST<Type> t, Node<Type> node) {	

		if(node != null) {

			postOrderDifference(s,t,node.left);
			postOrderDifference(s,t,node.right);

			if(!t.isElement(node.x)) {

				difference.add(node.x);
			}
		}

		return difference;

	}

	/**
	 * 
	 * @param s - DST s
	 * @param t - DST t
	 * @return boolean
	 * 
	 * abstraction of subset method
	 */
	public boolean subset(BST<Type> s, BST<Type> t) {

		return postOrderSubset(s, t,root);
	}

	/**
	 * 
	 * @param s - DST s
	 * @param t - DST t
	 * @param node - s.root
	 * @return
	 * 
	 * uses post order traversal again, if the element x does not exist
	 * in tree t then s is not a subset of t.  if the condition
	 * is not triggered it is indeed a subset.
	 */
	private boolean postOrderSubset(BST<Type> s, BST<Type> t,Node<Type> node) {

		if(node != null) {

			postOrderSubset(s,t,node.left);
			postOrderSubset(s,t,node.right);

			if(!t.isElement(node.x)) {
				return false;
			}	
		}	

		return true;
	}

	public void printInOrder(Node<Type> node) {

		if(node != null) {

			printInOrder(node.left);

			System.out.println(node.x);

			printInOrder(node.right);
		}
	}
}
