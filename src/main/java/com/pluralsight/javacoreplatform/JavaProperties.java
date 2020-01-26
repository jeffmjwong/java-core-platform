package com.pluralsight.javacoreplatform;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class JavaProperties {
    public static void main(String[] args) {
        try {
            Properties defaultProps = new Properties();

            try (InputStream inputStream = JavaProperties.class.getResourceAsStream("/MyDefaultValues.xml")) {
                defaultProps.loadFromXML(inputStream);
            }

            Properties userProps = new Properties(defaultProps);
            loadUserProps(userProps);

            String welcomeMessage = userProps.getProperty("welcomeMessage");
            String farewellMessage = userProps.getProperty("farewellMessage");

            System.out.println(welcomeMessage);
            System.out.println(farewellMessage);
        } catch (IOException e) {
            System.out.println("Exception <" + e.getClass().getSimpleName() + ">" + e.getMessage());
        }
    }

    private static Properties loadUserProps(Properties userProps) throws IOException {
        Path userFile = Paths.get("userValues.xml");

        if (Files.exists(userFile)) {
            try (InputStream inputStream = Files.newInputStream(userFile)) {
                userProps.loadFromXML(inputStream);
            }
        }

        return userProps;
    }
}
