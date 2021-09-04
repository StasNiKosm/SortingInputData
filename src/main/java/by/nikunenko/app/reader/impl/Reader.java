package by.nikunenko.app.reader.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Reader extends AbstractReader<String[]>{

    private Properties properties;

    public Reader() {
    }

    public Reader(String fileName, Properties properties) {
        super(fileName);
        this.properties = properties;
    }

    @Override
    public String[] read() {
        try(FileReader fileReader = new FileReader(properties.getProperty(this.fileName));
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            return bufferedReader.lines().toArray(String[]::new);
        } catch (FileNotFoundException e) {
            System.out.println("The file '" + this.fileName + "' isn't exist");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("The data was not read from the file '" + this.fileName + "'");
            e.printStackTrace();
        }
        return new String[0];
    }

}
