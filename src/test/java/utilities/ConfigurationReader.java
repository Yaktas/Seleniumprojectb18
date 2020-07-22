package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    //1- We created properties object.
    private static Properties properties = new Properties();

    static {
        //2- We got our path and store in String
        String path = "configuration.properties";

        //3- We need to open the file
        try {
            FileInputStream file = new FileInputStream(path);

            //4 - Load the file into properties object
            properties.load(file);

            //5 - close file
            file.close();
        } catch (Exception e) {
            System.out.println("Properties file not found");
        }

    }

    //Our own custom method to read and get values from configuration.properties file
    public static String getProperty(String keyWord){
        return properties.getProperty(keyWord);
    }



}
