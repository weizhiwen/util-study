package com.shixin;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;


public class ConfigurationsTest {
    @Test
    public void test_readProperties() throws ConfigurationException {
        FileBasedConfigurationBuilder<PropertiesConfiguration> builder =
                new FileBasedConfigurationBuilder<>(PropertiesConfiguration.class)
                        .configure(new Parameters().properties()
                                .setFileName("test.properties")
                                .setEncoding("UTF-8"));
        PropertiesConfiguration config = builder.getConfiguration();

        Assertions.assertEquals("张三", config.getString("name"));
        Assertions.assertEquals(18, config.getInt("age"));
    }

    @Test
    public void test_readXml() throws ConfigurationException {
        Configurations configs = new Configurations();
        XMLConfiguration config = configs.xml(new File("test.xml"));

        Assertions.assertEquals("张三", config.getString("name"));
        Assertions.assertEquals(18, config.getInt("age"));
    }
}
