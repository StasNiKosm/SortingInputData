package by.nikunenko.app.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    Cell cell1 = new Cell("123.4");
    Cell cell2 = new Cell("123.4p");
    Cell cell3 = new Cell("abc");
    Cell cell4 = new Cell("123");
    Cell cell5 = new Cell("");
    Cell cell6 = new Cell(new String("a"));
    Cell cell7 = new Cell(new String("a"));

    @Test
    void compareTo() {

//        "123", "123.4", "", "123.4p", "a", "abc"


        assertAll(
                () -> assertEquals(0, cell6.compareTo(cell7), "a == a"),

                () -> assertTrue(0 > cell1.compareTo(cell5), "123.4 < \"\""),
                () -> assertTrue(0 > cell1.compareTo(cell2), "123.4 < 123.4p"),
                () -> assertTrue(0 > cell1.compareTo(cell3), "123.4 < abc"),
                () -> assertTrue(0 < cell1.compareTo(cell4), "123.4 > 123"),
                () -> assertTrue(0 > cell1.compareTo(cell6), "123.4 < a"),
                () -> assertEquals(0, cell1.compareTo(cell1), "123.4 == 123.4"),

                () -> assertTrue(0 < cell2.compareTo(cell1)),
                () -> assertEquals(0, cell2.compareTo(cell2)),
                () -> assertTrue(0 > cell2.compareTo(cell3)),
                () -> assertTrue(0 < cell2.compareTo(cell4)),
                () -> assertTrue(0 < cell2.compareTo(cell5)),
                () -> assertTrue(0 > cell2.compareTo(cell6)),

                () -> assertTrue(0 < cell3.compareTo(cell1)),
                () -> assertTrue(0 < cell3.compareTo(cell2)),
                () -> assertEquals(0, cell3.compareTo(cell3)),
                () -> assertTrue(0 < cell3.compareTo(cell4)),
                () -> assertTrue(0 < cell3.compareTo(cell5)),
                () -> assertTrue(0 < cell3.compareTo(cell6)),

                () -> assertTrue(0 > cell4.compareTo(cell1)),
                () -> assertTrue(0 > cell4.compareTo(cell2)),
                () -> assertTrue(0 > cell4.compareTo(cell3)),
                () -> assertEquals(0, cell4.compareTo(cell4)),
                () -> assertTrue(0 > cell4.compareTo(cell5)),
                () -> assertTrue(0 > cell4.compareTo(cell6)),

                () -> assertTrue(0 < cell5.compareTo(cell1)),
                () -> assertTrue(0 > cell5.compareTo(cell2)),
                () -> assertTrue(0 > cell5.compareTo(cell3)),
                () -> assertTrue(0 < cell5.compareTo(cell4)),
                () -> assertEquals(0, cell5.compareTo(cell5)),
                () -> assertTrue(0 > cell5.compareTo(cell6)),

                () -> assertTrue(0 < cell6.compareTo(cell1)),
                () -> assertTrue(0 < cell6.compareTo(cell2)),
                () -> assertTrue(0 > cell6.compareTo(cell3)),
                () -> assertTrue(0 < cell6.compareTo(cell4)),
                () -> assertTrue(0 < cell6.compareTo(cell5)),
                () -> assertEquals(0, cell6.compareTo(cell6))
        );

    }

    @Test
    void testEquals() {
        assertEquals(cell6, cell7);
    }
}