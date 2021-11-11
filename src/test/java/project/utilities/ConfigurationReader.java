package project.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();//encapsulation

    static {
        //2. Load the file into file input string
        try {
            FileInputStream file = new FileInputStream("configuration.properties");


            //3. load properties object with the file (configuration.properties)
            properties.load(file);

            //close the file
            file.close();

        } catch (IOException e) {

            System.out.println("File not found in Configuration properties.");
        }
    }

    //use the above created logic to create the re -usable static method
    public static String getProperty(String kewWord){
        return properties.getProperty(kewWord);
    }

}
