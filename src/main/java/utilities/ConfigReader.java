package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        loadProperties();
    }

    private static void loadProperties() {
        String env = System.getProperty("env", "dev");

        String path = System.getProperty("user.dir")
                + "/src/main/resources/config/config-" + env + ".properties";

        properties = new Properties();

        try (FileInputStream fis = new FileInputStream(path)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file for environment: " + env);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}