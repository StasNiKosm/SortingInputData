package by.nikunenko.app.creator.impl;

import by.nikunenko.app.enums.SeparatorsEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomCreatorTest {

    @Test
    void create() {
        int expectedCountRow = 3;
        int expectedCountColumn = 3;

        RandomCreator randomCreator = new RandomCreator(3, expectedCountRow);
        String[] lines = randomCreator.create();

        int actualCountRow = lines.length;
        int actualCountColumn1 = lines[0].split(""+SeparatorsEnum.COLUMN_SEPARATOR.getSeparator(), expectedCountColumn + 1).length;
        int actualCountColumn2 = lines[1].split(""+SeparatorsEnum.COLUMN_SEPARATOR.getSeparator(), expectedCountColumn + 1).length;
        int actualCountColumn3 = lines[2].split(""+SeparatorsEnum.COLUMN_SEPARATOR.getSeparator(), expectedCountColumn + 1).length;

        assertAll(
                () -> assertEquals(expectedCountRow, actualCountRow),
                () -> assertEquals(expectedCountColumn, actualCountColumn1),
                () -> assertEquals(expectedCountColumn, actualCountColumn2),
                () -> assertEquals(expectedCountColumn, actualCountColumn3)
        );

    }

}