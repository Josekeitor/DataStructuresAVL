package tree;

import shape.Circle;

/**
 * A binary tree using circle objects.
 * @author Eric Canull
 * @version 1.0
 */
public class TreeNode<T extends Comparable<T>> {
	
	private Circle<T> rootCircle;
	private TreeNode<T> leftCircle;
	private TreeNode<T> rightCircle;
	public boolean highlightFlag;
	private int height;
	
	/**
	 * A binary tree using circle objects.
	 * @param rootCircle a root tree circle
	 * @param leftCircle a left tree circle
	 * @param rightCircle a right tree circle
	 */
	public TreeNode(Circle<T> rootCircle, TreeNode<T> leftCircle, TreeNode<T> rightCircle) {
		this.setRootCircle(rootCircle);
		this.setLeftCircle(null);
		this.setRightCircle(null);
		this.setHeight(0);
	}

	public Circle<T> getRootCircle() {
		return rootCircle;
	}

	public void setRootCircle(Circle<T> rootCircle) {
		this.rootCircle = rootCircle;
	}

	public TreeNode<T> getLeftCircle() {
		return leftCircle;
	}

	public void setLeftCircle(TreeNode<T> leftCircle) {
		this.leftCircle = leftCircle;
	}

	public TreeNode<T> getRightCircle() {
		return rightCircle;
	}

	public void setRightCircle(TreeNode<T> rightCircle) {
		this.rightCircle = rightCircle;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
