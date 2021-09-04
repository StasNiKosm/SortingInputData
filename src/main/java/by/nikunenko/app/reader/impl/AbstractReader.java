package by.nikunenko.app.reader.impl;

import by.nikunenko.app.reader.Readable;

public abstract class AbstractReader<T> implements Readable<T> {

    protected String fileName;

    public AbstractReader() {
    }

    public AbstractReader(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
