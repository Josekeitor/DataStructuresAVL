package tree;

import java.util.Objects;

import shape.Circle;

/**
 * Binary search tree. 
 * Inherits isEmpty(), makeEmpty(), getRootItem(), and the
 * use of the constructors from tree.BinaryTreeBasis Assumption: A tree contains at
 * most one item with a given search key at any time.
 * 
 * @author Eric Canull
 * @version 1.0
 */
public final class BinarySearchTree<T extends Comparable<T>> extends BinaryTreeBasis<T> {

	private String message;


	/**
	 * Binary search tree.
	 */
	public BinarySearchTree() {
		this.root = null;
	}

	/**
	 * Binary search tree.
	 * @param rootCircle
	 * @Overload Default constructor
	 */
	public BinarySearchTree(Circle<T> rootCircle) {
		super(rootCircle);
	}

	/**
	 * Inserts a new circle into the tree.
	 * @param newCircle
	 */
	public void insertItem(Circle<T> newCircle) {
		root = insertItem(root, newCircle);
	}
	
	/**
	 * Inserts a new circle into the tree.
	 * @param tNode a tree node
	 * @param newCircle a new circle
	 * @return 
	 * @Overload insertItem() 
	 */
	protected TreeNode insertItem(TreeNode tNode, Circle<T> newCircle) {
		TreeNode newSubtree;
		message ="";

		if(tNode == null) {
			tNode = new TreeNode(newCircle, null, null);
			return tNode;
		}else{
			Circle<T> nodeItem = tNode.getRootCircle();
			if(newCircle.getSearchKey().compareTo(nodeItem.getSearchKey())>0){
				newSubtree = insertItem(tNode.getRightCircle(), newCircle);
				tNode.setRightCircle(newSubtree);

			}else if(newCircle.getSearchKey().compareTo(nodeItem.getSearchKey())<0){
				newSubtree = insertItem(tNode.getLeftCircle(), newCircle);
				tNode.setLeftCircle(newSubtree);
			}
		}
		System.out.println("Equilibrium factor: "+calculateEquilibriumFactor(tNode));
		if(Math.abs(calculateEquilibriumFactor(tNode)) == 2){
			System.out.println("Unbalanced node: "+ tNode.getRootCircle().getSearchKey());
			if(tNode.getRootCircle().getSearchKey().compareTo(newCircle.getSearchKey()) > 0){
				if(tNode.getLeftCircle().getRootCircle().getSearchKey().compareTo(newCircle.getSearchKey()) > 0 ){

					message = "Unbalanced node: "+tNode.getRootCircle().getSearchKey()+" fixed with simple right rotation";
					tNode=rotateRight(tNode);

				}else{

					message = "Unbalanced node: "+tNode.getRootCircle().getSearchKey()+" fixed with double right rotation";
					tNode = rotateTwiceRight(tNode);

				}

			}else if(tNode.getRootCircle().getSearchKey().compareTo(newCircle.getSearchKey()) < 0){
				if(tNode.getRightCircle().getRootCircle().getSearchKey().compareTo(newCircle.getSearchKey()) < 0){


					message = "Unbalanced node: "+tNode.getRootCircle().getSearchKey()+" fixed with simple left rotation";
					tNode = rotateLeft(tNode);
				}else{


					message = "Unbalanced node: "+tNode.getRootCircle().getSearchKey()+" fixed with double left rotation";
					tNode = rotateTwiceLeft(tNode);
				}
			}
		}
		return tNode;
	}

	private TreeNode rotateTwiceRight(TreeNode node){
		node.setLeftCircle(rotateLeft(node.getLeftCircle()));
		return rotateRight(node);
	}

	private TreeNode rotateTwiceLeft(TreeNode node){
		node.setRightCircle(rotateRight(node.getRightCircle()));
		return rotateLeft(node);
	}


	
	/**
	 * Retrieves a circle from the tree.
	 * @param searchKey a unique identifying value
	 * @return An integer search key number
	 */

