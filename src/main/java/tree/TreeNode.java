package tree;

import shape.Circle;

/**
 * A binary tree using circle objects.
 * @author Eric Canull
 * @version 1.0
 */
public class TreeNode<T> {
	
	private Circle rootCircle;
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
	public TreeNode(Circle rootCircle, TreeNode leftCircle, TreeNode rightCircle) {
		this.setRootCircle(rootCircle);
		this.setLeftCircle(null);
		this.setRightCircle(null);
		this.setHeight(0);
	}

	public Circle getRootCircle() {
		return rootCircle;
	}

	public void setRootCircle(Circle rootCircle) {
		this.rootCircle = rootCircle;
	}

	public TreeNode getLeftCircle() {
		return leftCircle;
	}

	public void setLeftCircle(TreeNode leftCircle) {
		this.leftCircle = leftCircle;
	}

	public TreeNode getRightCircle() {
		return rightCircle;
	}

	public void setRightCircle(TreeNode rightCircle) {
		this.rightCircle = rightCircle;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
