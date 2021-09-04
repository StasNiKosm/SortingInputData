package by.nikunenko.app.creator.impl;

import by.nikunenko.app.creator.Creatable;

public abstract class AbstractCreator<T> implements Creatable<T> {

    protected int linesCount;
    protected int columnCount;

    public AbstractCreator(int columnCount, int linesCount) {
        this.linesCount = linesCount;
        this.columnCount = columnCount;
    }

    public int getLinesCount() {
        return linesCount;
    }

    public void setLinesCount(int linesCount) {
        this.linesCount = linesCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }
}
