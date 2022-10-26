import java.util.LinkedList;


/**
 * Classed used to house BST
 *
 * @param <T> generic elements to be housed.
 * @author Georgio McGarrah
 * @version version 1
 */
public class BST<T extends Comparable<T>> implements BSTInterface {
    private Node<T> root;
    private final LinkedList<String> nodes = new LinkedList<>();

    /**
     * Constructor Method
     */
    public BST() {
        root = null;
    }


    /**
     * Method used to find if BST is empty
     *
     * @return boolean value if BST is empty
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }


    /**
     * Method inserts nodes into BST
     *
     * @param value target node
     */
    public void insert(Node<T> value) {
        if (isEmpty()) { // checks to see if the BST is empty
            root = value;

        }
        else
        {
            insert(root, value);  //Helper method used to set nodes in BST
        }
    }

    /**
     * Method compares each inserted node to determine where each node belong.
     *
     * @param tRoot target root vale
     * @param value the data stored
     */
    protected void insert(Node<T> tRoot, Node<T> value) {
        if (value.getData().compareTo(tRoot.getData()) < 0) {
            if (tRoot.getLeft() == null) {
                tRoot.left = value;
            }
            else
            {
                insert(tRoot.left, value);
            }

        }
        else
        {
            if (tRoot.right == null) {
                tRoot.right = value;

            }
            else
            {
                insert(tRoot.right, value);
            }
        }
    }

    /**
     * Method searches BST for a particular value
     *
     * @param data target value
     * @return boolean if node with data (value) is present
     */
    public boolean search(T data) {
        return search(root, data);
    }


    /**
     * Method searches for node in BST with a particular value
     *
     * @param tRoot target node
     * @param data  target value
     * @return boolean if node with data (value) is present
     */
    private boolean search(Node<T> tRoot, T data) {
        if (tRoot == null) {
            return false;

        }
        else if (data.compareTo(tRoot.getData()) < 0)
        {
            return search(tRoot.left, data);

        }
        else if (data.compareTo(tRoot.getData()) > 0)
        {
            return search(tRoot.right, data);
        }
        else
        {
            return true;
        }
    }

    /**
     * Method searches for a node in a BST using recursion.
     *
     * @param values the data for the target node stored in the World class
     */
    public void inorder(LinkedList<KeyValuePair> values) {
        int depth = 0;

        if (root == null) {
            return;

        }

        inorder(root.left);
        nodes.add(root.getData().toString());
        inorder(root.right);
        getValues(values);
        nodes.clear();
    }

    /**
     * Method searches for a node in a BST using recursion.
     *
     * @param tRoot the target node
     */
    protected void inorder(Node<T> tRoot) {
        if (tRoot == null) {
            return;

        }
        inorder(tRoot.left);
        nodes.add(tRoot.getData().toString());
        inorder(tRoot.right);
    }

    /**
     * Method used to delete a node
     *
     * @param data the target node
     */
    protected void delete(T data) {
        root = remove(root, data);
    }

    /**
     * Method gets the values of a node in the Binary search tree
     *
     * @param values are the key value pairs found in the World.java file
     */
    protected void getValues(LinkedList<KeyValuePair> values) {


        for (String s : nodes) {
            for (int i = 0; i < values.size(); i++) {
                if (s.equals(values.get(i).getKey())) {
                    System.out.println("Node has depth " + ", " +
                            "Value (" + values.get(i).getKey() + ", "
                            + values.get(i).getRec().x + ", "
                            + values.get(i).getRec().x + ", "
                            + values.get(i).getRec().width + ", "
                            + values.get(i).getRec().height + ")");
                }
            }
        }
    }


    /**
     * Method used to remove nodes in Binary search tree
     *
     * @param tRoot root node of tree
     * @param data  is the data within the root node
     * @return root node
     */
    protected Node<T> remove(Node<T> tRoot, T data) {

        if (tRoot == null) {
            return null;

        }
        else if (data.compareTo(tRoot.getData()) < 0)
        {
            tRoot.left = remove(tRoot.left, data);
        }
        else if (data.compareTo(tRoot.getData()) > 0)
        {
            tRoot.right = remove(tRoot.right, data);
        }
        else
        {
            if (tRoot.left == null && tRoot.right == null)
            {
                return null;
            }
            else if (tRoot.right == null)
            {
                System.out.println(tRoot.left.getData());
                return tRoot.left;
            }
            else if (tRoot.left == null)
            {
                System.out.println(tRoot.right.getData());
                return tRoot.right;
            }
            else
            {
                tRoot.setData(findMax(tRoot.left));
                tRoot.left = remove(tRoot.left, tRoot.getData());
            }
        }
        return tRoot;
    }

    /**
     * Helper method used to find the max value of a subtree
     *
     * @param tRoot the root node
     * @return the max value of the root
     */
    private T findMax(Node<T> tRoot) {
        while (tRoot.right != null) {
            tRoot = tRoot.right;

        }
        return tRoot.getData();
    }
}

