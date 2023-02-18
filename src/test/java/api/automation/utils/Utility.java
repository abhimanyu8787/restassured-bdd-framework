package api.automation.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utility {
    
    public static String getGlobalProperties(String key) throws IOException {
        FileReader reader = new FileReader("GlobalSettings.properties");
        Properties globalProperties = new Properties();
        globalProperties.load(reader);
        return globalProperties.getProperty(key);
    }

}
