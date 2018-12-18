package elibrary.tools;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class LocalizationConfig {

    public static Properties getPropertiesForLocalization() {
        Properties properties = new Properties();
        try {
            Reader reader;
            reader = new InputStreamReader(Base.class.getClassLoader().getResourceAsStream("ua.messages.properties"), "UTF-8");
            properties.load(reader);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
