/**
  This program was created to help users make their chances of winning the
  Powerball lottery higher. It imports a dataset containing thousands of past years
  Powerball winning numbers in CSV format. The program then analyzes the data
  to determine the most frequently occurring numbers in each of the 6 slots of
  the lottery sequence. Using this information, the program generates a set of
  favorable lottery numbers for the user, based on the frequency data.
  @author Nabeel Merali & Asfandiyar Khan
  @version 2023.1.29
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class lottery {
    public static void main(String[] args) {
        // Historical data csv import
        String csvFile = "C:\\Users\\asfan\\Downloads\\lottery.csv";
        String line = "";
        String cvsSplitBy = ",";

        // making of an array to store the most frequent number in each slot
        int[] mostFrequent = new int[6];

        // making of a 2D array to count the frequency of each number in each column
        int[][] count = new int[1421][6];

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // read each line
            while ((line = br.readLine()) != null) {
                // split the data by line
                String[] data = line.split(cvsSplitBy);
                // loop through each slot/column 
                for (int i = 0; i < 6; i++) {
                    // parse the column and outputs an integer
                    int num = Integer.parseInt(data[i]);
                    // increment the count of the number in the corresponding
                    count[num][i]++;
                }
            }

            // for-loop that loops through each corresponding column 
            for (int i = 0; i < 6; i++) {
                int maxCount = 0;
                int maxNum = 0;
                // loop through each row selection
                for (int j = 0; j < 1421; j++) {
                    // if the count of the number in the column is greater that the max adjust the max count and max number
                    if (count[j][i] > maxCount) {
                        maxCount = count[j][i];
                        maxNum = j;
                    }
                }
                //Store the found value in the mostFrequent array
                mostFrequent[i] = maxNum;
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // make a random number generator
        Random rand = new Random();
        // for-loop that loops through each column
        for (int i = 0; i < 6; i++) {
            // picks a random index in the mostFrequent array
            int randomIndex = rand.nextInt(mostFrequent.length);
            // prints out a number from that selected mostFrequent index
            System.out.println("Most frequent number in column " + (i + 1)
                + ": " + mostFrequent[randomIndex]);
        }
    }
}
