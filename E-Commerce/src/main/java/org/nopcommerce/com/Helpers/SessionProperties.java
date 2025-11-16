package org.nopcommerce.com.Helpers;

import java.io.IOException;
import java.util.Properties;

public class SessionProperties {
    private Properties properties;

    public SessionProperties(){
        properties = new Properties();
        try{
            properties.load(getClass().getResourceAsStream("/environment.properties"));
        }
        catch (IOException io){
            io.toString();
        }
    }

private static class SingletonHolder{
    public static final SessionProperties Instance = new SessionProperties();
    }

public static SessionProperties getInstance(){return SingletonHolder.Instance;}
public String getProperty(String name){return properties.getProperty(name);}
public String getProperty(String name, String defaultValue){
        return properties.getProperty(name,defaultValue);
}




}
