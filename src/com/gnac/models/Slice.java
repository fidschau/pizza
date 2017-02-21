package com.gnac.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by fidelity on 2017/02/09.
 */

public class Slice {
    private ArrayList<Cell> cells = new ArrayList<>();
    private int maxCells,minTomatoes,minMushrooms;

    private boolean isValidSlice=false;


    public Slice(int maxCells, int minTomatoes, int minMushrooms) {
        this.maxCells = maxCells;
        this.minTomatoes = minTomatoes;
        this.minMushrooms = minMushrooms;
    }

    public boolean addCellToSlice(Cell cell){
        if (!cell.isInSlice()){
            cell.setInSlice(true);
            cells.add(cell);

            return true;
        }
        else return false;
    }

    public boolean isValidSlice() {
        int tomatoes=0;
        int mushrooms=0;
        for (Cell cell:cells){
            if (cell.isMushroom()){
                mushrooms++;
            } else {
                tomatoes++;
            }
        }

        return tomatoes>=minTomatoes&&mushrooms>=minMushrooms&&cells.size()<=maxCells;
    }
    public int numberOfSlicedCells(){
        return cells.size();
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Slice slice = (Slice) o;

        if (isValidSlice != slice.isValidSlice) return false;
        return cells.equals(slice.cells);

    }

    @Override
    public int hashCode() {
        int result = cells.hashCode();
        result = 31 * result + (isValidSlice ? 1 : 0);
        return result;
    }



    public String delimitingCoordinates(){
        int firstRow, firstColumn, lastRow, lastColumn;

        Collections.sort(cells, new Comparator<Cell>() {
            @Override
            public int compare(Cell cell, Cell t1) {
                return cell.getRow()-t1.getRow();
            }
        });
        firstRow=cells.get(0).getRow();
        lastRow=cells.get(cells.size()-1).getRow();

        Collections.sort(cells, new Comparator<Cell>() {
            @Override
            public int compare(Cell cell, Cell t1) {
                return cell.getColumn()-t1.getColumn();
            }
        });
        firstColumn=cells.get(0).getColumn();
        lastColumn=cells.get(cells.size()-1).getColumn();


        return ""+firstRow+" "+firstColumn+" "+lastRow+" "+lastColumn+"\n";
    }



}
