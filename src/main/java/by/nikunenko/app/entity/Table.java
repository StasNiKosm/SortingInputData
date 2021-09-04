package by.nikunenko.app.entity;

import by.nikunenko.app.enums.SeparatorsEnum;

import java.util.Arrays;

public class Table {

    Row[] rows;

    public Table() {
    }

    public Table(Row[] rows) {
        this.rows = rows;
    }

    public void sort(){
        Arrays.sort(this.rows);
    }

    public Row[] getRows() {
        return rows;
    }

    public void setRows(Row[] rows) {
        this.rows = rows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return Arrays.equals(rows, table.rows);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rows);
    }

    @Override
    public String toString() {
        return Arrays.stream(this.rows).map(Row::toString)
                .reduce((x, y) -> x + SeparatorsEnum.ROW_SEPARATOR.getSeparator() + y)
                .get();
    }

}
