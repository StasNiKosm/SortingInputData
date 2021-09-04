package by.nikunenko.app.writer.impl;

import by.nikunenko.app.enums.SeparatorsEnum;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;

public class Writer extends AbstractWriter<String[]> {

    private Properties properties;

    public Writer() {
    }

    public Writer(String fileName, Properties properties) {
        super(fileName);
        this.properties = properties;
    }

    @Override
    public void write(String[] lines) {
        try(FileWriter fileWriter = new FileWriter(properties.getProperty(this.fileName))){
            fileWriter.write(Arrays.stream(lines)
                    .reduce((x, y) -> x + SeparatorsEnum.ROW_SEPARATOR.getSeparator() + y)
                    .orElseThrow(IllegalArgumentException::new));
        } catch (FileNotFoundException e) {
            System.out.println("The file \"" + this.fileName + "\" isn't exist");
            e.printStackTrace();
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("The lines %? were not written to the file '" + this.fileName + "'");
            e.printStackTrace();
        }
    }

}
