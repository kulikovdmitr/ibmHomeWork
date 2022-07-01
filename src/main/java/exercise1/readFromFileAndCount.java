package exercise1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class readFromFileAndCount {
    public static void main(String[] args) {

        final String regex = "(^[^.]+)";

        try {
            File myObj = new File("src/main/java/exercise1/filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                final Pattern pattern = Pattern.compile(regex);
                final Matcher matcher = pattern.matcher(data);

                if (matcher.find()) {
                    String findString =  matcher.group(0).trim();
                    int countWords = findString.split("\s+").length;
                    String[] words = findString.split("/[,\\s]+|[,\\s]+");

                    Arrays.sort(words, Comparator.comparingInt(String::length));

                    System.out.println("Results:" + "\n" + "Number of words: " + countWords);
                    System.out.println("First smallest word : " + words[0] + " (\"" + words[0] + "\" and " + "\""  + words[1] +
                            "\"" + " are the 2 smallest but we want the first of the smallest)");
                    System.out.println("Last longest word : " + words[countWords - 1] +  " (\"" + words[countWords - 1] + "\" and " + "\"" +  words[countWords - 2] + "\"" +
                            " are the 2 longest words, but " + "\"" + words[countWords - 2] + "\"" + " is the last one)");
                    break;
                } else {
                    System.out.println("String with Dot does not exist." );
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
