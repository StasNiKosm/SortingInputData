package by.nikunenko.app.entity;

import by.nikunenko.app.enums.CellsEnum;

public class Cell implements Comparable<Cell>{

    private String value;

    public Cell() {
    }

    public Cell(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int compareTo(Cell o) {
        CellsEnum type1 = CellsEnum.getType(this.getValue());
        CellsEnum type2 = CellsEnum.getType(o.getValue());
        int comp = type1.compare(type2);
        if (comp == 0){
            return type1.getComparator().compare(this.getValue(), o.getValue());
        }
        return comp;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
