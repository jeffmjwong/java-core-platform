package com.pluralsight.javacoreplatform;

import java.io.IOException;

public class MyAutoCloseable implements AutoCloseable {
    public void saySomething() throws IOException {
        System.out.println("Say something I'm giving up on you");
    }

    @Override
    public void close() throws IOException {
        System.out.println("close");
    }
}
