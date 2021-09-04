package by.nikunenko.app.parser;

import by.nikunenko.app.entity.Cell;
import by.nikunenko.app.entity.Row;
import by.nikunenko.app.entity.Table;
import by.nikunenko.app.enums.SeparatorsEnum;

import java.util.Arrays;

public class Parser {

    public static Table parseToTable(String[] lines){
        int columnCount = (int) lines[0].chars().filter(x -> x == SeparatorsEnum.COLUMN_SEPARATOR.getSeparator()).count() + 1;
        Row[] table = Arrays.stream(lines)
                .map(x-> Arrays
                        .stream(x.split(""+SeparatorsEnum.COLUMN_SEPARATOR.getSeparator(), columnCount))
                        .map(Cell::new)
                        .toArray(Cell[]::new))
                .map(Row::new)
                .toArray(Row[]::new);
        return new Table(table);
    }

    public static String[] parseToLines(Table table){
        return Arrays.stream(table.getRows())
                .map(x-> Arrays
                        .stream(x.getCells())
                        .map(Cell::getValue)
                        .reduce((a, b) -> a + SeparatorsEnum.COLUMN_SEPARATOR.getSeparator() + b)
                        .get())
                .toArray(String[]::new);
    }

}
