//Rashida Kapadia, Shrivarshini Ganeshkumar, Aditi Chaugule
//Dec 4th, 2025

//Single Threaded
import java.io.*;
import java.io.IOException;

public class MainQuiz {

    public static void main(String[] args) {

        String warAndPeaceInput = "warAndPeace.txt";
        String taleOfTwoCitiesInput = "taleOfTwo.txt";

        String warAndPeaceOutput = "war_and_peace_upper.txt";
        String taleOfTwoCitiesOutput = "tale_of_two_cities_upper.txt";

        long startTime = System.currentTimeMillis();

        // Single-threaded modification AND printing
        convertFileToUppercase(warAndPeaceInput, warAndPeaceOutput);
        convertFileToUppercase(taleOfTwoCitiesInput, taleOfTwoCitiesOutput);

        long endTime = System.currentTimeMillis();

        System.out.println("Finished converting both books.");
        System.out.println("Total time (ms): " + (endTime - startTime));
        System.out.println("Total time (seconds): " + ((endTime - startTime) / 1000.0));
    }

    public static void convertFileToUppercase(String inputPath, String outputPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            String line;

            while ((line = reader.readLine()) != null) {

                // extremely inefficient string building
                String upperLine = "";
                for (int i = 0; i < line.length(); i++) {
                    upperLine = upperLine + Character.toUpperCase(line.charAt(i));
                }

                // write to file
                writer.write(upperLine);
                writer.newLine();

                // print it to the console (slow on purpose)
                System.out.println(upperLine);
            }

        } catch (IOException e) {
            System.out.println("Error processing: " + inputPath);
            e.printStackTrace();
        }
    }
}
