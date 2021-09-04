package by.nikunenko.app.context;

import by.nikunenko.app.creator.Creatable;
import by.nikunenko.app.creator.impl.RandomCreator;
import by.nikunenko.app.entity.Table;
import by.nikunenko.app.parser.Parser;
import by.nikunenko.app.reader.Readable;
import by.nikunenko.app.reader.impl.Reader;
import by.nikunenko.app.writer.Writable;
import by.nikunenko.app.writer.impl.Writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Application {

    private static final String PROPERTIES_FILE_PATH = "src/main/resources/filesPath.properties";
    private static final Properties properties = new Properties();
    static {
        try (FileReader fileReader = new FileReader(PROPERTIES_FILE_PATH)) {
            properties.load(fileReader);
        } catch (FileNotFoundException e) {
            System.out.println("Properties file isn't exist");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Properties not loaded");
            e.printStackTrace();
        }
    }

    public static void start(){
        Writable<String[]> randomWriter = new Writer("input", properties);
        Creatable creator = new RandomCreator(5, 600, 0, 15, 'a', 'g', 3);
        randomWriter.write(creator.create());
        System.out.println("[Writer] Random data was written to the file 'input.txt'");
        Readable<String[]> reader = new Reader("input", properties);
        String[] lines = reader.read();
        System.out.println("[Reader] The data was read from the file 'input.txt'");
        Table table = Parser.parseToTable(lines);
        table.sort();
        System.out.println("[Table] The data was sorted");
        Writable<String[]> writer = new Writer("out", properties);
        writer.write(Parser.parseToLines(table));
        System.out.println("[Writer] Sorting data was written to the file 'out.txt'");
    }

}
