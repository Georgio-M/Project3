import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Class used to process each row of the input file
 *
 * @author Georgio McGarrah
 * @version version 1
 */
public class CommandProcessor {

    /**
     * Creating a new world object
     */
    private final World world = new World();

    /**
     * Method used to read a file and split each of its rows
     *
     * @param tfile target file to be read
     */
    public void processFile(File tfile) {
        BufferedReader br = null;
        String[] row;

        // Creating new string object
        String temp;

        try {
            String sCurrentLine;

            br = new BufferedReader(new FileReader(tfile));

            while ((sCurrentLine = br.readLine()) != null) {

                temp = sCurrentLine;


                row = temp.split(" ");
                processRow(row);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Method used to determine if the width and height are less than 1
     *
     * @param w target width
     * @param h target height
     * @return boolean value based on target value being larger than 0
     */
    public boolean processWandH(Integer w, Integer h) {

        return w >= 1 && h >= 1;
    }

    /**
     * Method used to validate the first letter of the
     * rectangles name is a letter
     *
     * @param tName target rectangle name
     * @return boolean value based on result
     */
    public boolean processName(String tName) {
        String ch = String.valueOf(tName.charAt(0));

        return ch.matches("[A-Za-z]+");
    }


    /**
     * Method used to remove all blank spaces in a particular row
     *
     * @param tRow target row
     */
    public void processRow(String[] tRow) {
        LinkedList<String> data;
        data = new LinkedList<>();

        for (String s : tRow) {
            if (!s.isEmpty()) {
                data.add(s);
            }
        }

        if (!data.isEmpty()) {
            commandActions(data);
        }
    }


    /**
     * Method actions commands from each row in the file
     *
     * @param tData the target command
     */
    public void commandActions(LinkedList<String> tData) {
        String name;
        int x;
        int y;
        int w;
        int h;

        switch (tData.get(0)) {
            case "insert":
                name = tData.get(1);
                x = Integer.parseInt(tData.get(2));
                y = Integer.parseInt(tData.get(3));
                w = Integer.parseInt(tData.get(4));
                h = Integer.parseInt(tData.get(5));

                if (processWandH(w, h) && processName(name)) {
                    world.createAndInsert(name, x, y, w, h);

                }
                else
                {
                    System.out.println("Rectangle rejected: ("
                            + name + ", " + x + ", "
                            + y + ", " + w + ", " + h + ")");
                }

                break;

            case "remove":
                if (tData.size() > 2) {
                    x = Integer.parseInt(tData.get(1));
                    y = Integer.parseInt(tData.get(2));
                    w = Integer.parseInt(tData.get(3));
                    h = Integer.parseInt(tData.get(4));
                    processWandH(w, h);
                    world.removeByCoords(x, y, w, h);

                }
                else
                {
                    name = tData.get(1);
                    world.removeRectangle(name);
                }

                break;

            case "regionsearch":
                x = Integer.parseInt(tData.get(1));
                y = Integer.parseInt(tData.get(2));
                w = Integer.parseInt(tData.get(3));
                h = Integer.parseInt(tData.get(4));
                if (processWandH(w, h)) {
                    world.regionSearch(x, y, h, w);
                }

                break;

            case "intersections":
                world.intersections();
                break;

            case "search":
                name = tData.get(1);
                world.searchBST(name);
                break;

            case "dump":
                world.dump();
                break;

            default:
                System.out.println("SWITCH COULD NOT FIND ACTION: "
                        + tData.get(0));
        }
    }

}
