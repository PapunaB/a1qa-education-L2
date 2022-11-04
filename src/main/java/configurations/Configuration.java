package configurations;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class Configuration {

    private static final ISettingsFile jsonSettingsFile = new JsonSettingsFile("testData.json");

    public static String getUrl(){
        return jsonSettingsFile.getValue("/url").toString();
    }

    public static String getEmail(){
        return jsonSettingsFile.getValue("/email_address").toString();
    }

    public static String getDomain(){
        return jsonSettingsFile.getValue("/domain").toString();
    }

    public static String getDomainEnd(){
        return jsonSettingsFile.getValue("/domain_end").toString();
    }

    public static String getPhoto(){
        return jsonSettingsFile.getValue("/photo").toString();
    }

    public static String getTimerFormat(){
        return jsonSettingsFile.getValue("/timer_format").toString();
    }
}

