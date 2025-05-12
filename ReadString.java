import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * This program recursively calculates the length of a string entered by the user.
 * Author: Alex Kapajika
 * Version: 1.0
 * Since: 2025-05-08
 */
public final class ReadString {
    /**
     * Constant for the input file.
     */
    private static final String INPUT_FILE = "input.txt";
    /**
     * Constant for the output file.
     */
    private static final String OUTPUT_FILE = "output.txt";
    /**
     * Private constructor to prevent instantiation.
     * @throws IllegalStateException Utility class.
     */
    private ReadString() {
        throw new IllegalStateException("Utility Class");
    }
    /**
     * Main method to read the string from input.txt, calculate its length, and write the result to output.txt.
     * @param args Unused.
     */
    public static void main(String[] args) {
        // Create a Scanner object to read from the input file
        try (Scanner scanner = new Scanner(new File(INPUT_FILE));
                FileWriter outputFile = new FileWriter(OUTPUT_FILE)) {
            // Check if the input file exists
            while (scanner.hasNextLine()) {
                // Read a line from the input file
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) {
                    outputFile.write("Empty Line.\n");
                } else {
                    int length = StringLength(line);
                    outputFile.write("Length of the string: " + length + "\n");
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
    /**
     * Recursively calculates the length of a string.
     * @param strLength The string to calculate the length of.
     * @return The length of the string.
     */
    public static int StringLength(String strLength) {
        if (strLength.isEmpty()) {
            return 0;
        } else {
            return 1 + StringLength(strLength.substring(1));
        }
    }
}
