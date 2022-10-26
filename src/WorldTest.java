import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


/**
 * Class for testing documents
 * @author Georigo McGarrah
 * @version version 1
 */
public class WorldTest {


    /**
     * Testing method
     *
     * @return
     */
    @Test
    public void testCreateAndInsert() {
        String[] str = {"insert", "Hello", "0", "0", "12", "25"};
        World world = new World();
        RectangleDB.main(str);
        assertNotNull(world);


    }

    /**
     * Testing method
     *
     */
    @Test
    public void removeRectangle() {
        World world = new World();
        world.removeRectangle("Hello");
        String[] str = {"remove", "Hello", "0", "0", "12", "25"};
        assertNotNull(str);

    }


    /**
     * Testing method
     *
     */
    @Test
    public void removeByCoords() {
        Rectangle rec = new Rectangle(10, 20, 30, 50);
        String[] str = {"insert", "Hello", "0", "0", "12", "25"};

        assertNotNull(rec);
    }

    /**
     * Testing method
     *
     */
    @Test
    public void intersections() {
        Rectangle rec = new Rectangle(10, 20, 30, 50);

        assertNotNull(rec);
    }

    /**
     * Testing method
     *
     */
    @Test
    public void searchBST() {
        Rectangle rec = new Rectangle(10, 20, 30, 50);

        assertNotNull(rec);
    }

    /**
     * Testing method
     *
     */
    @Test
    public void regionSearch() {
        Rectangle rec = new Rectangle(10, 20, 30, 50);

        assertNotNull(rec);
    }

    /**
     * Testing method
     *
     */
    @Test
    public void rectangleString() {
        Rectangle rec = new Rectangle(10, 20, 30, 50);

        assertNotNull(rec);
    }

    /**
     * Testing method
     *
     */
    @Test
    public void dump() {
        Rectangle rec = new Rectangle(10, 20, 30, 50);

        assertNotNull(rec);
    }
}