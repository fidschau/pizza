package com.gnac.models;

import java.util.ArrayList;

/**
 * Created by fidelity on 2017/02/09.
 */

public class Pizza {

    private int rows, columns, minIngredient, maxSliceSize;

   private ArrayList<Cell> cells= new ArrayList<>();
   private ArrayList<Slice> slices= new ArrayList<>();


    public Pizza(int [] pizzaDescription) {
        rows=pizzaDescription[0];
        columns=pizzaDescription[1];
        minIngredient=pizzaDescription[2];
        maxSliceSize =pizzaDescription[3];
    }



    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getMinIngredient() {
        return minIngredient;
    }

    public int getMaxSliceSize() {
        return maxSliceSize;
    }

    public Cell getCell(int row, int column){

        return  cells.get(cells.indexOf(new Cell(row,column)));
    }

    public  void addCell(Cell cell){
        if (cells.contains(cell)){
            cells.remove(cell);
        }

        cells.add(cell);
    }

    public ArrayList<Slice> getValidSlices(){
        ArrayList<Slice> validSlices= new ArrayList<>();
        for (Slice slice:slices){
            if (slice.isValidSlice()){
                validSlices.add(slice);
            }
        }
        return validSlices;
    }

    public boolean cutSlices(){

        //// TODO: 2017/02/09 Add slicing rational. Basically, depending on what type of rectangle we are slicing, we get the coordinates of each cell and add it to the slice


        return false;
    }

    /**
     * Used to get the submission string
     */
    public String getSubmissionString(){
        ArrayList<Slice> validSlices=getValidSlices();
        StringBuilder submissionStringBuilder=new StringBuilder(validSlices.size()+"\n");
        for (Slice slice:validSlices){
            submissionStringBuilder.append(slice.delimitingCoordinates());
        }
        return submissionStringBuilder.toString();
    }


}
