import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;


/**
 * Class to create a bounded world and house
 *
 * @author Georgio McGarrah
 * @version version 1
 */
public class World {

    /**
     * Constructor of world object
     */
    private Rectangle worldMap = new Rectangle(0, 0, 1024, 1024);

    /**
     * new kvp list
     */
    private LinkedList<KeyValuePair> list = new LinkedList<>();

    /**
     * new BST
     */
    private BST<String> tree = new BST<>();

    /**
     * rectangle object
     */
    private Rectangle rectangle;
    /**
     * key value pair object
     */
    private KeyValuePair kvp;
    /**
     * new node object
     */
    private Node<String> newNode;

    /**
     * Constructor of world object
     */
    public World() {
        //Constructor
    }


    /**
     * Method creates and inserts a rectangle into BST
     *
     * @param name target key value for rectangle
     * @param x    target x value
     * @param y    target y value
     * @param w    target width value
     * @param h    target height value
     */
    public void createAndInsert(String name, int x, int y, int w, int h) {

        // Instantiating new rectangle element
        rectangle = new Rectangle(x, y, w, h);

        if (worldMap.contains(rectangle)) {

            // Creating a Key Value Pair to easily search for rectangles
            kvp = new KeyValuePair(name, rectangle);

            // adding KVP to linked list for storage
            list.add(kvp);

            //Prints acceptance message
            System.out.println("Rectangle Accepted: (" + name + ", "
                    + x + ", " + y + ", " + w + ", " + h + ")");

            // Creating a new node with the value of name
            newNode = new Node<>(name);

            // inserting the node into BST
            tree.insert(newNode);

        }
        else
        {
            System.out.println("Rectangle Rejected: (" + name
                    + ", " + x + ", " + y + ", " + w + ", " + h + ")");
        }
    }

    /**
     * Method removes a rectangle for the BST
     *
     * @param name target name value
     */
    public void removeRectangle(String name) {
        newNode = new Node<>(name);

        if (tree.search(name)) {

            for (KeyValuePair tKvp : list) {

                if (tKvp.getKey().equals(name)) {
                    tree.delete(name);
                    System.out.println("Rectangles removed: "
                            + rectangleString(tKvp));
                    list.remove(tKvp);
                }
            }

        }
        else
        {
            System.out.println("Rectangle rejected: "
                    + name);
        }
    }


    /**
     * Method removes a rectangle by coordinates
     *
     * @param x target x coordinate
     * @param y target y coordinate
     * @param w target width coordinate
     * @param h target height coordinate
     */
    public void removeByCoords(int x, int y, int w, int h) {
        rectangle = new Rectangle(x, y, w, h);
        boolean found = false;

        for (KeyValuePair tKVP : list) {
            if (tKVP.getRec().equals(rectangle)) {
                tree.delete(tKVP.getKey());
                System.out.println("Rectangles removed: "
                        + rectangleString(tKVP));
                list.remove(tKVP);
                found = true;
                break;

            }
            else
            {
                found = false;
            }
        }

        if (!found) {
            System.out.println("Rectangle rejected: (" + x
                    + ", " + y + ", " + h + ", " + w + ")");
        }

    }


    /**
     * Method finds intersections of all rectangles in the BST
     */
    public void intersections() {
        if (list.isEmpty()) {
            System.out.println("Intersecting Pairs: ");

        }
        else
        {
            System.out.println("Intersections pairs: ");
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i).getRec().intersects(list.get(j).getRec())) {
                        System.out.println("(" + rectangleString(list.get(i))
                                + " | " + rectangleString(list.get(j)) + ")");
                    }
                }
            }
        }
    }


    /**
     * Method searches BST for a particular name
     *
     * @param name target name
     */
    public void searchBST(String name) {
        if (tree.search(name)) {
            for (KeyValuePair tKVP : list) {

                if (tKVP.getKey().equals(name)) {
                    System.out.println("Rectangles found: ("
                            + rectangleString(tKVP) + ")");
                }
            }
        }
        else
        {
            System.out.println("Rectangle not found: " + name);
        }
    }


    /**
     * Method finds all rectangles in a given region
     *
     * @param x target x coordinate
     * @param y target y coordinate
     * @param w target width coordinate
     * @param h target height coordinate
     */
    public void regionSearch(Integer x, Integer y, Integer w, Integer h) {
        rectangle = new Rectangle(x, y, w, h);
        boolean print = false;
        String s = "Rectangles intersecting region (" + x
                + ", " + y + ", " + w + ", " + h + "):";

        for (KeyValuePair tKvp : list) {
            if (tKvp.getRec().intersects(rectangle)) {

                if (!print){
                    System.out.println("Rectangles intersecting region (" + x
                            + ", " + y + ", " + w + ", " + h + "):");

                    print = true;

                }
                else
                {
                    System.out.println("(" + rectangleString(tKvp) + ")");
                }

            }
        }
    }


    /**
     * Method prints the rectangle to a sting value
     *
     * @param tKVP target rectangle to be printed
     * @return string of target value
     */
    public String rectangleString(KeyValuePair tKVP) {
        String recToString = tKVP.getKey()
                + ", " + tKVP.getRec().x
                + ", " + tKVP.getRec().y + ", "
                + tKVP.getRec().width + ", "
                + tKVP.getRec().height;

        return recToString;
    }

    /**
     * Method used to print entire BST
     */
    public void dump() {
        if (list.isEmpty()){
            System.out.println("BST dump:");
            System.out.println("Node has depth 0, Value (null)");
            System.out.println("BST size is: " + list.size());
        }
        else
        {
            System.out.println("BST dump:");
            tree.inorder(list);
            System.out.println("BST size is: " + list.size());
        }

    }
}
