package ru.gb.learn.file;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.gb.learn.toy.Toy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    /**
     * @param fileName the name of file to be read
     * @return list of toys
     * @apiNote reads the list of toys from json file
     */
    public static List<Toy> read(String fileName) {
        List<Toy> toyList = new ArrayList<>(0);
        try {
            toyList = new ObjectMapper().readValue(new File(fileName), new TypeReference<>() {
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return toyList;
    }
}
