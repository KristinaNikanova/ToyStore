package ru.gb.learn.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class LogWriter {

    /**
     * @param path path to file
     * @param log  data to be written
     * @throws IOException          if an I/O error occurs writing to or creating the file,
     *                              or the text cannot be encoded using UTF-8
     * @throws InvalidPathException if the path string cannot be converted to a Path
     * @apiNote write specified data to file with specified path
     */
    public static void write(String path, String log) throws IOException, InvalidPathException {
        Files.writeString(Paths.get(path), log);
    }
}
