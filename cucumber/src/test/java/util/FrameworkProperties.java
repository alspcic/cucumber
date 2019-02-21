//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

public class FrameworkProperties {
    public FrameworkProperties() {
    }

    public static String get(String key) {
        String propertiesValue = properties(key);
        return propertiesValue;
    }

    private static String properties(String key) {
        Properties prop = new Properties();
        InputStream input = null;
        String propertiesValue = "";

        try {
            input = new FileInputStream("cucumber/src/test/resources/properties/config.properties");
            prop.load(input);
            Iterator var4 = prop.keySet().iterator();

            while(var4.hasNext()) {
                Object CMDkey = var4.next();
                String override = System.getProperty((String)CMDkey);
                if (override != null) {
                    prop.put(CMDkey, override);
                }
            }

            propertiesValue = prop.getProperty(key);
        } catch (IOException var15) {
            System.out.println("Issue has occurred in DA core -> FrameworkProperties");
            var15.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException var14) {
                    System.out.println("Issue has occurred in DA core -> FrameworkProperties");
                    var14.printStackTrace();
                }
            }

            return propertiesValue;
        }
    }
}
