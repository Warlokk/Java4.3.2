package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FileOpenManager {
    private Map<String, String> fileAssociations = new HashMap<>();

    public void registerApp(String extension, String appName) {
        fileAssociations.put(extension.toLowerCase(), appName);
    }

    public String getAppName(String extension) {
        return fileAssociations.get(extension.toLowerCase());
    }

    public void removeAssociation(String extension) {
        fileAssociations.remove(extension);
    }

    public List<String> getAllRegisteredExtension() {
        List<String> result = new ArrayList<>(fileAssociations.keySet());
        Collections.sort(result);
        return result;
    }

    public List<String> getAllRegisteredApps() {
        Set<String> tmp = new HashSet<>(fileAssociations.values());
        List<String> result = new ArrayList<>(tmp);
        Collections.sort(result);
        return result;
    }

}
