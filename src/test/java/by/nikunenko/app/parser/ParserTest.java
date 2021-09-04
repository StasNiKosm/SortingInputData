package by.nikunenko.app.parser;

import by.nikunenko.app.entity.Cell;
import by.nikunenko.app.entity.Row;
import by.nikunenko.app.entity.Table;
import javafx.scene.control.Tab;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void parseToTable() {
        Row row1 = new Row(new Cell[]{new Cell(""), new Cell("12"), new Cell("1")});
        Row row2 = new Row(new Cell[]{new Cell("er"), new Cell(""), new Cell("")});
        Row row3 = new Row(new Cell[]{new Cell("17"), new Cell(""), new Cell("ven")});
        Table expectedTable = new Table(new Row[]{row1, row2, row3});

        String[] actualLines = new String[]{"\t12\t1", "er\t\t", "17\t\tven"};

        Table actualTable = Parser.parseToTable(actualLines);

        assertEquals(expectedTable, actualTable);

    }

    @Test
    void parseToLines() {
        String[] expectedLines = new String[]{"\t12\t1", "\t\t", "190\t\ten", "\t0.8\t"};

        Row row1 = new Row(new Cell[]{new Cell(""), new Cell("12"), new Cell("1")});
        Row row2 = new Row(new Cell[]{new Cell(""), new Cell(""), new Cell("")});
        Row row3 = new Row(new Cell[]{new Cell("190"), new Cell(""), new Cell("en")});
        Row row4 = new Row(new Cell[]{new Cell(""), new Cell("0.8"), new Cell("")});
        Table actualTable = new Table(new Row[]{row1, row2, row3, row4});

        String[] actualLines = Parser.parseToLines(actualTable);

        assertArrayEquals(expectedLines, actualLines);
    }
}