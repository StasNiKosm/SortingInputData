package by.nikunenko.app.entity;

import by.nikunenko.app.enums.SeparatorsEnum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Table {

    List<Row> rows;

    public Table() {
    }

    public Table(List<Row> rows) {
        this.rows = rows;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public void sort(){
        Collections.sort(this.rows);
    }

    @Override
    public String toString() {
        return this.rows.stream()
                .map(Row::toString)
                .reduce((x, y) -> x + SeparatorsEnum.ROW_SEPARATOR.getSeparator() + y)
                .get();
    }
}
