package com.pluralsight.javacoreplatform;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Helper {
    public static BufferedReader openReader(String fileName) throws IOException, URISyntaxException {
//        return Files.newBufferedReader(Paths.get(fileName));
        return Files.newBufferedReader(Paths.get(Main.class.getResource(fileName).toURI()));
    }

    public static BufferedWriter openWriter(String fileName) throws IOException {
        return Files.newBufferedWriter(Paths.get(fileName));
//        return Files.newBufferedWriter(Paths.get(Main.class.getResource(fileName).toURI()));
    }
}
