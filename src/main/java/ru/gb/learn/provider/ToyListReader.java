package ru.gb.learn.provider;

import ru.gb.learn.file.FileReader;
import ru.gb.learn.toy.Toy;

import java.util.List;

/**
 * The implementation of {@link DataProvider}.
 * <p>
 * Reads data of toys from file
 */
public class ToyListReader implements DataProvider {

    /**
     * @return list of toys
     * @apiNote returns list of toys created with using data from file
     */
    @Override
    public List<Toy> getToyList() {
        return FileReader.read("test.json");
    }
}
