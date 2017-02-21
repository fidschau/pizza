package com.gnac.models;

import java.util.ArrayList;

/**
 * Created by fidelity on 2017/02/09.
 */

public class Pizza {

   private ArrayList<Cell> cells= new ArrayList<>();
    private ArrayList<Slice> slices= new ArrayList<>();

    public Pizza(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    public Cell getCell(int row, int column){

        return  cells.get(cells.indexOf(new Cell(row,column)));
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

    public boolean cutSlice(){

        //// TODO: 2017/02/09 Add slicing rational. Basically, depending on what type of rectangle we are slicing, we get the coordinates of each cell and add it to the slice



        return false;
    }

    public String getSubmissionString(){
        ArrayList<Slice> validSlices=getValidSlices();
        StringBuilder submissionStringBuilder=new StringBuilder(validSlices.size());
        for (Slice slice:validSlices){
            submissionStringBuilder.append(slice.delimitingCoordinates());
        }
        return submissionStringBuilder.toString();
    }


}
