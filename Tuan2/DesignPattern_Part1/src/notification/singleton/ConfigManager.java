package notification.singleton;

public class ConfigManager {

    private static ConfigManager instance;
    private String systemName;

    private ConfigManager() {
        systemName = "Notification System v1.0";
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public String getSystemName() {
        return systemName;
    }
}
