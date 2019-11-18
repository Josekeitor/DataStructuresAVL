public class Node<T extends Comparable<T>> {
    private Node<T> right;
    private Node<T> left;
    private T element;

    public Node(T element){
        this.element = element;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}
