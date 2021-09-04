package by.nikunenko.app.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    Table expectedTable;

    @BeforeEach
    void setUp() {
        Row row1 = new Row(new Cell[]{new Cell("1"), new Cell("a"), new Cell("1")});
        Row row2 = new Row(new Cell[]{new Cell("3"), new Cell("a"), new Cell("")});
        Row row3 = new Row(new Cell[]{new Cell("179"), new Cell("a"), new Cell("1")});
        Row row4 = new Row(new Cell[]{new Cell("179"), new Cell("a"), new Cell("2")});
        Row row5 = new Row(new Cell[]{new Cell("179"), new Cell("b"), new Cell("")});
        Row row6 = new Row(new Cell[]{new Cell(""), new Cell("fg"), new Cell("ven")});
        Row row7 = new Row(new Cell[]{new Cell("a"), new Cell("fg"), new Cell("2")});
        Row row8 = new Row(new Cell[]{new Cell("ab"), new Cell("fg"), new Cell("1")});
        Row row9 = new Row(new Cell[]{new Cell("ab"), new Cell("z"), new Cell("v")});
        Row row10 = new Row(new Cell[]{new Cell("abc"), new Cell(""), new Cell("ve")});
        this.expectedTable = new Table(new Row[]{row1, row2, row3, row4, row5, row6, row7, row8, row9, row10});
    }

    @Test
    void sort() {
        Row row10 = new Row(new Cell[]{new Cell("1"), new Cell("a"), new Cell("1")});
        Row row5 = new Row(new Cell[]{new Cell("3"), new Cell("a"), new Cell("")});
        Row row4 = new Row(new Cell[]{new Cell("179"), new Cell("a"), new Cell("1")});
        Row row1 = new Row(new Cell[]{new Cell("179"), new Cell("a"), new Cell("2")});
        Row row6 = new Row(new Cell[]{new Cell("179"), new Cell("b"), new Cell("")});
        Row row8 = new Row(new Cell[]{new Cell(""), new Cell("fg"), new Cell("ven")});
        Row row2 = new Row(new Cell[]{new Cell("a"), new Cell("fg"), new Cell("2")});
        Row row3 = new Row(new Cell[]{new Cell("ab"), new Cell("fg"), new Cell("1")});
        Row row9 = new Row(new Cell[]{new Cell("ab"), new Cell("z"), new Cell("v")});
        Row row7 = new Row(new Cell[]{new Cell("abc"), new Cell(""), new Cell("ve")});
        Table actualTable = new Table(new Row[]{row1, row2, row3, row4, row5, row6, row7, row8, row9, row10});
        actualTable.sort();

        assertEquals(this.expectedTable, actualTable);
    }

    @Test
    void testEquals() {
        Row row1 = new Row(new Cell[]{new Cell("1"), new Cell("a"), new Cell("1")});
        Row row2 = new Row(new Cell[]{new Cell("3"), new Cell("a"), new Cell("")});
        Row row3 = new Row(new Cell[]{new Cell("179"), new Cell("a"), new Cell("1")});
        Row row4 = new Row(new Cell[]{new Cell("179"), new Cell("a"), new Cell("2")});
        Row row5 = new Row(new Cell[]{new Cell("179"), new Cell("b"), new Cell("")});
        Row row6 = new Row(new Cell[]{new Cell(""), new Cell("fg"), new Cell("ven")});
        Row row7 = new Row(new Cell[]{new Cell("a"), new Cell("fg"), new Cell("2")});
        Row row8 = new Row(new Cell[]{new Cell("ab"), new Cell("fg"), new Cell("1")});
        Row row9 = new Row(new Cell[]{new Cell("ab"), new Cell("z"), new Cell("v")});
        Row row10 = new Row(new Cell[]{new Cell("abc"), new Cell(""), new Cell("ve")});
        Table actualTable = new Table(new Row[]{row1, row2, row3, row4, row5, row6, row7, row8, row9, row10});

        assertEquals(expectedTable, actualTable);
    }
}