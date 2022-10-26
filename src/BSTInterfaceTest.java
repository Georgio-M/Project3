import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Class for testing documents
 *
 * @author Georigo McGarrah
 * @version version 1
 */
public class BSTInterfaceTest {

    /**
     * Method to empty BST
     */
    @Test
    public void testIsEmpty() {
        BST tree = new BST();
        assertTrue(tree.isEmpty());
    }
}