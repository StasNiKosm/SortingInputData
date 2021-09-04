package by.nikunenko.app.enums;

public enum SeparatorsEnum {
    COLUMN_SEPARATOR('\t'),
    ROW_SEPARATOR('\n');

    private char separator;

    SeparatorsEnum(char separator) {
        this.separator = separator;
    }

    public char getSeparator() {
        return separator;
    }

    public void setSeparator(char separator) {
        this.separator = separator;
    }
}
