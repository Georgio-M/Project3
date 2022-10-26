import java.awt.*;

/**
 * Class used to create new key value pair objects
 * @author Georgio McGarrah
 * @version version 1
 */
class KeyValuePair {
    private String key;
    private Rectangle rec;

    /**
     * Constructor to create a Key value pair object to be store
     *
     * @param key kev value
     * @param rec the rectangle to be stored in object
     */
    public KeyValuePair(String key, Rectangle rec) {
        this.key = key;
        this.rec = rec;
    }

    /**
     * Method finds the key value
     *
     * @return target key value
     */
    public String getKey() {
        return key;
    }

    /**
     * Method sets key value
     *
     * @param key target value to be set
     */
    public void setKey(String key) {
        this.key = key;
    }


    /**
     * Method returns the target rectangle
     *
     * @return target rectangle
     */
    public Rectangle getRec() {
        return rec;
    }


    /**
     * Method set rectangle value
     *
     * @param rec target rectangle
     */
    public void setRec(Rectangle rec) {
        this.rec = rec;
    }
}
