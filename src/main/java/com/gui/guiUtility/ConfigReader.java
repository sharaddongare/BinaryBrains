package com.gui.guiUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;
    private static final Logger LOG = LogManager.getLogger(ConfigReader.class);

    /**
     * This method is used to load the properties from config.properties file
     *
     * @return it returns Properties prop object
     */
    public static Properties init_prop() {
        prop = new Properties();
        String projectFolder = System.getProperty("user.dir") + "/src/test/resources/config/";
        File f1 = new File(projectFolder);
        File[] listOfFiles = f1.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                String prop1 = listOfFiles[i].getAbsolutePath();
                if (prop1.contains("properties")) {
                    File folder = new File(prop1);
                    FileInputStream fileInputStream = null;
                    try {
                        fileInputStream = new FileInputStream(folder);
                        prop.load(fileInputStream);
                    } catch (FileNotFoundException e) {
                        LOG.info("Exception while reading the file {}", e.getStackTrace());
                    } catch (IOException e) {
                        LOG.info("Exception while loading the file {}", e.getStackTrace());
                    }
                }

            }
        }
        return prop;

    }
}