	private TreeNode rotateRight(TreeNode node){
		TreeNode temp = node.getLeftCircle();
		node.setLeftCircle(temp.getRightCircle());
		temp.setRightCircle(node);

		node.setHeight(max(getHeight(node.getLeftCircle()),getHeight(node.getRightCircle()))+1);
		temp.setHeight(max(getHeight(temp.getLeftCircle()),getHeight(node))+1);

		//node.setHeight(max(node.getLeftCircle().getHeight(),node.getRightCircle().getHeight())+1);
		//temp.setHeight(max(temp.getLeftCircle().getHeight(),node.getHeight())+1);

		return temp;
	}

	private TreeNode rotateLeft(TreeNode node){
		TreeNode temp = node.getRightCircle();

		node.setRightCircle(temp.getLeftCircle());
		temp.setLeftCircle(node);
		node.setHeight(max(getHeight(node.getRightCircle()),getHeight(node.getLeftCircle()))+1);
		temp.setHeight(max(getHeight(temp.getRightCircle()),getHeight(node))+1);
		return temp;
	}

	public T retrieveItem(T searchKey) {
		return retrieveItem(root, searchKey);
	}

	private int calculateEquilibriumFactor(TreeNode root){
		if(root == null){
			return 0;
		}else{

			return getHeight(root.getLeftCircle()) - (getHeight(root.getRightCircle()));
		}

		}


	private int max(int a, int b){
		if(a>b){
			return a;
		}else{
			return b;
		}
	}

	private int min(int a, int b){
		if(a<b){
			return a;
		}else{
			return b;
		}
	}
	
	
	/**
	 * Searches for a circle from the tree.
	 * @param tNode a tree node 
	 * @param searchKey a unique identifying value
	 * @return An integer search key number
	 * @Overload retrieveItem()
	 */
	protected T retrieveItem(TreeNode<T> tNode, T searchKey) {
		T treeItem;
		if (tNode == null) {
			treeItem = null;

		} else {
			tNode.highlightFlag = true;
			Circle<T> nodeItem = tNode.getRootCircle();
			if (searchKey.compareTo(nodeItem.getSearchKey()) == 0) {
				tNode.highlightFlag = true;
				treeItem = tNode.getRootCircle().getSearchKey();

			} else if (searchKey.compareTo(nodeItem.getSearchKey()) < 0) {
				tNode.getLeftCircle().highlightFlag = true;
				treeItem = retrieveItem(tNode.getLeftCircle(), searchKey);
			} else {
				tNode.getRightCircle().highlightFlag = true;
				treeItem = retrieveItem(tNode.getRightCircle(), searchKey);
			}
		}

		return treeItem;
	}
	
	/**
	 * Deletes a circle from the tree.
	 * @param searchKey a unique identifying value
	 * @throws TreeException if search key cannot be located.
	 */
	public void deleteItem(T searchKey) throws TreeException {
		root = deleteItem(root, searchKey);
	}
	
	/**
	 * Deletes a circle from the tree.
	 * @param tNode a tree node 
	 * @param searchKey a unique identifying value
	 * @return A tree.TreeNode from within the tree
	 * @Overload deleteItem()
	 */
	protected TreeNode<T> deleteItem(TreeNode<T> tNode, T searchKey) {
		TreeNode<T> newSubtree;
		message ="";
		
		if (tNode == null) {
			throw new TreeException("tree.TreeException: Item not found");
		}
		
		Circle<T> nodeItem = tNode.getRootCircle();
		if (Objects.equals(searchKey, nodeItem.getSearchKey())) {
			tNode = deleteNode(tNode);


		} else if (searchKey.compareTo(nodeItem.getSearchKey()) < 0) {
			newSubtree = deleteItem(tNode.getLeftCircle(), searchKey);
			tNode.setLeftCircle(newSubtree);
		}

		else {
			newSubtree = deleteItem(tNode.getRightCircle(), searchKey);
			tNode.setRightCircle(newSubtree);
		}

		if(Math.abs(calculateEquilibriumFactor(tNode)) == 2){
			System.out.println("Unbalanced node: "+tNode.getRootCircle().getSearchKey());
			TreeNode comparator;


			if(getHeight(tNode.getLeftCircle())> getHeight(tNode.getRightCircle())){
				comparator =tNode.getLeftCircle();

				if(getHeight(comparator.getLeftCircle())> getHeight(comparator.getRightCircle())){

					message = "Unbalanced node: "+tNode.getRootCircle().getSearchKey()+" fixed with simple right rotation";
					tNode = rotateRight(tNode);

				}else{


					message = "Unbalanced node: "+tNode.getRootCircle().getSearchKey()+" fixed with double right rotation";
					tNode = rotateTwiceRight(tNode);
				}
			}else{
				comparator = tNode.getRightCircle();

				if(getHeight(comparator.getRightCircle()) > getHeight(comparator.getLeftCircle())){

					message = "Unbalanced node: "+tNode.getRootCircle().getSearchKey()+" fixed with simple left rotation";
					tNode = rotateLeft(tNode);
				}else{

					message = "Unbalanced node: "+tNode.getRootCircle().getSearchKey()+" fixed with double left rotation";
					tNode = rotateTwiceLeft(tNode);
				}
			}
			System.out.println(message);
		}








		return tNode;
	}
	
