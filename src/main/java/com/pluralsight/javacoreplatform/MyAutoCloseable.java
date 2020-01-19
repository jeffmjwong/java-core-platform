package com.pluralsight.javacoreplatform;

import java.io.IOException;

public class MyAutoCloseable implements AutoCloseable {
    public void saySomething() throws IOException {
        throw new IOException("Exception on say something");
//        System.out.println("Say something I'm giving up on you");
    }

    @Override
    public void close() throws IOException {
        throw new IOException("Exception on close");
//        System.out.println("close");
    }
}
