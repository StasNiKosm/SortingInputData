package by.nikunenko.app.writer.impl;

import by.nikunenko.app.writer.Writable;

public abstract class AbstractWriter<T> implements Writable<T> {

    protected String fileName;

    public AbstractWriter() {
    }

    public AbstractWriter(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
