package com.gnac.models;

/**
 * Created by fidelity on 2017/02/09.
 */

public class Cell {
    private int row,column;
    private boolean isInSlice, isTomato;

    public Cell(boolean isTomato, int row, int column) {
        this.isTomato = isTomato;
        this.row = row;
        this.column = column;
        this.isInSlice=false;
    }

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isInSlice() {
        return isInSlice;
    }

    public boolean isTomato() {
        return isTomato;
    }
    public boolean isMushroom(){
        return  !isTomato;
    }

    public void setInSlice(boolean inSlice) {
        isInSlice = inSlice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (row != cell.row) return false;
        return column == cell.column;

    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        return result;
    }



}
