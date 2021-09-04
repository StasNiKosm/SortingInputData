package by.nikunenko.app.entity;

import java.util.Arrays;

public class Row implements Comparable<Row>{

    private Cell[] cells;

    public Row() {
    }

    public Row(Cell[] cells) {
        this.cells = cells;
    }

    public Cell[] getCells() {
        return cells;
    }

    public void setCells(Cell[] cells) {
        this.cells = cells;
    }

    @Override
    public int compareTo(Row o) {
        int comp = 0;
        for (int i = 0; i < this.cells.length; i++) {
            comp = this.getCells()[i].compareTo(o.getCells()[i]);
            if(comp != 0) return comp;
        }
        return comp;
    }

    @Override
    public String toString() {
        return Arrays.stream(cells).map(Cell::getValue).reduce((x, y) -> x + "\t" + y).get();
    }
}
