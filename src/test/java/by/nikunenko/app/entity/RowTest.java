package by.nikunenko.app.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    Row row1 = new Row(new Cell[]{new Cell("1"), new Cell("a"), new Cell("1")});
    Row row2 = new Row(new Cell[]{new Cell("3"), new Cell("a"), new Cell("")});
    Row row3 = new Row(new Cell[]{new Cell("179"), new Cell("a"), new Cell("1")});
    Row row4 = new Row(new Cell[]{new Cell("179"), new Cell("a"), new Cell("2")});
    Row row5 = new Row(new Cell[]{new Cell("179"), new Cell("b"), new Cell("")});
    Row row6 = new Row(new Cell[]{new Cell("179"), new Cell("b"), new Cell("")});

    @Test
    void compareTo() {
        assertAll(
                () -> assertEquals(0, row1.compareTo(row1), "1 == 1"),
                () -> assertTrue(0 > row1.compareTo(row2), "1 < 2"),
                () -> assertTrue(0 > row1.compareTo(row2), "1 < 3"),
                () -> assertTrue(0 > row1.compareTo(row2), "1 < 4"),
                () -> assertTrue(0 > row1.compareTo(row2), "1 < 5"),

                () -> assertEquals(0, row2.compareTo(row2), "2 == 2"),
                () -> assertTrue(0 > row2.compareTo(row3), "2 < 3"),
                () -> assertTrue(0 > row2.compareTo(row4), "2 < 4"),
                () -> assertTrue(0 > row2.compareTo(row5), "2 < 5"),

                () -> assertEquals(0, row3.compareTo(row3), "3 == 3"),
                () -> assertTrue(0 > row3.compareTo(row4), "3 < 4"),
                () -> assertTrue(0 > row3.compareTo(row5), "3 < 5"),

                () -> assertEquals(0, row4.compareTo(row4), "4 == 4"),
                () -> assertTrue(0 > row4.compareTo(row5), "4 < 5>"),

                () -> assertEquals(0, row5.compareTo(row5), "5 == 5>")
        );
    }

    @Test
    void testEquals() {
        assertEquals(row5, row6);
    }
}