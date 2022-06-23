package Property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
    public FileInputStream fileInputStream;
    public Properties properties;

    public PropertyUtility(String NameFile) throws IOException {
        properties=new Properties();
        fileInputStream=new FileInputStream("src/test/resources/InputData/"+NameFile+".properties");
        properties.load(fileInputStream);
    }

    public String getvalue(String Key){
        return  properties.getProperty(Key);
    }
}
