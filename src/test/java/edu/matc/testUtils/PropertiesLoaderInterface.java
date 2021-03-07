package edu.matc.testUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * This interface contains a default method that can be used anywhere a Properties
 * object is needed to be loaded.
 * @author tzschernitz
 *
 */
public interface PropertiesLoaderInterface {

    /**
     * This default method will load a properties file into a Properties instance
     * and return it.
     * @param propertiesFilePath a path to a file on the java classpath list
     * @return a populated Properties instance or an empty Properties instance if
     * the file path was not found.
     */
    default Properties loadProperties(String propertiesFilePath){
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            System.out.println("Can't load the properties file.");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Something went wrong.");
            exception.printStackTrace();
        }
        return properties;
    }
}