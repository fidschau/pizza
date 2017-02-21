package com.gnac;

import com.gnac.models.Cell;
import com.gnac.models.Pizza;

public class Main {

    public static void main(String[] args) {
	// write your code here
       // System.out.println("Booinux un");

        int [] pizzaDescription = getPizzaDescriptionFromFile("small.in");
        char [][] rawArray = getRawArrayFromFile("small.in");
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
    public static Pizza createPizzaFromArray(int [] pizzaDescription,char [][] rawArray){
        Pizza pizza;
        char tomato = 'T';
        if (pizzaDescription.length==4){
            pizza = new Pizza(pizzaDescription);

            for (int x=0; x<pizza.getRows();x++){
                for (int y=0; y<pizza.getColumns();y++){
                    char c= rawArray[x][y];
                    Cell cell = new Cell(c==tomato,x,y);
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
    public static char [][] getRawArrayFromFile(String fileName){
        //Todo
        char [][] rawArray = new char[14][45];
        return rawArray;
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
