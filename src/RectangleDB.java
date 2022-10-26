import java.io.File;

/**
 * The class containing the main method.
 *
 */
public class RectangleDB {
    /**
     * Main method
     *
     * @param args target arguments
     */
    public static void main(String[] args) {
        CommandProcessor cp = new CommandProcessor();
        File file = new File("D:/Virginia Tech/Fall 2022/CS5040 " +
                "(DSA)/Project _Test/src/commandFile.txt");

        cp.processFile(file);
    }


    /**
     * The class containing the main method.
     *
     * @author Georgio McGarrah
     * @version Version 1
     */

// On my honor:
//
// - I have not used source code obtained from another student,
// or any other unauthorized source, either modified or
// unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
// anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.
}