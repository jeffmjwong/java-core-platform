package com.pluralsight.javacoreplatform;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Streams {
    public static void main(String[] args) {
//        doTryCatchFinally();
//        doTryWithResources();
//        doTryWithResourcesMulti();
//        doCloseThing();

        String[] data = {
                "Line 1",
                "Line 2 2",
                "Line 3 3 3",
                "Line 4 4 4 4",
                "Line 5 5 5 5 "
        };

        try (FileSystem zipFs = openZip(Paths.get("myData.zip"))) {
            copyToZip(zipFs);
            writeToFileInZip1(zipFs, data);
            writeToFileInZip2(zipFs, data);
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    private static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException {
        final Map<String, String> providerProps = new HashMap<>();
        providerProps.put("create", "true");

        URI zipUri = new URI("jar:file", zipPath.toUri().getPath(), null);

        return FileSystems.newFileSystem(zipUri, providerProps);
    }

    private static void copyToZip(FileSystem zipFs) throws IOException, URISyntaxException {
        Path sourceFile = Paths.get(Streams.class.getResource("/file1.txt").toURI());
        Path destFile = zipFs.getPath("/file1Copied.txt");

        Files.copy(sourceFile, destFile, StandardCopyOption.REPLACE_EXISTING);
    }

    private static void writeToFileInZip1(FileSystem zipFs, String[] data) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(zipFs.getPath("/newFile1.txt"))) {
            for (String d : data) {
                bw.write(d);
                bw.newLine();
            }
        }
    }

    private static void writeToFileInZip2(FileSystem zipFs, String[] data) throws IOException {
        Files.write(zipFs.getPath("/newFile2.txt"), Arrays.asList(data), Charset.defaultCharset(), StandardOpenOption.CREATE);
    }

    private static void writeData(String[] data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("text1.txt"))) {
            for (String d : data) {
                bw.write(d);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void doTryCatchFinally() {
        char[] buff = new char[8];
        int length;
        Reader reader = null;

        try {
            reader = Helper.openReader("/file1.txt");
            while ((length = reader.read(buff)) != -1) {
                System.out.println("\nlength: " + length);
                for (int i = 0; i < length; i++) {
                    System.out.println(buff[i]);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        } catch (URISyntaxException e) {
            System.out.println("URI Syntax Exception!! - " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e2) {
                System.out.println(e2.getClass().getSimpleName() + " - " + e2.getMessage());
            }
        }
    }

    private static void doTryWithResources() {
        char[] buff = new char[8];
        int length;

        try (Reader reader = Helper.openReader("/file1.txt")) {
            while ((length = reader.read(buff)) != -1) {
                System.out.println("\nlength: " + length);
                for (int i = 0; i < length; i++) {
                    System.out.println(buff[i]);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        } catch (URISyntaxException e) {
            System.out.println("URI Syntax Exception!! - " + e.getMessage());
        }
    }

    private static void doTryWithResourcesMulti() {
        char[] buff = new char[8];
        int length;

        try (Reader reader = Helper.openReader("/file1.txt"); Writer writer = Helper.openWriter("file2.txt")) {
            while ((length = reader.read(buff)) != -1) {
                System.out.println("\nlength: " + length);
                writer.write(buff);
                for (int i = 0; i < length; i++) {
                    System.out.println(buff[i]);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        } catch (URISyntaxException e) {
            System.out.println("URI Syntax Exception!! - " + e.getMessage());
        }
    }

    private static void doCloseThing() {
        try (MyAutoCloseable ac = new MyAutoCloseable()) {
            ac.saySomething();
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());

            for (Throwable t : e.getSuppressed()) {
                System.out.println("Surpressed: " + t.getMessage());
            }
        }
    }
}