	/**
	 * Helper method finds and replaces a deleted node. 
	 * @param tNode A tree.TreeNode from within the tree
	 * @return A tree.TreeNode from within the tree
	 */
	protected TreeNode deleteNode(TreeNode tNode) {

		Circle<Integer> replacementItem;

		if ((tNode.getLeftCircle() == null) && (tNode.getRightCircle() == null)) {
			return null;
		}

		else if (tNode.getLeftCircle() == null) {
			return tNode.getRightCircle();
		}

		else if (tNode.getRightCircle() == null) {
			return tNode.getLeftCircle();
		} else {

			replacementItem = findLeftmost(tNode.getRightCircle());
			tNode.setRootCircle(replacementItem);
			tNode.setRightCircle(deleteLeftmost(tNode.getRightCircle()));
			return tNode;
		}





	}

	/**
	 * Helper method for searching and deleting left-side nodes.
	 * @param tNode
	 * @return
	 */
	protected Circle<Integer> findLeftmost(TreeNode tNode) {
		if (tNode.getLeftCircle() == null) {
			return tNode.getRootCircle();
		}
		return findLeftmost(tNode.getLeftCircle());
	}
	
	/**
	 * Helper method for searching and deleting right-side nodes.
	 * @param tNode
	 * @return
	 */
	protected TreeNode deleteLeftmost(TreeNode tNode) {
		if (tNode.getLeftCircle() == null) {
			return tNode.getRightCircle();
		}
		tNode.setLeftCircle(deleteLeftmost(tNode.getLeftCircle()));
		return tNode;
	}
	
	/**
	 * Resets the color to the default.
	 * @param tNode
	 */
	public void setResetColor(TreeNode tNode) {
		 resetColor(tNode);
	}
	
	
	/**
	 * Resets the color to the default.
	 * @param tNode A node in the tree
	 * @Overload
	 */
	private void resetColor(TreeNode tNode) {
		if (tNode != null) {
			tNode.highlightFlag = false;

			if (tNode.getLeftCircle() != null) {
				tNode.getLeftCircle().highlightFlag = false;
			}

			if (tNode.getRightCircle() != null) {
				tNode.getRightCircle().highlightFlag = false;
			}
			resetColor(tNode.getLeftCircle());
			resetColor(tNode.getRightCircle());
		}
	}


	/**
	 * Gets the height of the tree
	 * @param root
	 * @return
	 */
	public int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(getHeight(root.getLeftCircle()), getHeight(root.getRightCircle())) + 1;
	}
	
	/**
	 * Gets the size of the tree
	 * @param root
	 * @return
	 */
	public int getSize(TreeNode root) {
		if (root == null)
			return 0;
		return (getSize(root.getLeftCircle()) + getSize(root.getRightCircle())) + 1;
	}

	public String getMessage(){
		return message;
	}
	
	@Override
	public void setRootItem(Circle<T> newItem) {
		root = new TreeNode<>(newItem, null, null);
	}
}
