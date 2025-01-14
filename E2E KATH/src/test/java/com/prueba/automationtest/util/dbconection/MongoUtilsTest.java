package com.prueba.automationtest.util.dbconection;

import com.prueba.automationtest.util.ConfigurationParamUtils;
import com.prueba.automationtest.util.EnvironmentConfig;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MongoUtilsTest {

    EnvironmentConfig environmentConfig = new EnvironmentConfig();

    @Test
    public void getMongoUrlString() {
        Map<String, Object> configMap = ConfigurationParamUtils.loadEnviromentalValues("MONGO");
        MongoUtils mongoUtils = new MongoUtils(configMap);
        String mongoUrl = mongoUtils.getMongoUrlString();
        assertEquals(environmentConfig.getVariable("MONGO_EXPECTED_URL"), mongoUrl);
    }
}