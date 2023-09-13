package com.training.project.loadProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProps {
	
	static String projectPath = System.getProperty("user.dir");
	
	public static String getProperty(String key) {
        Properties prop = new Properties();
        FileInputStream input;

        try {
            input = new FileInputStream(projectPath + "/src/test/resources/resources.properties");
            prop.load(input);
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }


}
