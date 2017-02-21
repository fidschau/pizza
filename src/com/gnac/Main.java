package com.gnac;

import com.gnac.models.Cell;
import com.gnac.models.Pizza;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Booinux un");
    }


    /**
     * Creates pizza object
     * @param pizzaDescription
     * @param rawArray
     * @return
     */
    public Pizza createPizzaFromArray(int [] pizzaDescription,char [][] rawArray){
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
}
