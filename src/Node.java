/**
 * Class to create node object
 *
 * @param <T> is the target node
 * @author Georgio McGarrah
 * @version version 1
 */
class Node<T extends Comparable<T>> {
    /**
     * Variable for the depth of the BST
     */
    private int depth;

    /**
     * Houses nodes left sub-node
     */
    protected Node<T> left;

    /**
     * Houses nodes right sub-node
     */
    protected Node<T> right;

    /**
     * Variable for the data of the node
     */
    private T data;

    /**
     * Constructor instantiation for the node object
     *
     * @param data target data to be stored in a node
     */
    public Node(T data) {
        this(data, null, null);
    }


    /**
     * Constructor for Node object
     *
     * @param data          target data to be stored
     * @param newLeftChild  new left node
     * @param newRightChild new right node
     */
    public Node(T data, Node<T> newLeftChild, Node<T> newRightChild) {
        this.data = data;
        left = newLeftChild;
        right = newRightChild;
    }

    /**
     * Method gets depth of BST
     *
     * @return depth of BST
     */
    public int getDepth() {
        return depth;
    }


    /**
     * Method sets the depth of the BST
     *
     * @param depth target value
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * Method returns data of the node object
     *
     * @return target data
     */
    public T getData() {
        return data;
    }


    /**
     * Method sets the data in the node object
     *
     * @param data target data
     */
    public void setData(T data) {
        this.data = data;
    }


    /**
     * Method gets the left child node
     *
     * @return the target left child node
     */
    public Node<T> getLeft() {
        return left;
    }
}