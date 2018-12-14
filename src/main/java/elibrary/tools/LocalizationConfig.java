package elibrary.tools;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class LocalizationConfig {


    public static String setLanguage() {
        Properties properties = new Properties();
        try {
            Reader reader = new InputStreamReader(BaseTest.class.getClassLoader().getResourceAsStream("app.properties"), "UTF-8");
            properties.load(reader);
            if ("UA".equals(properties.getProperty("language"))) {
                return "UA";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "EN";
    }

    public static Properties getPropertiesForLocalization() {
        Properties properties = new Properties();
        try {
            Reader reader;
            if ("UA".equals(setLanguage())) {
                reader = new InputStreamReader(BaseTest.class.getClassLoader().getResourceAsStream("ua.messages.properties"), "UTF-8");
            } else {
                reader = new InputStreamReader(BaseTest.class.getClassLoader().getResourceAsStream("en.messages.properties"), "UTF-8");
            }
            properties.load(reader);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
