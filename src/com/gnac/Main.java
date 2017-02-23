package com.gnac;

import com.gnac.models.Cell;
import com.gnac.models.Pizza;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	// write your code here
       // System.out.println("Booinux un");

        String[][] rawArray = getRawArrayFromFile("small.in");
        int[] pizzaDescription = Stream.of(rawArray[0]).mapToInt(Integer::parseInt).toArray();
        Pizza pizza= createPizzaFromArray(pizzaDescription,rawArray);
        pizza.cutSlices();
        String submissionString = pizza.getSubmissionString();
        createSubmissionFile("small",submissionString);

    }


    /**
     * Creates pizza object
     * @param pizzaDescription
     * @param rawArray
     * @return
     */
    public static Pizza createPizzaFromArray(int [] pizzaDescription,String [][] rawArray){
        Pizza pizza;
        String tomato = "T";
        if (pizzaDescription.length==4){
            pizza = new Pizza(pizzaDescription);

            for (int x=0; x<pizza.getRows();x++){
                for (int y=0; y<pizza.getColumns();y++){
                    String c = rawArray[x][y];
                    Cell cell = new Cell(Objects.equals(c, tomato),x,y);
                    pizza.addCell(cell);
                }
            }

            return pizza;
        }

        return null;
    }


    /**
     * To replace with Providence's method
     * @param fileName
     * @return
     */
    public static int[] getPizzaDescriptionFromFile(String fileName){
        //Todo
        int [] pizzaDescription = new int[4];
        return pizzaDescription;
    }

    /**
     * To replace with Providence's method
     * @param fileName
     * @return
     */
    public static String[][] getRawArrayFromFile(String fileName){
        try {
            int count = 0;
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String[] imageLine = reader.readLine().split("\\s");
            int row = Integer.parseInt(imageLine[0]);
            int column = Integer.parseInt(imageLine[1]);

            String[][] image = new String[row][column];
            while (count < column) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                String[] temp = line.split("(?!^)");
                image[count] = temp;
                count++;
            }
            return image;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Logic to be done by Bongani, the file created will be a text file with .out at the end. The string will be provided
     * @param fileName
     * @param submissionString
     */
    public static void createSubmissionFile(String fileName, String submissionString){
        //Todo
    }
}
