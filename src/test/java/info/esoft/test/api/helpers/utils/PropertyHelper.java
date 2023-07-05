package info.esoft.test.api.helpers.utils;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertyHelper {
    public static final File SECTION_PROPERTIES_FILE = new File("src/test/resources/section.properties");

    public static FileBasedConfigurationBuilder<FileBasedConfiguration> getFileBasedConfigurationBuilder(File configFile) {
        Parameters params = new Parameters();
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.properties().setBasePath(configFile.getParent())
                                                       .setFileName(configFile.getName())
                                                       .setEncoding("UTF-8"));
        return builder;
    }

    public static Object getPropertyFromConfigurationFile(File configFile, String propKey) throws ConfigurationException {
        Configuration config = getFileBasedConfigurationBuilder(configFile).getConfiguration();
        return config.getProperty(propKey);
    }

    public static void updatePropertiesAtFile(File configFile, Properties properties) throws ConfigurationException {
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder = getFileBasedConfigurationBuilder(configFile);
        Configuration config = builder.getConfiguration();
        for (Map.Entry<Object, Object> property : properties.entrySet()) {
            config.setProperty(property.getKey().toString(), property.getValue().toString());
        }
        builder.save();
    }

    public static void incrementSectionNumberAtConfigFile() throws ConfigurationException {
        String sectionCadastral = (String) getPropertyFromConfigurationFile(SECTION_PROPERTIES_FILE,"section.storage.local");
        Matcher m = Pattern.compile("(\\d+)(\\:)(\\w+)").matcher(sectionCadastral);
        if (m.find()) {
            sectionCadastral = (Integer.parseInt(m.group(1)) + 1) + m.group(2) + m.group(3);
        }
        Properties properties = new Properties();
        properties.put("section.storage.local", sectionCadastral);
        updatePropertiesAtFile(SECTION_PROPERTIES_FILE, properties);
    }
}
