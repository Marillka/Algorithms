package lesson6_Trees.lesson;

// сам узел
public class Node<T extends Comparable<T>> {
    private T value;

    private Node<T> leftChild;
    private Node<T> rightChild;

    Boolean isRepeat;

    int repeatCount;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    public boolean isLeftChild(T value) {
        return getValue().compareTo(value) > 0;
    }

    // метод для проверки: есть ли дочерние элементы у Node
    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    public boolean hasOnlyOneChild() {
//        return leftChild == null && rightChild != null
//                || rightChild == null && leftChild != null;

        return rightChild != null ^ leftChild != null;
    }
}
